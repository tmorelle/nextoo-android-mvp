package fr.nextoo.androidmvp.secondactivity

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import fr.nextoo.androidmvp.di.annotations.PerFragment
import fr.nextoo.androidmvp.di.base.ActivityView
import fr.nextoo.androidmvp.firstfragment.FirstFragment
import fr.nextoo.androidmvp.firstfragment.FirstFragmentModule
import fr.nextoo.androidmvp.secondfragment.SecondFragment
import fr.nextoo.androidmvp.secondfragment.SecondFragmentModule

@Module(includes = [SecondActivityModule.Declarations::class])
class SecondActivityModule {
    @Provides
    fun provideSecondActivityPresenter(view: SecondActivityView) = SecondActivityPresenter(view)


    @Module
    interface Declarations {
        @Binds
        fun provideSecondActivityView(activity: SecondActivity): SecondActivityView
        @Binds
        fun provideActivityView(activity: SecondActivity): ActivityView

        //Give Access to Fragment
        @PerFragment
        @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
        fun bindFirstFragment(): FirstFragment

        @PerFragment
        @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
        fun bindSecondFragment(): SecondFragment
    }
}