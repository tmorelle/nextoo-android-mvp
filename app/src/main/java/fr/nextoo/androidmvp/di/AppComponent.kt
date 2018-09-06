package fr.nextoo.androidmvp.di

import fr.nextoo.androidmvp.NextooMVPApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    WebServiceModule::class,
    ActivitiesModule::class
])
interface AppComponent: AndroidInjector<NextooMVPApplication> {

    override fun inject(instance: NextooMVPApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: NextooMVPApplication): Builder

        fun build(): AppComponent
    }
}