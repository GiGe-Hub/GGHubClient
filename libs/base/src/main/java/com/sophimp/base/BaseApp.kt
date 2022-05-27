package com.sophimp.base

import android.app.Application
import android.content.Context
import com.sophimp.lib.base.R
//import org.acra.config.dialog
//import org.acra.config.mailSender
//import org.acra.data.StringFormat
//import org.acra.ktx.initAcra

/**
 * Custom Application Singleton
 */
open class BaseApp : Application() {
    private val moduleApps = hashMapOf<Class<out IApp>, IApp>()

    companion object {
        private lateinit var instance : BaseApp
        val context: Context
            get() = instance.applicationContext

        fun <T : IApp> getModuleApp(moduleAppClz: Class<T>) : T{
            return instance.moduleApps[moduleAppClz] as T
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)

//        initAcra {
//            //core configuration:
////            buildConfigClass = BuildConfig::class.java
//            reportFormat = StringFormat.JSON
//            // each plugin you chose above can be configured in a block like this:
//            dialog {
//                text = getString(R.string.dialog_error_send_report)
//                //opening this block automatically enables the plugin.
//            }
//            mailSender {
//                withMailTo(getString(R.string.crash_report_email))
//            }
//        }

        // init each module applications
        moduleApps.values.forEach { app ->
            app.attachBaseContext(base)
        }
    }

    /**
     * call after super.onCreate in app application
     */
    fun <T : IApp> registerModuleApp(moduleAppClz: Class<T>) {
        if (!moduleApps.containsKey(moduleAppClz)) {
            moduleApps[moduleAppClz] = moduleAppClz.newInstance()
            moduleApps[moduleAppClz]?.onCreate(applicationContext)
        }
    }

}
