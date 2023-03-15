package com.yorpe.MarvelWorldAssemble.ui.main.comics

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yorpe.MarvelWorldAssemble.data.model.comics.ComicsResponse
import com.yorpe.MarvelWorldAssemble.data.model.comics.ResultComRes
import com.yorpe.MarvelWorldAssemble.databinding.FragmentComicsBinding
import com.yorpe.MarvelWorldAssemble.ui.main.viewmodel.GeneralViewModel
import com.yorpe.MarvelWorldAssemble.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : Fragment() {
    private var _binding: FragmentComicsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GeneralViewModel by activityViewModels()

    private val mAdapter by lazy {
        ComicsAdapter {
            viewModel.comicsObject = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentComicsBinding.inflate(inflater,container,false)

        binding.rvComics.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
        }

        viewModel.resultComics.observe(viewLifecycleOwner){
            when(it){
                is ResponseType.LOADING ->{}
                is ResponseType.SUCCESS<ComicsResponse>->{
                    initViews(it.response.data?.results)
                    binding.pbLoading.visibility = View.GONE
                }
                is ResponseType.ERROR ->{
                    Toast.makeText(context,"Comics Not Found", Toast.LENGTH_SHORT).show()
                    binding.pbLoading.visibility = View.GONE
                }
            }
        }

        binding.searchButton.setOnClickListener{
            val searchCharacter = binding.etCharacter.text.toString().trim()
            if(searchCharacter.isNotEmpty()){
                viewModel.flowComics(searchCharacter)
                hideKeyboard()
                binding.etCharacter.setText("")
            }else{
                viewModel.flowComics(null)
            }
        }

        viewModel.flowComics()

        return binding.root
    }

    private fun initViews(data: List<ResultComRes>?){
        data?.let {
            mAdapter.updateComicsAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding =  null
    }

    private fun hideKeyboard(){
        val activity = requireActivity()
        val inputMethodManager = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus ?: View(activity)
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }
}