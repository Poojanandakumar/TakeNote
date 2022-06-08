package com.note.shared

import com.note.model.NoteData
import com.note.shared.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteDataUseCase @Inject constructor(private val repository: NoteDataRepository) {
    fun addNoteData(noteData:NoteData): Result<Boolean> {
        return repository.addNoteData(noteData)
    }
}