package fr.nextoo.androidmvp

import android.content.Context
import android.support.multidex.MultiDex
import android.support.v7.app.AppCompatDelegate
import fr.nextoo.androidmvp.di.DaggerAppComponent
import com.crashlytics.android.Crashlytics
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.fabric.sdk.android.Fabric

class NextooMVPApplication: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}