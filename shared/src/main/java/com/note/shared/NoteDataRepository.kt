package com.note.shared

import android.provider.ContactsContract
import com.note.model.NoteData
import com.note.shared.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface NoteDataRepository {
fun getNoteData(): Result<List<NoteData>>
fun addNoteData(noteData: NoteData): Result<Boolean>
}

class DefaultNoteDataRepository @Inject constructor(private val dataSource: NoteDataSource):NoteDataRepository{
    override fun getNoteData(): Result<List<NoteData>> {
        return dataSource.getNoteData()
    }

    override fun addNoteData(noteData: NoteData):Result<Boolean> {
        return dataSource.addNoteData(noteData)
    }

}