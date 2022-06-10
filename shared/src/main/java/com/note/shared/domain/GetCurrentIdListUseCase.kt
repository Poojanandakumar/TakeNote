package com.note.shared.domain

import com.note.model.NoteData
import com.note.shared.NoteDataRepository
import com.note.shared.util.Result
import javax.inject.Inject

class GetCurrentIdListUseCase @Inject constructor(private val repository: NoteDataRepository) {

    fun getCurrentIdList(): Result<List<Int>> {
        return repository.getCurrentIdList()
    }
}