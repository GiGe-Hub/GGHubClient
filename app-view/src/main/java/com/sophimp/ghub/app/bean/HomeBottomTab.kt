package com.sophimp.ghub.app.bean

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.sophimp.eeditor.EditorFragment
import com.sophimp.ghub.app.R

/**
 *
 * @author: sfx
 * @since: 2021/12/8
 */
enum class HomeBottomTab(@StringRes val nameRes: Int, @DrawableRes val iconResId: Int, var msgCount: Int = 0, val fragment : Fragment) {
//    GithubItem(R.string.github, R.mipmap.ic_github_black, 0, GithubMainFragment()),
    WorkspaceItem(R.string.workspace, R.mipmap.ic_read_and_write, 0, EditorFragment()),
    MineItem(R.string.mine, R.mipmap.ic_explore, 0, GhubMineFragment())
}
