package fr.nextoo.androidmvp.di

import fr.nextoo.androidmvp.okhttp.OkHttpUtils
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import fr.nextoo.androidmvp.ws.WSExample
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.Body
import javax.inject.Singleton

@Module
class WebServiceModule {
    @Provides @Singleton @IntoSet
    fun provideAuthorizationInterceptor(): Interceptor = Interceptor { chain -> chain.proceed(chain.request().newBuilder().header("Authorization", "").build()) }

    @Provides @Singleton @IntoSet
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton @Provides
    fun provideOkHttpClientBuilder(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient.Builder {
        val builder = OkHttpUtils.createHttpClientBuilder()
        interceptors.forEach { builder.addInterceptor(it) }
        return builder
    }

    @Provides @Singleton
    fun provideRetrofit(okHttpClientBuilder: OkHttpClient.Builder):Retrofit = Retrofit.Builder()
                .baseUrl("https://google.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build()

    @Provides @Singleton
    fun provideWSExample(retrofit: Retrofit):WSExample = retrofit.create(WSExample::class.java)
}