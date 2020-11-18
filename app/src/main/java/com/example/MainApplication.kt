package com.example

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * @Author: liYuan
 * @Date: 2020/11/12 5:31 PM
 * @Description:
 */
class MainApplication : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }
}