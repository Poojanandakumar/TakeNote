package com.note.shared.di

import com.note.shared.*
import com.note.shared.domain.GetCurrentIdListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

    @Singleton
    @Provides
    fun provideNoteDataSource(): NoteDataSource {
        return FirebaseNoteDataSource()
    }

    @Singleton
    @Provides
    fun provideNoteDataUseCase(noteDataRepository: NoteDataRepository): GetCurrentIdListUseCase {
        return GetCurrentIdListUseCase(noteDataRepository)
    }
}