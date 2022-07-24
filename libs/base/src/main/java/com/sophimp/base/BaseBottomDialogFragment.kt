package com.sophimp.base

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * fragment底部弹窗
 */
open abstract class BaseBottomDialogFragment<T : ViewBinding> : BottomSheetDialogFragment() {

    lateinit protected var _binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindView()
        initBaseView(_binding.root, savedInstanceState)
        return _binding.root
    }

    abstract fun initBaseView(rootView: View, savedInstanceState: Bundle?)

    abstract fun bindView(): T

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (dialog != null) {
            dialog!!.setOnKeyListener(DialogInterface.OnKeyListener { dialog, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                    onBackPressed()
                    return@OnKeyListener true
                }
                false
            })
        }
    }

    open protected fun onBackPressed() {
        dismiss()
    }
}