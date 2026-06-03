package com.mojak.app.presentation.sheetCreate

import androidx.lifecycle.ViewModel
import com.mojak.app.core.utils.defaultBPM
import com.mojak.app.core.utils.maxBPM
import com.mojak.app.core.utils.minBPM
import com.mojak.app.core.utils.scaleOptions
import com.mojak.app.core.utils.timeOptions
import com.mojak.app.core.utils.tonalityOptions
import com.mojak.app.domain.entity.Sheet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class sheetCreateViewModel : ViewModel() {

    private val _sheetName = MutableStateFlow("")
    val sheetName: StateFlow<String> = _sheetName.asStateFlow()

    private val _tonality = MutableStateFlow(tonalityOptions[0])
    val tonality: StateFlow<String> = _tonality.asStateFlow()

    private val _scale = MutableStateFlow(scaleOptions[0])
    val scale: StateFlow<String> = _scale.asStateFlow()

    private val _bpm = MutableStateFlow(defaultBPM.toString())
    val bpm: StateFlow<String> = _bpm.asStateFlow()

    private val _time = MutableStateFlow(timeOptions[0])
    val time: StateFlow<String> = _time.asStateFlow()

    fun onSheetNameChange(value: String) {
        _sheetName.value = value
    }

    fun onTonalityChange(value: String) {
        _tonality.value = value
    }

    fun onScaleChange(value: String) {
        _scale.value = value
    }

    fun onBpmChange(value: String) {
        _bpm.value = value
    }

    fun onBpmFocusLost() {
        val inputBPM = _bpm.value.toIntOrNull()
        _bpm.value =
            when {
                _bpm.value.isEmpty() -> defaultBPM.toString()
                inputBPM == null -> defaultBPM.toString()
                inputBPM < minBPM -> minBPM.toString()
                inputBPM > maxBPM -> maxBPM.toString()
                else -> _bpm.value
            }
    }

    fun onTimeChange(value: String) {
        _time.value = value
    }

    fun createSheet(): Sheet {
        return Sheet(
            sheetName = _sheetName.value,
            scale = "${_tonality.value} ${_scale.value}",
            bpm = _bpm.value.toIntOrNull() ?: defaultBPM,
            timeSignature = _time.value
        )
    }
}
