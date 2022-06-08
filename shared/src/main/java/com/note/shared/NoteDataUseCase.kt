package com.note.shared

import com.note.model.NoteData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteDataUseCase @Inject constructor(private val repository: NoteDataRepository) {
    fun abc(): Flow<List<NoteData>> {
        return repository.getNoteData()
    }
}