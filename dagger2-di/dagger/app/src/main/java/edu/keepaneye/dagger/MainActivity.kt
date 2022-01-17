package edu.keepaneye.dagger

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.keepaneye.dagger.data.Computer
import edu.keepaneye.dagger.di.AppComponent
import edu.keepaneye.dagger.di.DaggerAppComponent
import javax.inject.Inject

class MainApp: Application() {

    lateinit var appComponent:AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when(this) {
      is MainApp -> appComponent
      else -> this.applicationContext.appComponent
    }


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent.inject(this)
    }
}