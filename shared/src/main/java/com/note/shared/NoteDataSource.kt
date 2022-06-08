package com.note.shared

import com.note.model.NoteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface NoteDataSource {
    fun getNoteData(): Flow<List<NoteData>>
    fun addNoteData(noteData: NoteData): Result<Boolean>
}

class FirebaseNoteDataSource : NoteDataSource {
    override fun getNoteData(): Flow<List<NoteData>> = flow {
        val mutableList = mutableListOf<NoteData>(NoteData("a", "b", "c"))
        emit(mutableList)
    }

    override fun addNoteData(noteData: NoteData): Result<Boolean> {
        TODO("Not yet implemented")
    }
}