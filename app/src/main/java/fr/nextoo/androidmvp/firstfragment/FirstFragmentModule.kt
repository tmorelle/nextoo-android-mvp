package fr.nextoo.androidmvp.firstfragment

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import fr.nextoo.androidmvp.di.annotations.PerChildFragment
import fr.nextoo.androidmvp.di.base.FragmentView
import fr.nextoo.androidmvp.firstchildfragment.FirstChildFragment
import fr.nextoo.androidmvp.firstchildfragment.FirstChildFragmentModule
import fr.nextoo.androidmvp.secondchildfragment.SecondChildFragment
import fr.nextoo.androidmvp.secondchildfragment.SecondChildFragmentModule
import fr.nextoo.androidmvp.ws.WSExample

@Module(includes = [FirstFragmentModule.Declarations::class])
class FirstFragmentModule {
    @Provides
    fun provideFirstFragmentPresenter(view: FirstFragmentView,
                                      ws: WSExample) = FirstFragmentPresenter(view, ws)


    @Module
    interface Declarations {
        @Binds fun provideFirstFragmentView(fragment: FirstFragment): FirstFragmentView
        @Binds fun provideParentFragmentView(fragment: FirstFragment): FragmentView

        //Give Access to child
        @PerChildFragment
        @ContributesAndroidInjector(modules = [FirstChildFragmentModule::class])
        fun bindFirstChildFragment(): FirstChildFragment

        @PerChildFragment
        @ContributesAndroidInjector(modules = [SecondChildFragmentModule::class])
        fun bindSecondChildFragment(): SecondChildFragment
    }
}