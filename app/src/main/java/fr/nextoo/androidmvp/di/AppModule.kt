package fr.nextoo.androidmvp.di

import android.content.Context
import fr.nextoo.androidmvp.NextooMVPApplication
import dagger.Binds
import dagger.Module
import fr.nextoo.androidmvp.di.annotations.ApplicationContext

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    abstract fun provideApplicationContext(application: NextooMVPApplication): Context
}