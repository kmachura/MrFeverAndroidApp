package com.kmm.mrfever

import android.app.Application
import androidx.multidex.MultiDex
import com.kmm.mrfever.di.component.AppComponent
import com.kmm.mrfever.di.component.DaggerAppComponent
import com.kmm.mrfever.di.module.AppModule
import androidx.multidex.MultiDexApplication

class MrFeverApplication : MultiDexApplication() {

    lateinit var component: AppComponent

    override fun onCreate() {
        MultiDex.install(this);
        super.onCreate()
        component = initDagger(this)
    }

    private fun initDagger(app: MrFeverApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
}