package fr.nextoo.androidmvp.di.base

interface FragmentView: BaseView {
    fun changeFragment(fragment: BaseFragment<*>)
    fun changeChildFragment(fragment: BaseChildFragment<*>)
}