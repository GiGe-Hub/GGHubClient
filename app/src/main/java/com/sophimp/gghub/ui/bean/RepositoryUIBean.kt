package com.sophimp.gghub.ui.bean

/**
 * @author sfx
 * @date 2022/4/20
 */
data class RepositoryUIBean(
    var name : String,
    var stars : Long,
    var description : String,
    var language: String?
) {
}
