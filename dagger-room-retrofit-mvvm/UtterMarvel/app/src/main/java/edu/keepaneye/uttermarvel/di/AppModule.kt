package edu.keepaneye.uttermarvel.di

import android.content.Context
import dagger.Module
import dagger.Provides
import edu.keepaneye.uttermarvel.db.MarvelDatabase
import edu.keepaneye.uttermarvel.repository.MarvelRepository
import edu.keepaneye.uttermarvel.ui.MarvelViewModelProviderFactory

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }
    @Provides
    fun provideMarvelDatabase(context: Context): MarvelDatabase {
        return MarvelDatabase(context = context)
    }
    @Provides
    fun provideMarvelRepository(marvelDatabase: MarvelDatabase): MarvelRepository {
        return MarvelRepository(db = marvelDatabase)
    }
    @Provides
    fun provideMarvelViewModelProviderFactory(marvelRepository: MarvelRepository): MarvelViewModelProviderFactory {
        return MarvelViewModelProviderFactory(marvelRepository = marvelRepository)
    }
}