package com.note.keepmynote.ui.note

import android.provider.SyncStateContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.dynamicfeatures.Constants
import com.note.model.NoteData
import com.note.shared.NoteDataUseCase
import com.note.shared.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val constants:NoteDataUseCase): ViewModel() {
    private val _aboutData = MutableLiveData<Event<List<NoteData>>>()
    val aboutData: LiveData<Event<List<NoteData>>> = _aboutData
fun abc(){
    viewModelScope.launch {
        constants.abc().collect {
           _aboutData.value = Event(it)
        }
    }
}
}