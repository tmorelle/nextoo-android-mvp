package fr.nextoo.androidmvp.firstactivity

import android.util.Log
import fr.nextoo.androidmvp.di.base.BasePresenter
import fr.nextoo.androidmvp.secondactivity.SecondActivity
import fr.nextoo.androidmvp.ws.WSExample

class FirstActivityPresenter(
        view: FirstActivityView,
        private val ws: WSExample
): BasePresenter<FirstActivityView>(view) {
    companion object {
        private val TAG = FirstActivityPresenter::class.java.simpleName
    }

    override fun onResume() {
        super.onResume()

       /* ws.getSomething()
                .compose(applySchedulers())
                .subscribe({

                }, { t -> Log.e(TAG, "Error on request", t) } )*/
    }

    fun onGoSecondClick() {
        //You can pass extras bundle in the methods
        view?.changeActivity(SecondActivity::class.java, extras = null) {
            //you can custom intent here
        }
    }
}