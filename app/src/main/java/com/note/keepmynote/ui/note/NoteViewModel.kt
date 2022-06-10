package com.note.keepmynote.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.note.model.NoteData
import com.note.shared.domain.AddDataUseCase
import com.note.shared.domain.GetCurrentIdListUseCase
import com.note.shared.util.Event
import com.note.shared.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteDataUseCase: GetCurrentIdListUseCase,
    private val addDataUseCase: AddDataUseCase
) :
    ViewModel() {
    private val _added = MutableLiveData<Event<Boolean>>()
    val added: LiveData<Event<Boolean>> = _added

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun addNoteData(noteData: NoteData) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                when (val data = addDataUseCase.addNoteData(noteData)) {
                    is Result.Error -> {
                        _error.postValue(data.exception)
                    }
                    is Result.Success -> {
                        _added.postValue(Event(data.data))
                    }
                    else -> {}
                }

            }
        }
    }


}