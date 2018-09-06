package fr.nextoo.androidmvp.secondactivity

import fr.nextoo.androidmvp.di.base.BasePresenter
import fr.nextoo.androidmvp.firstactivity.FirstActivity

class SecondActivityPresenter(
        v:SecondActivityView
): BasePresenter<SecondActivityView>(v) {

    fun onGoFirstClick() {
        //You can pass extras bundle in the methods
        view?.changeActivity(FirstActivity::class.java, extras = null) {
            //you can custom intent here
        }
    }
}