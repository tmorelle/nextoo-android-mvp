package fr.nextoo.androidmvp.secondfragment

import fr.nextoo.androidmvp.di.base.BasePresenter
import fr.nextoo.androidmvp.firstfragment.FirstFragment

class SecondFragmentPresenter(
        view: SecondFragmentView
): BasePresenter<SecondFragmentView>(view) {

    fun onGoFirstClick() {
        view?.changeFragment(FirstFragment.newInstance())
    }
}