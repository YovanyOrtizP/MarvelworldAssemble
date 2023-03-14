package com.yorpe.MarvelWorldAssemble.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.yorpe.MarvelWorldAssemble.R
import com.yorpe.MarvelWorldAssemble.databinding.FragmentSignInScreenBinding
import com.yorpe.MarvelWorldAssemble.ui.main.MarvelActivity

class SignInScreen : Fragment() {
    private lateinit var binding: FragmentSignInScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var transaction: FragmentTransaction

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInScreenBinding.inflate(inflater,container,false)
        firebaseAuth = FirebaseAuth.getInstance()

        //Sing In to the app
        binding.signInButton.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){

                //Check that the email contains a valid mail
                if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (password.length < 8 || !password.matches(".*[A-Z].*".toRegex())
                        || !password.matches(".*[a-z].*".toRegex()) || !password.matches(".*[@#$%^&*=+].*".toRegex())){
                        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                            if (it.isSuccessful){
                                val intent = Intent(activity, MarvelActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(context,it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(context,
                            "Password must contain least 8 characters: Uppercase,lowercase special characters",
                            Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context,"Please insert a valid email",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context,"Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }

        //Send to sign up
        binding.textViewSignUp.setOnClickListener {
            transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.loginContainer,SignUpScreen())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null){
            val intent = Intent(activity, MarvelActivity::class.java)
            startActivity(intent)
        }
    }
}