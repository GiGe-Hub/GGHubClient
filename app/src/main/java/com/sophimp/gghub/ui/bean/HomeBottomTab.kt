package com.sophimp.gghub.ui.bean

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sophimp.gghub.R

/**
 *
 * @author: sfx
 * @since: 2021/12/8
 */
data class HomeBottomTab(
    @StringRes val nameRes: Int,
    @DrawableRes val iconResId: Int,
    var msgCount: Int = 0
)

val homeTabs: List<HomeBottomTab> = listOf(
    HomeBottomTab(R.string.github, R.mipmap.ic_github_black, 0),
    HomeBottomTab(R.string.workspace, R.mipmap.ic_read_and_write, 0),
    HomeBottomTab(R.string.mine, R.mipmap.ic_explore, 0)
)
