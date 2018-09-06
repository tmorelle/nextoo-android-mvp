package fr.nextoo.androidmvp.firstchildfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nextoo.androidmvp.R
import fr.nextoo.androidmvp.di.base.BaseChildFragment
import kotlinx.android.synthetic.main.child_fragment_first.*

class FirstChildFragment: BaseChildFragment<FirstChildFragmentPresenter>(), FirstChildFragmentView {
    companion object {
        fun newInstance() = FirstChildFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.child_fragment_first, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        child_fragment_first_go_second.setOnClickListener { presenter.onGoSecondClick() }
    }
}