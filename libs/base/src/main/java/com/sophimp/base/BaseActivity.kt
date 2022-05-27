package com.sophimp.base

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.angcyo.dsladapter.DslAdapter
import com.angcyo.dsladapter.DslViewHolder

/**
 *
 * @author: sfx
 * @since: 2021/8/14
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    lateinit var baseViewHolder: DslViewHolder

    lateinit var dslAdapter: DslAdapter
    lateinit var mContext: Activity
    lateinit var _binding : T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

        dslAdapter = DslAdapter()
        _binding = bindView()
        setContentView(_binding.root)
        baseViewHolder = DslViewHolder(_binding.root)

        initData()

        initListener()

    }

    fun _drawable(@DrawableRes id: Int) = ContextCompat.getDrawable(this, id)

    fun <T : View> find(@IdRes id: Int): T = findViewById(id)

    abstract fun bindView(): T
    abstract fun initData()
    abstract fun initListener()

    open fun renderAdapter(render: DslAdapter.() -> Unit) {
        dslAdapter.render()
    }
}

fun FragmentActivity.show(fragment: Fragment, @IdRes frameLayoutId: Int) {
    supportFragmentManager.show(fragment, frameLayoutId)
}

fun Fragment.show(fragment: Fragment, @IdRes frameLayoutId: Int) {
    childFragmentManager.show(fragment, frameLayoutId)
}

fun FragmentManager.show(fragment: Fragment, @IdRes frameLayoutId: Int) {
    beginTransaction().apply {
        add(frameLayoutId, fragment, fragment.javaClass.simpleName)
        commitNowAllowingStateLoss()
    }
}

fun Context.getDrawable2(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun Fragment.getDrawable(@DrawableRes id: Int): Drawable? {
    return requireContext().getDrawable2(id)
}
