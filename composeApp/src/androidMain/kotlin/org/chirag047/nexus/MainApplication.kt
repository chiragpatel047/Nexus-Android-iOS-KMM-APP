package org.chirag047.nexus

import KoinInitializer
import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KoinInitializer(applicationContext).init()

    }
}