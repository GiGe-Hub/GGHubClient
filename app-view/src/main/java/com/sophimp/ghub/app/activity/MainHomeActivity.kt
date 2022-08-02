package com.sophimp.ghub.app.activity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.sophimp.base.BaseTitleActivity
import com.sophimp.ghub.app.adapter.HomePagerAdapter
import com.sophimp.ghub.app.bean.HomeBottomTab
import com.sophimp.ghub.app.databinding.ActivityMainHomeBinding
import com.sophimp.ghub.app.databinding.BottomTabItemBinding
import com.sophimp.ghub.app.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHomeActivity : BaseTitleActivity<ActivityMainHomeBinding>() {
    val viewModel by viewModels<MainViewModel>()

    var itemBindings = mutableListOf<BottomTabItemBinding>()
    override fun initData() {
//        val viewModelProvider = ViewModelProvider(this)
//        viewModel = viewModelProvider.get(MainViewModel::class.java)
        _binding.tlBottom.itemIsEquWidth = true

        val fragments = mutableListOf<Fragment>()
        viewModel.tabItems.observe(this) { tabItems ->
            tabItems.forEach { itemTab ->
                // init tabItem
                val itemBind = BottomTabItemBinding.inflate(layoutInflater, null, false)
                initBottomItem(itemBind, itemTab)
                itemBindings.add(itemBind)
                _binding.tlBottom.addView(itemBind.root)
                fragments.add(itemTab.fragment)
            }
        }

        _binding.tlBottom.configTabLayoutConfig {
            tabEnableGradientColor = true
            tabEnableTextBold = true
            tabEnableGradientScale = true
            tabSelectColor = resources.getColor(com.sophimp.lib.base.R.color.colorPrimary)
            tabMaxScale = 1.0f
            // select listener
            onSelectItemView = { itemView, index, select, fromUser ->
                if (select) {
                    handleBottomTabClick(index)
                    _binding.tlBottom.onPageSelected(index)
                }
                true
            }
        }

        viewModel.initDefaultTabItems()

//        baseViewHolder.v<DslTabLayout>(R.id.jumpToEnd)

        _binding.vp2Home.isUserInputEnabled = false
        _binding.vp2Home.adapter = HomePagerAdapter(fragments, this)

    }

    private fun initBottomItem(itemBind: BottomTabItemBinding, itemTab: HomeBottomTab) {
        when (itemTab) {
//            HomeBottomTab.GithubItem -> {
//                HomeBottomTab.GithubItem.apply {
//                    itemBind.ivBottomTabIcon.setImageResource(iconResId)
//                    itemBind.tvTabName.setText(nameRes)
//                }
//            }
            HomeBottomTab.WorkspaceItem -> {
                HomeBottomTab.WorkspaceItem.apply {
                    itemBind.ivBottomTabIcon.setImageResource(iconResId)
                    itemBind.tvTabName.setText(nameRes)
                }
            }
            HomeBottomTab.MineItem -> {
                HomeBottomTab.MineItem.apply {
                    itemBind.ivBottomTabIcon.setImageResource(iconResId)
                    itemBind.tvTabName.setText(nameRes)
                }
            }
        }
    }

    private fun handleBottomTabClick(itemTabIndex: Int) {
        _binding.vp2Home.currentItem = itemTabIndex
        Toast.makeText(this, "index $itemTabIndex", Toast.LENGTH_SHORT).show()
    }

    override fun initListener() {

    }

    override fun bindView(): ActivityMainHomeBinding {
        return ActivityMainHomeBinding.inflate(layoutInflater)
    }

}