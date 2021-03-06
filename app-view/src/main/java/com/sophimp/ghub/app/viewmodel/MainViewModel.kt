package com.sophimp.ghub.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sophimp.ghub.app.bean.HomeBottomTab

/**
 *
 * @author: sfx
 * @since: 2021/12/7
 */
class MainViewModel : ViewModel() {
    val tabItems = MutableLiveData<MutableList<HomeBottomTab>>()

    fun initDefaultTabItems() {
        val defItems = mutableListOf<HomeBottomTab>()
//        defItems.add(HomeBottomTab.GithubItem)
        defItems.add(HomeBottomTab.WorkspaceItem)
        defItems.add(HomeBottomTab.MineItem)
//        tabItems.postValue(defItems)
        tabItems.value = defItems
    }

}