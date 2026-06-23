package com.mojak.app.presentation.sheet.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.mojak.app.core.design.mojakStaffColor

@Composable
fun staffLine(
    modifier: Modifier = Modifier,
    measureCount: Int = 4,
    onMeasureClick: (measureIndex: Int) -> Unit = {}
){
    Canvas(
        modifier = modifier
            .pointerInput(measureCount){
                detectTapGestures { tapOffset ->
                    val canvasWidth = size.width.toFloat()
                    val canvasHeight = size.height.toFloat()

                    val startX = canvasWidth * 0.08f
                    val endX = canvasWidth * 0.96f

                    val lineGap = canvasHeight * 0.085f
                    val topY = canvasHeight * 0.28f
                    val bottomY = topY + lineGap * 4

                    if (tapOffset.x < startX || tapOffset.x > endX) return@detectTapGestures
                    if (tapOffset.y < topY || tapOffset.y > bottomY) return@detectTapGestures

                    val measureWidth = (endX - startX) / measureCount
                    val measureIndex = ((tapOffset.x - startX) / measureWidth)
                        .toInt()
                        .coerceIn(0, measureCount - 1)

                    onMeasureClick(measureIndex)
                }
            }
    ){
        val staffColor = mojakStaffColor

        val startX = size.width * 0.08f
        val endX = size.width * 0.96f

        val lineGap = size.height * 0.085f
        val topY = size.height * 0.28f
        val bottomY = topY + lineGap * 4

        val strokeWidth = 1.dp.toPx()

        for (index in 0 until 5) {
            val y = topY + lineGap * index

            drawLine(
                color = staffColor,
                start = Offset(startX, y),
                end = Offset(endX, y),
                strokeWidth = strokeWidth
            )
        }

        val measureWidth = (endX - startX) / measureCount

        for (index in 1..measureCount){
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