package com.sophimp.ghub.app.fragment

import android.os.Bundle
import android.view.View
import com.sophimp.base.BaseFragment
import com.sophimp.ghub.app.R
import com.sophimp.ghub.app.databinding.FragmentMainBinding

/**
 *
 * @author: sfx
 * @since: 2021/12/13
 */
class MainFragment : BaseFragment<FragmentMainBinding>() {

    override fun bindView(): FragmentMainBinding {
        return FragmentMainBinding.inflate(layoutInflater)
    }

    override fun initBaseView(rootView: View, savedInstanceState: Bundle?) {
    }
}