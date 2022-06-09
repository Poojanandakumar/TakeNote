package com.note.shared

import com.note.model.NoteData
import com.note.shared.util.Result
import javax.inject.Inject

class NoteDataUseCase @Inject constructor(private val repository: NoteDataRepository) {
    fun addNoteData(noteData:NoteData): Result<Boolean> {
        return repository.addNoteData(noteData)
    }

    fun getNoteData(): Result<List<NoteData>> {
        return repository.getNoteData()
    }

    fun getCurrentIdList(): Result<List<Int>> {
        return repository.getCurrentIdList()
    }
}