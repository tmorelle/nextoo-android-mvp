package fr.nextoo.androidmvp.di.base

import android.support.annotation.CallSuper
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference

open class BasePresenter<T: BaseView>(v:T) {
    val view:T? by lazy { targetView.get() }

    private val targetView: WeakReference<T?> = WeakReference(v)
    private val compositeDisposable = CompositeDisposable()

    //Override the default behavior
    @CallSuper open fun onCreate() { }
    @CallSuper open fun onStart() { }
    @CallSuper open fun onResume() { }
    @CallSuper open fun onPause() { }
    @CallSuper open fun onStop() { }

    @CallSuper
    open fun onDestroy() {
        compositeDisposable.clear()
    }

    protected fun addDisposable(d: Disposable) {
        compositeDisposable.add(d)
    }

    protected fun <T> applySchedulers(): SingleTransformer<T, T> = SingleTransformer { single ->
        single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    compositeDisposable.add(it)
                }
    }

    protected fun <T> applyObservableSchedulers(): ObservableTransformer<T, T> = ObservableTransformer { observable ->
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    compositeDisposable.add(it)
                }
    }
}