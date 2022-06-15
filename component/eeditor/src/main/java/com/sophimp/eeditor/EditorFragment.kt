package com.sophimp.eeditor

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sophimp.base.BaseFragment
import com.sophimp.eeditor.databinding.FragmentEditorBinding

/**
 *
 * @author: sfx
 * @since: 2021/9/28
 */
class EditorFragment : BaseFragment<FragmentEditorBinding>() {

    override fun bindView(): FragmentEditorBinding {
        return FragmentEditorBinding.inflate(layoutInflater)
    }

    override fun initBaseView(rootView: View, savedInstanceState: Bundle?) {
        _binding.eeditor.layoutManager = LinearLayoutManager(context)
        val datasources = mutableListOf<String>()
        for (i in 1 until 20) {
            datasources.add("")
        }
        val adapter = ExEditorAdapter(datasources)
        _binding.eeditor.adapter = adapter
        adapter.newLineListener = object : OnNewLineListener{
            override fun onNewLine(pos: Int, offset: Int) {
                val layoutManager = _binding.eeditor.layoutManager as LinearLayoutManager
//                layoutManager.scrollToPositionWithOffset(pos, offset)
            }
        }
    }
}