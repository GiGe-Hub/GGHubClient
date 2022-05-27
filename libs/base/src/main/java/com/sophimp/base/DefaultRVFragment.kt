package com.sophimp.base

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.angcyo.dsladapter.DslAdapter
import com.angcyo.dsladapter.DslItemDecoration
import com.angcyo.dsladapter.DslViewHolder
import com.angcyo.dsladapter.HoverItemDecoration
import com.sophimp.lib.base.R
import com.sophimp.lib.base.databinding.FragmentDefaultDslBinding

/**
 * DslAdapter 的默认实现
 * create by sfx on 2022/2/10 13:59
 */
open class DefaultRVFragment : BaseFragment<FragmentDefaultDslBinding>() {

    var orientation = LinearLayout.VERTICAL

    lateinit var baseViewHolder: DslViewHolder
    lateinit var dslAdapter: DslAdapter

    /**提供悬停功能*/
    var hoverItemDecoration = HoverItemDecoration()

    /**提供基本的分割线功能*/
    var baseDslItemDecoration = DslItemDecoration()

    override fun bindView(): FragmentDefaultDslBinding {
        return FragmentDefaultDslBinding.inflate(layoutInflater)
    }

    override fun initBaseView(rootView: View, savedInstanceState: Bundle?) {
        baseViewHolder = DslViewHolder(rootView)

        dslAdapter = DslAdapter()
        baseViewHolder.rv(R.id.rv_dsl_default)?.apply {
            layoutManager = LinearLayoutManager(
                context,
                orientation,
                false
            )
            adapter = dslAdapter
            addItemDecoration(baseDslItemDecoration)
            hoverItemDecoration.attachToRecyclerView(this)
        }
    }

    fun renderAdapter(render: DslAdapter.() -> Unit) {
        dslAdapter.render()
    }

}