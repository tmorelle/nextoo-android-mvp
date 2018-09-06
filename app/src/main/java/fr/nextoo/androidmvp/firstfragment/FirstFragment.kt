package fr.nextoo.androidmvp.firstfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nextoo.androidmvp.R
import fr.nextoo.androidmvp.di.base.BaseChildFragment
import fr.nextoo.androidmvp.di.base.BaseFragment
import fr.nextoo.androidmvp.firstchildfragment.FirstChildFragment
import fr.nextoo.androidmvp.ws.WSExample
import kotlinx.android.synthetic.main.fragment_first.*
import javax.inject.Inject


class FirstFragment: BaseFragment<FirstFragmentPresenter>(), FirstFragmentView {
    companion object {
        fun newInstance() = FirstFragment()
    }

    //@Inject
    //lateinit var ws: WSExample

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //The default one
        setChildFragment(FirstChildFragment.newInstance(), FirstChildFragment::class.java.simpleName)

        fragment_first_go_second.setOnClickListener { presenter.onGoSecondClick() }
    }

    override fun changeChildFragment(fragment: BaseChildFragment<*>) {
        setChildFragment(fragment, fragment.javaClass.simpleName)
    }

    private fun setChildFragment(f: BaseChildFragment<*>, tag: String) {
        childFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_first_container, f, tag)
                .commit()
    }
}