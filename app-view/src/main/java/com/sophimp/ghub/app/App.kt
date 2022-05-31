package com.sophimp.ghub.app

import com.sophimp.base.BaseApp
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * @author: sfx
 * @since: 2021/12/8
 */
@HiltAndroidApp
class App : BaseApp() {
    val TAG = App::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
//        registerModuleApp(AppApplication::class.java)
    }
}