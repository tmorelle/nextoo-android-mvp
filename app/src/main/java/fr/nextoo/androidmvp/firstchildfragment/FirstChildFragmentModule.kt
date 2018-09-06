package fr.nextoo.androidmvp.firstchildfragment

import dagger.Binds
import dagger.Module
import dagger.Provides
import fr.nextoo.androidmvp.di.base.ChildFragmentView

@Module(includes = [FirstChildFragmentModule.Declarations::class])
class FirstChildFragmentModule {
    @Provides
    fun provideFirstChildFragmentPresenter(view: FirstChildFragmentView) = FirstChildFragmentPresenter(view)


    @Module
    interface Declarations {
        @Binds fun provideFirstChildFragmentView(fragment: FirstChildFragment): FirstChildFragmentView
        @Binds fun provideChildFragmentView(fragment: FirstChildFragment): ChildFragmentView

    }
}