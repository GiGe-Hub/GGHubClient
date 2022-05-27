package com.sophimp.base

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.angcyo.dsladapter.DslAdapter
import com.angcyo.dsladapter.DslItemDecoration
import com.angcyo.dsladapter.DslViewHolder
import com.angcyo.dsladapter.HoverItemDecoration
import com.sophimp.lib.base.R
import com.sophimp.lib.base.databinding.FragmentDefaultCoordinateBinding

/**
 *
 * CoordinateLayout + AppBarLayout + RecyclerView实现
 *
 * create by sfx on 2022/2/12 15:32
 */
open class DefaultCoordinateFragment : BaseFragment<FragmentDefaultCoordinateBinding>() {

    lateinit var dslViewHolder: DslViewHolder
    lateinit var dslAdapter: DslAdapter

    /**提供悬停功能*/
    var hoverItemDecoration = HoverItemDecoration()

    /**提供基本的分割线功能*/
    var baseDslItemDecoration = DslItemDecoration()

    override fun bindView(): FragmentDefaultCoordinateBinding {
        return FragmentDefaultCoordinateBinding.inflate(layoutInflater)
    }

    override fun initBaseView(rootView: View, savedInstanceState: Bundle?) {

        dslViewHolder = DslViewHolder(rootView)

        dslAdapter = DslAdapter()
        _binding.rvCoordinateDefault.apply {
            addItemDecoration(baseDslItemDecoration)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = dslAdapter
            hoverItemDecoration.attachToRecyclerView(this)
        }

        _binding.baseRefreshLayout.apply {
            setOnRefreshListener {
                onRefresh()
            }
        }
    }

    open fun onRefresh() {
//        Toast.makeText(this, "刷新", Toast.LENGTH_SHORT).show()
        dslViewHolder.postDelay(1000) {
            _binding.baseRefreshLayout.isRefreshing = false
        }
    }

    fun renderAdapter(render: DslAdapter.() -> Unit) {
        dslAdapter.render()
    }

}