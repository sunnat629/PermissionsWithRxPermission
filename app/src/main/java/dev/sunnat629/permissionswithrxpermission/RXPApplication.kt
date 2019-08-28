package dev.sunnat629.permissionswithrxpermission

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree


class RXPApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}