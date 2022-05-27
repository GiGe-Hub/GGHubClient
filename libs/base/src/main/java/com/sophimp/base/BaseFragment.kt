package com.sophimp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewbinding.ViewBinding
import com.angcyo.dsladapter.DslAdapter
import com.angcyo.dsladapter.DslItemDecoration
import com.angcyo.dsladapter.DslViewHolder
import com.angcyo.dsladapter.HoverItemDecoration
import com.sophimp.lib.base.R

/**
 *
 * @author: sfx
 * @since: 2021/12/10
 */
abstract class BaseFragment<T : ViewBinding> : Fragment() {

    lateinit var _binding : T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindView()
        initBaseView(_binding.root, savedInstanceState)
        return _binding.root
    }

    abstract fun bindView(): T

    abstract fun initBaseView(rootView: View, savedInstanceState: Bundle?)

    fun show(f: Fragment, hide: Fragment? = null) {
        childFragmentManager.beginTransaction().apply {
            if (f.isAdded) {
                show(f)
                setMaxLifecycle(f, Lifecycle.State.RESUMED)
            } else {
                add(R.id.frame_container_layout, f)
            }
            hide?.let {
                if (it.isAdded) {
                    hide(it)
                    setMaxLifecycle(it, Lifecycle.State.STARTED)
                }
            }
            commitAllowingStateLoss()
        }
    }
}