package com.note.shared

import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.note.model.NoteData
import com.note.shared.util.Constants
import com.note.shared.util.Result
import java.util.concurrent.TimeUnit

interface NoteDataSource {
    fun getNoteData(): Result<List<NoteData>>
    fun addNoteData(noteData: NoteData): Result<Boolean>
    fun getCurrentIdList(): Result<List<Int>>
    fun deleteNoteData(id: Int): Result<Boolean>
}

class FirebaseNoteDataSource : NoteDataSource {
    private val firebaseFirestore = Firebase.firestore
    override fun getNoteData(): Result<List<NoteData>> {
        return try {
            val list = arrayListOf<NoteData>()
            val result = firebaseFirestore.collection(Constants.NOTES).get()
            val task = Tasks.await(result, 20, TimeUnit.SECONDS)
            task.documents.forEach {
                val title =
                    it.data?.getValue(Constants.TITLE).toString()
                val note = it.data?.getValue(Constants.NOTE).toString()
                val color = it.data?.getValue(Constants.COLOR).toString()
                val id = it.data?.getValue(Constants.ID) as Long
                list.add(NoteData(title, note, color, id.toInt()))
            }
            Result.Success(list)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun addNoteData(noteData: NoteData): Result<Boolean> {
        val data = hashMapOf(
            Constants.NOTE to noteData.note,
            Constants.TITLE to noteData.title,
            Constants.COLOR to noteData.color,
            Constants.ID to noteData.id
        )
        return try {
            val resultIs = firebaseFirestore.collection(Constants.NOTES)
                .whereEqualTo(Constants.ID, noteData.id).get()
            val task = Tasks.await(resultIs, 20, TimeUnit.SECONDS)
            if (task.documents.isEmpty()) {
                val result = firebaseFirestore.collection(Constants.NOTES)
                    .document()
                    .set(data)
            } else {
                task.documents.forEach {
                    val result = firebaseFirestore.collection(Constants.NOTES)
                        .document(it.id)
                        .set(data)
                }
            }
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun getCurrentIdList(): Result<List<Int>> {
        return try {
            val list = arrayListOf<Int>()
            val result = firebaseFirestore.collection(Constants.NOTES).get()
            val task = Tasks.await(result, 20, TimeUnit.SECONDS)
            task.documents.forEach {
                val id = it.data?.getValue(Constants.ID) as Long
                list.add(id.toInt())
            }
            Result.Success(list)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun deleteNoteData(id: Int): Result<Boolean> {
        return try {

            val result =
                firebaseFirestore.collection(Constants.NOTES).whereEqualTo(Constants.ID, id).get()
            val task = Tasks.await(result, 20, TimeUnit.SECONDS)
            task.documents.forEach {
                it.reference.delete()
            }
            Result.Success(true)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}