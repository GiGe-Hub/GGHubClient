package com.sophimp.base

import android.content.Context

/**
 * 多模块需要要 在Application 初始化时，实现此接口
 * 然后在壳app中 [BaseApp.registerApp]
 */
interface IApp {
    fun attachBaseContext( base : Context)
    fun onCreate( base : Context)
}