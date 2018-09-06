package fr.nextoo.androidmvp.di.base

import android.content.Intent
import android.os.Bundle

interface BaseView {
    fun changeActivity(classActivity: Class<out BaseActivity<*>>, finishActivity:Boolean = true, extras: Bundle? = null, intentEditor: ((Intent) -> Unit)? = null)
}