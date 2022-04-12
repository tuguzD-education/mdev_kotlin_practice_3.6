package io.github.tuguzd.fragments

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ColorViewModel(state: SavedStateHandle) : ViewModel() {
    private val savedStateHandle = state

    private val _color: MutableLiveData<Int> =
        savedStateHandle.getLiveData<Int>("color").apply { value = Color.WHITE }
    val color: LiveData<Int> get() = _color

    fun setColor(color: Int) {
        savedStateHandle["color"] = color
    }
}
