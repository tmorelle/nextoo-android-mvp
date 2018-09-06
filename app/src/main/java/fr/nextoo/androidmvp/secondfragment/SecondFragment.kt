package fr.nextoo.androidmvp.secondfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nextoo.androidmvp.R
import fr.nextoo.androidmvp.di.base.BaseChildFragment
import fr.nextoo.androidmvp.di.base.BaseFragment
import fr.nextoo.androidmvp.firstchildfragment.FirstChildFragment
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment: BaseFragment<SecondFragmentPresenter>(), SecondFragmentView {
    companion object {
        fun newInstance() = SecondFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_second, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //The default one
        setChildFragment(FirstChildFragment.newInstance(), FirstChildFragment::class.java.simpleName)

        fragment_second_go_first.setOnClickListener { presenter.onGoFirstClick() }
    }

    override fun changeChildFragment(fragment: BaseChildFragment<*>) {
        setChildFragment(fragment, fragment.javaClass.simpleName)
    }

    private fun setChildFragment(f: BaseChildFragment<*>, tag: String) {
        childFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_second_container, f, tag)
                .commit()
    }
}