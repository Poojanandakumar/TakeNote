package com.note.shared

import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.note.model.NoteData
import com.note.shared.util.Constants
import com.note.shared.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.TimeUnit

interface NoteDataSource {
    fun getNoteData(): Flow<List<NoteData>>
    fun addNoteData(noteData: NoteData): Result<Boolean>
}

class FirebaseNoteDataSource : NoteDataSource {
    private val firebaseFirestore = Firebase.firestore
    override fun getNoteData(): Flow<List<NoteData>> = flow {
        val mutableList = mutableListOf<NoteData>(NoteData("a", "b", "0"))
        emit(mutableList)
    }

    override fun addNoteData(noteData: NoteData):Result<Boolean> {
        val data = hashMapOf(
            Constants.NOTE to noteData.note,
            Constants.TITLE to noteData.title,
            Constants.COLOR to noteData.color
        )
        return try {
            val result = firebaseFirestore.collection(Constants.NOTES)
                .document()
                .set(data)

            val task = Tasks.await(result, 20, TimeUnit.SECONDS)

            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}