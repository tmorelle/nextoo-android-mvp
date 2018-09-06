package fr.nextoo.androidmvp.secondactivity

import android.os.Bundle
import fr.nextoo.androidmvp.R
import fr.nextoo.androidmvp.di.base.BaseActivity
import fr.nextoo.androidmvp.di.base.BaseFragment
import fr.nextoo.androidmvp.firstfragment.FirstFragment
import fr.nextoo.androidmvp.ws.WSExample
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity: BaseActivity<SecondActivityPresenter>(), SecondActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //The default fragment
        setFragment(FirstFragment.newInstance(), FirstFragment::class.java.simpleName)

        activity_second_go_first.setOnClickListener { presenter.onGoFirstClick() }
    }

    override fun changeFragment(fragment: BaseFragment<*>) {
        setFragment(fragment, fragment.javaClass.simpleName)
    }

    private fun setFragment(fragment: BaseFragment<*>, tag: String) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_second_container, fragment, tag)
                .commit()
    }
}