package edu.keepaneye.uttermarvel.app

import android.app.Application
import edu.keepaneye.uttermarvel.di.AppComponent
import edu.keepaneye.uttermarvel.di.AppModule
import edu.keepaneye.uttermarvel.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}