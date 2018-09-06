package fr.nextoo.androidmvp.firstchildfragment

import fr.nextoo.androidmvp.di.base.BasePresenter
import fr.nextoo.androidmvp.secondchildfragment.SecondChildFragment

class FirstChildFragmentPresenter(
        view: FirstChildFragmentView
): BasePresenter<FirstChildFragmentView>(view) {

    fun onGoSecondClick() {
        view?.changeChildFragment(SecondChildFragment.newInstance())
    }
}