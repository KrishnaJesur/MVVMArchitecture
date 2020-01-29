package com.krishna.kotlinlist.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.krishna.kotlinlist.BuildConfig
import com.krishna.kotlinlist.util.HEADER_ACCESS_TOKEN
import com.krishna.kotlinlist.util.Preferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiProvider {

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    fun provideApi(context: Context): RetrofitService? = try {
        Retrofit.Builder()
            .baseUrl(BuildConfig.APP_URL)
            .client(provideOkHttpClient(provideLoggingInterceptor()!!, context)!!)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(RetrofitService::class.java)
    } catch (e: Exception) {
        null
    }

    private fun provideOkHttpClient(

        interceptor: HttpLoggingInterceptor,
        context: Context
    ): OkHttpClient =
        OkHttpClient().newBuilder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader(HEADER_ACCESS_TOKEN, Preferences.loadAccessToken(context))
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(interceptor)
            .build()
//        interceptor: HttpLoggingInterceptor,
//        context: Context
//    ): OkHttpClient? = try {
//        OkHttpClient().newBuilder()
//            .addInterceptor { chain ->
//                val request = chain.request().newBuilder()
////                    .addHeader(HEADER_ACCESS_TOKEN, Preferences.loadAccessToken(context)).build()
//                    .addHeader(HEADER_ACCESS_TOKEN, Preferences.loadAccessToken(context)).build()
//                    .addHeader(HEADER_ACCESS_TOKEN, Preferences.loadAccessToken(context)).build()
//                chain.proceed(request)
//            }
//            .readTimeout(120, TimeUnit.SECONDS)
//            .writeTimeout(120, TimeUnit.SECONDS)
//            .addInterceptor(interceptor)
//            .build()
//    } catch (e: Exception) {
//        null
//    }


    private fun provideLoggingInterceptor(): HttpLoggingInterceptor? = try {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    } catch (e: Exception) {
        null
    }
}