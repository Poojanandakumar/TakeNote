package com.note.shared.domain

import com.note.model.NoteData
import com.note.shared.NoteDataRepository
import com.note.shared.util.Result
import javax.inject.Inject

class AddDataUseCase @Inject constructor(private val repository: NoteDataRepository) {
    fun addNoteData(noteData: NoteData): Result<Boolean> {
        return repository.addNoteData(noteData)
    }
}