package fr.nextoo.androidmvp.glide

import android.content.Context
import fr.nextoo.androidmvp.okhttp.OkHttpUtils

import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule

import java.io.InputStream

@GlideModule
class NextooMVPGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(OkHttpUtils.createHttpClientBuilder().build()))
    }
}
