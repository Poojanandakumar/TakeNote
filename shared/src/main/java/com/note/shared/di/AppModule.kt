package com.note.shared.di

import android.content.Context
import android.net.ConnectivityManager
import com.note.shared.DefaultNoteDataRepository
import com.note.shared.NoteDataRepository
import com.note.shared.NoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNoteRepository(noteDataSource: NoteDataSource): NoteDataRepository {
        return DefaultNoteDataRepository(noteDataSource)
    }
}