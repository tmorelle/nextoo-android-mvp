package fr.nextoo.androidmvp.okhttp

import okhttp3.OkHttpClient
import okhttp3.ConnectionSpec
import okhttp3.TlsVersion
import android.os.Build
import android.util.Log
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
import okhttp3.logging.HttpLoggingInterceptor
import java.security.KeyStore
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.TrustManager


class OkHttpUtils {
    companion object {
        fun createHttpClientBuilder(): OkHttpClient.Builder {
            return OkHttpClient.Builder()
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
        }
    }
}
