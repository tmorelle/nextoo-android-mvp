package fr.nextoo.androidmvp.di.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<T: BasePresenter<*>>: DaggerFragment(), FragmentView {
    @Inject
    lateinit var presenter:T

    @Inject
    lateinit var parentActivity: ActivityView

    @CallSuper
    override fun changeFragment(fragment: BaseFragment<*>) {
        parentActivity.changeFragment(fragment)
    }

    override fun changeChildFragment(fragment: BaseChildFragment<*>) {
        //Override it if you have child fragment in this fragment
    }

    @CallSuper
    override fun changeActivity(classActivity: Class<out BaseActivity<*>>, finishActivity: Boolean, extras: Bundle?, intentEditor: ((Intent) -> Unit)?) {
        parentActivity.changeActivity(classActivity, finishActivity, extras, intentEditor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}