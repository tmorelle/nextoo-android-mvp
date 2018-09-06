package fr.nextoo.androidmvp.secondchildfragment

import fr.nextoo.androidmvp.di.base.BasePresenter
import fr.nextoo.androidmvp.firstchildfragment.FirstChildFragment

class SecondChildFragmentPresenter(
        view: SecondChildFragmentView
): BasePresenter<SecondChildFragmentView>(view) {

    fun onGoFirst() {
        view?.changeChildFragment(FirstChildFragment.newInstance())
    }
}