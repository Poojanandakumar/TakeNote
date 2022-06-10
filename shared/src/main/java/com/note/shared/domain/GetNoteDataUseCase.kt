package com.note.shared.domain

import com.note.model.NoteData
import com.note.shared.NoteDataRepository
import com.note.shared.util.Result
import javax.inject.Inject

class GetNoteDataUseCase @Inject constructor(private val repository: NoteDataRepository) {
    fun getNoteData(): Result<List<NoteData>> {
        return repository.getNoteData()
    }
}