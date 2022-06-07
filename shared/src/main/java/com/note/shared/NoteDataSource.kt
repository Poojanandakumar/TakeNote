package com.note.shared

import com.note.model.NoteData
import kotlinx.coroutines.flow.Flow

interface NoteDataSource {
    fun getNoteData(): Flow<List<NoteData>>
    fun addNoteData(noteData: NoteData):Result<Boolean>
}

class FirebaseNoteDataSource:NoteDataSource{
    override fun getNoteData(): Flow<List<NoteData>> {
        TODO("Not yet implemented")
    }

    override fun addNoteData(noteData: NoteData): Result<Boolean> {
        TODO("Not yet implemented")
    }
}