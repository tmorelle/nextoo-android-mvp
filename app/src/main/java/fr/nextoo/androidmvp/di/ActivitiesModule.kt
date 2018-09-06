package fr.nextoo.androidmvp.di

import fr.nextoo.androidmvp.firstactivity.FirstActivity
import fr.nextoo.androidmvp.firstactivity.FirstActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.nextoo.androidmvp.di.annotations.PerActivity
import fr.nextoo.androidmvp.secondactivity.SecondActivity
import fr.nextoo.androidmvp.secondactivity.SecondActivityModule

@Module
abstract class ActivitiesModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [FirstActivityModule::class])
    abstract fun bindMainActivity(): FirstActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun bindSecondActivity(): SecondActivity
}