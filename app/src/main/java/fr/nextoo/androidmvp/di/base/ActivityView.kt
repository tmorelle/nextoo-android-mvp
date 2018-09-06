package fr.nextoo.androidmvp.di.base

interface ActivityView: BaseView {
    fun changeFragment(fragment: BaseFragment<*>)
    fun finish()
}