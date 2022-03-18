package com.gghub.api.restful.model

import com.gghub.api.restful.model.ui.UserUIModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * app全局数据对象
 * Created by guoshuyu
 * Date: 2018-10-19
 */
@Singleton
class AppGlobalModel @Inject constructor() {
    val userObservable = UserUIModel()
}