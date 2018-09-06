package fr.nextoo.androidmvp.firstfragment

import fr.nextoo.androidmvp.di.base.BasePresenter
import fr.nextoo.androidmvp.secondfragment.SecondFragment
import fr.nextoo.androidmvp.ws.WSExample

class FirstFragmentPresenter(
        view: FirstFragmentView,
        private val ws: WSExample
): BasePresenter<FirstFragmentView>(view) {
    fun onGoSecondClick() {
        view?.changeFragment(SecondFragment.newInstance())
    }
}