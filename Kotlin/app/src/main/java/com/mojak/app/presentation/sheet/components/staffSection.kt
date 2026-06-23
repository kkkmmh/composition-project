package com.mojak.app.presentation.sheet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun staffSection(
    bpm: Int = 80,
    totalStaffLineCount: Int = 240,
    visibleStaffLineCount: Int = 4,
    onMeasureClick: (staffLineIndex: Int, measureIndex: Int) -> Unit = { _, _ -> }
    ){
    val staffLineHeight = 140.dp
    val staffLineSpacing = 10.dp

    val visibleHeight =
        staffLineHeight * visibleStaffLineCount +
                staffLineSpacing * (visibleStaffLineCount - 1)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        bpmSection(bpm = bpm)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(visibleHeight),
            verticalArrangement = Arrangement.spacedBy(staffLineSpacing)
        ) {
            items((0 until totalStaffLineCount).toList()) { staffLineIndex ->
                staffLine(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(staffLineHeight),
                    measureCount = 4,
                    onMeasureClick = { measureIndex ->
                        onMeasureClick(staffLineIndex, measureIndex)
                    }
                )
            }
        }
    }
}