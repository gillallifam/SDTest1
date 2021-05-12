package com.gillall.xyz.softdesign.sdtest1.ui.sdevents

import androidx.lifecycle.*
import com.gillall.xyz.softdesign.sdtest1.model.SDEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SDEventsViewModel(private val repository: SDEventsRepository) : ViewModel() {
    private val _events = MutableLiveData<List<SDEvent>>()
    val events: LiveData<List<SDEvent>>
        get() = _events

    fun getEvents() {
        viewModelScope.launch(Dispatchers.IO) {
            _events.postValue(repository.getEvents())
        }
    }
}