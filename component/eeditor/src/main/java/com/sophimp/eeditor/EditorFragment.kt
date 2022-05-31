package com.sophimp.eeditor

import android.os.Bundle
import android.view.View
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

    }
}