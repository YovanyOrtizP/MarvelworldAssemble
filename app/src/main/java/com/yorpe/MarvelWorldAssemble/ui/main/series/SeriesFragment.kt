package com.yorpe.MarvelWorldAssemble.ui.main.series

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
import com.yorpe.MarvelWorldAssemble.data.model.series.ResultSResp
import com.yorpe.MarvelWorldAssemble.data.model.series.SeriesResponse
import com.yorpe.MarvelWorldAssemble.databinding.FragmentSeriesBinding
import com.yorpe.MarvelWorldAssemble.ui.main.viewmodel.GeneralViewModel
import com.yorpe.MarvelWorldAssemble.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment : Fragment() {
    private var _binding: FragmentSeriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: GeneralViewModel by activityViewModels()

    private val mAdapter by lazy {
        SeriesAdapter{
            viewModel.seriesObject = it

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSeriesBinding.inflate(inflater, container, false)


        binding.rvSeries.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = mAdapter
        }

        viewModel.resultSeries.observe(viewLifecycleOwner){
            when(it){
                is ResponseType.LOADING ->{}
                is ResponseType.SUCCESS<SeriesResponse>->{
                    initViews(it.response.data?.results)
                    binding.pbLoading.visibility = View.GONE
                }
                is ResponseType.ERROR ->{
                    Toast.makeText(context,"Series Not Found", Toast.LENGTH_SHORT).show()
                    binding.pbLoading.visibility = View.GONE
                }
                else ->{}
            }
        }

        binding.searchButton.setOnClickListener{
            val searchCharacter = binding.etCharacter.text.toString().trim()
            if(searchCharacter.isNotEmpty()){
                viewModel.flowSeries(searchCharacter)
                hideKeyboard()
                binding.etCharacter.setText("")
            }else{
                viewModel.flowSeries(null)
            }
        }


        viewModel.flowSeries()

        return binding.root
    }

    private fun initViews(data: List<ResultSResp>?){
        data?.let {
            mAdapter.updateSeriesAdapter(it)
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