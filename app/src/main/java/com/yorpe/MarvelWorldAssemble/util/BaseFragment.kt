package com.yorpe.MarvelWorldAssemble.util

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.yorpe.MarvelWorldAssemble.ui.main.viewmodel.GeneralViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment: Fragment() {


    protected val viewModel: GeneralViewModel by lazy {
        ViewModelProvider(requireActivity())[GeneralViewModel::class.java]
    }

    protected fun hideKeyboard() {
        val activity = requireActivity()
        val inputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus ?: View(activity)
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}