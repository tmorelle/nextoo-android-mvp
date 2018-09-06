package fr.nextoo.androidmvp.firstactivity

import android.os.Bundle
import fr.nextoo.androidmvp.R
import fr.nextoo.androidmvp.di.base.BaseActivity
import fr.nextoo.androidmvp.di.base.BaseFragment
import fr.nextoo.androidmvp.firstfragment.FirstFragment
import fr.nextoo.androidmvp.ws.WSExample
import kotlinx.android.synthetic.main.activity_first.*
import javax.inject.Inject


class FirstActivity: BaseActivity<FirstActivityPresenter>(), FirstActivityView {

    //@Inject
    //lateinit var ws: WSExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        setFragment(FirstFragment.newInstance(), FirstFragment::class.java.simpleName)

        activity_first_go_second.setOnClickListener { presenter.onGoSecondClick() }
    }

    private fun setFragment(fragment: BaseFragment<*>, tag: String) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_first_container, fragment, tag)
                .commit()
    }

    override fun changeFragment(fragment: BaseFragment<*>) {
        setFragment(fragment, fragment.javaClass.simpleName)
    }
}
