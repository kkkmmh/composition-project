package com.mojak.app.presentation.sheet.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mojak.app.core.design.mojakFontFamily
import com.mojak.app.core.design.mojakStaffColor

@Composable
fun bpmSection(
    bpm: Int = 80
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 51.dp,
                top = 37.dp,
                bottom = 8.dp
            )
    ) {
        Text(
            text = "♩=$bpm",
            color = mojakStaffColor,
            style = TextStyle(
                fontFamily = mojakFontFamily,
                fontSize = 20.sp
            )
        )
    }
}