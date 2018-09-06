package fr.nextoo.androidmvp.secondchildfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fr.nextoo.androidmvp.R
import fr.nextoo.androidmvp.di.base.BaseChildFragment
import kotlinx.android.synthetic.main.child_fragment_second.*

class SecondChildFragment: BaseChildFragment<SecondChildFragmentPresenter>(), SecondChildFragmentView {
    companion object {
        fun newInstance() = SecondChildFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.child_fragment_second, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        child_fragment_second_go_first.setOnClickListener { presenter.onGoFirst() }
    }
}