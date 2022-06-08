package com.note.shared

import android.provider.ContactsContract
import com.note.model.NoteData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface NoteDataRepository {
fun getNoteData(): Flow<List<NoteData>>
fun addNoteData(noteData: NoteData):Result<Boolean>
}

class DefaultNoteDataRepository @Inject constructor(private val dataSource: NoteDataSource):NoteDataRepository{
    override fun getNoteData(): Flow<List<NoteData>> {
        return dataSource.getNoteData()
    }

    override fun addNoteData(noteData: NoteData):Result<Boolean> {
        TODO("Not yet implemented")
    }

}