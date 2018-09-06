package fr.nextoo.androidmvp.di.base

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity<T: BasePresenter<*>>: DaggerAppCompatActivity(), ActivityView {
    companion object {
        private val TAG = BaseActivity::class.java.simpleName
    }

    @Inject
    lateinit var presenter:T

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

    override fun changeActivity(classActivity: Class<out BaseActivity<*>>, finishActivity: Boolean, extras: Bundle?, intentEditor: ((Intent) -> Unit)?) {
        val i = Intent(this, classActivity)
        extras?.let { i.putExtras(extras) }
        intentEditor?.invoke(i)

        startActivity(i)
        if(finishActivity) {
            finish()
        }
    }

    override fun changeFragment(fragment: BaseFragment<*>) {
        //Override it if you have fragment in this fragment
    }
}