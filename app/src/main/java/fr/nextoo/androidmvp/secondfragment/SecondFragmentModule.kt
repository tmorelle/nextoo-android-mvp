package fr.nextoo.androidmvp.secondfragment

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

@Module(includes = [SecondFragmentModule.Declarations::class])
class SecondFragmentModule {
    @Provides
    fun provideSecondFragmentPresenter(view: SecondFragmentView) = SecondFragmentPresenter(view)


    @Module
    interface Declarations {
        @Binds fun provideSecondFragmentView(fragment: SecondFragment): SecondFragmentView
        @Binds fun provideFragmentView(fragment: SecondFragment): FragmentView

        //Give Access to child
        @PerChildFragment
        @ContributesAndroidInjector(modules = [FirstChildFragmentModule::class])
        fun bindFirstChildFragment(): FirstChildFragment

        @PerChildFragment
        @ContributesAndroidInjector(modules = [SecondChildFragmentModule::class])
        fun bindSecondChildFragment(): SecondChildFragment
    }
}