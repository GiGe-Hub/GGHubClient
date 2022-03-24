package com.gghub.api.restful.model.bean

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * 通知相关
 */
class Notification {
    var id: String? = null
    var unread: Boolean = false
    var reason: String? = null
    @SerializedName("updated_at")
    var updateAt: Date? = null
    @SerializedName("last_read_at")
    var lastReadAt: Date? = null
    var repository: Repository? = null
    var subject: NotificationSubject? = null
}