package com.note.keepmynote.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.note.model.NoteData
import com.note.shared.DeleteNoteUseCase
import com.note.shared.NoteDataUseCase
import com.note.shared.util.Event
import com.note.shared.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteDataUseCase: NoteDataUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) :
    ViewModel() {
    private val _data = MutableLiveData<Event<List<NoteData>>>()
    val data: LiveData<Event<List<NoteData>>> = _data

    private val _clickedData = MutableLiveData<Event<NoteData>>()
    val clickedData: LiveData<Event<NoteData>> = _clickedData

    private val _currentIdList = MutableLiveData<Event<List<Int>>>()
    val currentIdList: LiveData<Event<List<Int>>> = _currentIdList

    private val _deleted = MutableLiveData<Event<Boolean>>()
    val deleted:LiveData<Event<Boolean>> = _deleted

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun getAllData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val data = noteDataUseCase.getNoteData()) {
                    is Result.Error -> {
                        _error.postValue(data.exception)
                    }
                    is Result.Success -> {
                        _data.postValue(Event(data.data))
                    }
                    else -> {}
                }
            }
        }
    }

    fun navigateToNote(noteReceivingData: NoteData) {
        _clickedData.value = Event(noteReceivingData)
    }

    fun deleteNoteData(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val deleteResult = deleteNoteUseCase.deleteNoteData(id)) {
                    is Result.Success -> {
                        _deleted.postValue(Event(deleteResult.data))
                    }
                    is Result.Error -> {
                        _error.postValue(deleteResult.exception)
                    }
                    else -> {}
                }
            }
        }
    }

    fun getCurrentIdList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val idList = noteDataUseCase.getCurrentIdList()) {
                    is Result.Success -> {
                        _currentIdList.postValue(Event(idList.data))
                    }
                    is Result.Error -> {
                        _error.postValue(idList.exception)
                    }
                    else -> {}
                }
            }
        }

    }
}