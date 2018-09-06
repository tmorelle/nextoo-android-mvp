package fr.nextoo.androidmvp.firstactivity

import fr.nextoo.androidmvp.di.base.ActivityView
import fr.nextoo.androidmvp.firstactivity.FirstActivityModule.Declarations
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import fr.nextoo.androidmvp.di.annotations.PerFragment
import fr.nextoo.androidmvp.firstfragment.FirstFragment
import fr.nextoo.androidmvp.firstfragment.FirstFragmentModule
import fr.nextoo.androidmvp.secondfragment.SecondFragment
import fr.nextoo.androidmvp.secondfragment.SecondFragmentModule
import fr.nextoo.androidmvp.ws.WSExample

@Module(includes = [Declarations::class])
class FirstActivityModule {
    @Provides
    fun provideMainPresenter(view:FirstActivityView,
                             ws: WSExample) = FirstActivityPresenter(view, ws)


    @Module
    interface Declarations {
        @Binds fun provideMainView(activity: FirstActivity): FirstActivityView
        @Binds fun provideActivityView(activity: FirstActivity): ActivityView


        //Give Access to Fragment
        @PerFragment
        @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
        fun bindFirstFragment(): FirstFragment

        @PerFragment
        @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
        fun bindSecondFragment(): SecondFragment
    }
}