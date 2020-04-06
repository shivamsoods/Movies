package com.shivam.movies.di

import android.content.Context
import com.shivam.movies.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule=module{
    single { provideRetrofit(androidContext()) }
}

/**
 * Creates a Moshi object with Adapter Factory
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Provides a Retrofit Client to the application
 */
private fun provideRetrofit(context: Context) = Retrofit.Builder()
    .baseUrl(context.getString(R.string.BASE_URL))
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

