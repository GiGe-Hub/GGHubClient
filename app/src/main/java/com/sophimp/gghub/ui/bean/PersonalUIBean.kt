package com.sophimp.gghub.ui.bean

data class PersonalUIBean(
    var name: String,
    var icon: String?,
    var des: String?,
    var email: String?,
    var link: String?,
    var followers: Long,
    var followings: Long,
    var location: String? = "",
    var organization: String? = "",
)
