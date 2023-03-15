package com.yorpe.MarvelWorldAssemble.ui.main.characters

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yorpe.MarvelWorldAssemble.data.model.characters.CharactersResponse
import com.yorpe.MarvelWorldAssemble.data.model.characters.ResultCResp
import com.yorpe.MarvelWorldAssemble.databinding.FragmentCharactersBinding
import com.yorpe.MarvelWorldAssemble.ui.main.viewmodel.GeneralViewModel
import com.yorpe.MarvelWorldAssemble.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GeneralViewModel by activityViewModels()


    private val mAdapter by lazy {
        CharactersAdapter {
            viewModel.charObject = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)

        binding.rvCharacters.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
        }

        viewModel.resultCharacters.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseType.LOADING -> {}
                is ResponseType.SUCCESS<CharactersResponse> -> {
                    initViews(it.response.data?.results)
                    binding.pbLoading.visibility = View.GONE
                }
                is ResponseType.ERROR -> {
                    Toast.makeText(context,"Character Not Found",Toast.LENGTH_SHORT).show()
                    binding.pbLoading.visibility = View.GONE
                }
            }
        }
        //Displaying characters for first time
        viewModel.flowCharacters()

        //When the user wants to search an specific character, call the function
        binding.searchButton.setOnClickListener {
            searchCharacter()
        }

        //Function to do swipe to refresh
        swipeRefresh()

        return binding.root
    }

    private fun initViews(data: List<ResultCResp>?) {
        data?.let {
            mAdapter.updateCharactersAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun swipeRefresh() {
        binding.swipeCharacters.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeCharacters.isRefreshing = false
            }, 1500)
            viewModel.flowCharacters()
        }
    }

    private fun searchCharacter() {
        val searchCharacter = binding.etCharacter.text.toString().trim()
        if (searchCharacter.isNotEmpty()) {
            hideKeyboard()
            binding.etCharacter.setText("")
            binding.pbLoading.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                viewModel.flowCharacters(searchCharacter)
            }, 1500)
        }
    }

    private fun hideKeyboard() {
        val activity = requireActivity()
        val inputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus ?: View(activity)
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}