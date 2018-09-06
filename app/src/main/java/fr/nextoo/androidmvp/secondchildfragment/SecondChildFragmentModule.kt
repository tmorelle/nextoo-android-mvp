package fr.nextoo.androidmvp.secondchildfragment

import dagger.Binds
import dagger.Module
import dagger.Provides
import fr.nextoo.androidmvp.di.base.ChildFragmentView

@Module(includes = [SecondChildFragmentModule.Declarations::class])
class SecondChildFragmentModule {
    @Provides
    fun provideSecondChildFragmentPresenter(view: SecondChildFragmentView) = SecondChildFragmentPresenter(view)


    @Module
    interface Declarations {
        @Binds fun provideSecondChildFragmentView(fragment: SecondChildFragment): SecondChildFragmentView
        @Binds fun provideChildFragmentView(fragment: SecondChildFragment): ChildFragmentView

    }
}