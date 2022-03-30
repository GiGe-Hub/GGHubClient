package com.sophimp.gghub.ui.bean

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.sophimp.gghub.R
import com.sophimp.gghub.ui.screen.ExploreScreen
import com.sophimp.gghub.ui.screen.FollowingActivitiesScreen
import com.sophimp.gghub.ui.screen.ProfileScreen

/**
 *
 * @author: sfx
 * @since: 2021/12/8
 */
data class TabDataBean(
    @StringRes val nameRes: Int,
    @DrawableRes val iconResId: Int,
    var msgCount: Int = 0,
    val page: @Composable () -> Unit
)

val homeTabs: List<TabDataBean> = listOf(
    TabDataBean(
        R.string.following, R.mipmap.ic_following_activity, 0
    ) {
        FollowingActivitiesScreen()
    },
    TabDataBean(R.string.explore, R.mipmap.ic_read_and_write, 0) {
        ExploreScreen()
    },
    TabDataBean(R.string.profile, R.mipmap.ic_github_black, 0) {
        ProfileScreen()
    }
)