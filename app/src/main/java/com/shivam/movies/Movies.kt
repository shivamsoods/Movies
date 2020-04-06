package com.shivam.movies

import android.app.Application
import com.shivam.movies.di.appModule
import com.shivam.movies.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Movies:Application(){

    override fun onCreate() {
        super.onCreate()
        initializeKoin()

    }
    private fun initializeKoin() {
        startKoin {
            androidLogger()
            androidContext(this@Movies)
            modules(
                listOf(
                    appModule,
                    mainModule
                )
            )
        }
    }
}