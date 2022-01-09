package edu.keepaneye.uttermarvel.di

import dagger.Component
import edu.keepaneye.uttermarvel.ui.UtterMarvelActivity

@Component(modules = [AppModule::class])
interface AppComponent {
   fun inject(activity: UtterMarvelActivity)
}