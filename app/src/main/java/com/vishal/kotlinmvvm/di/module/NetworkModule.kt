package com.vishal.kotlinmvvm.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vishal.kotlinmvvm.BuildConfig
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.util.URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Administrator on 1/15/2018.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return URL
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("baseUrl") baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val level = getInterceptorLevel()
        httpLoggingInterceptor.level = level

        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
//                .addInterceptor(ApiKeyInterceptor())
                .build()
    }

    private fun getInterceptorLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MB
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideRequestInterface(retrofit: Retrofit): RequestInterface {
        return retrofit.create(RequestInterface::class.java)
    }
}