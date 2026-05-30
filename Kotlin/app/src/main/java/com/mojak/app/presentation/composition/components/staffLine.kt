package com.mojak.app.presentation.composition.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.mojak.app.core.design.mojakStaffColor

@Composable
fun staffLine(){
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ){
        val staffColor = mojakStaffColor

        val startX = size.width * 0.08f
        val endX = size.width * 0.96f

        val lineGap = 4.5.dp.toPx()
        val topY = size.height / 2f - (lineGap * 2)
        val bottomY = topY + lineGap * 4

        for (index in 0 until 5) {
            val y = topY + lineGap * index

            drawLine(
                color = staffColor,
                start = Offset(startX, y),
                end = Offset(endX, y),
                strokeWidth = 1f
            )
        }

        val measureCount = 4
        val measureWidth = (endX - startX) / measureCount

        for (index in 0..measureCount){
            val x = startX + measureWidth * index

            drawLine(
                color = staffColor,
                start = Offset(x, topY),
                end = Offset(x, bottomY),
                strokeWidth = 1f
            )
        }
    }
}