package edu.keepaneye.dagger.main

import edu.keepaneye.dagger.di.AppComponent
import edu.keepaneye.dagger.di.DaggerAppComponent

fun main() {
    val appComponent: AppComponent = DaggerAppComponent.create()
    println(appComponent.computer)
}