package com.note.shared

import com.note.model.NoteData
import com.note.shared.util.Result
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val repository: NoteDataRepository) {
    fun deleteNoteData(id:Int): Result<Boolean> {
        return repository.deleteNoteData(id)
    }
}