package com.mojak.app.presentation.sheet
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mojak.app.ui.theme.MojakTheme
import com.mojak.app.core.design.mojakBackgroundColor
import com.mojak.app.presentation.sheet.components.sheetHeaderSection
import com.mojak.app.presentation.sheet.components.staffSection


@Composable
fun sheetScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mojakBackgroundColor)
            .systemBarsPadding(),
        contentAlignment = Alignment.TopStart

    ){
        Column{
            sheetHeaderSection()
            staffSection(bpm = 80)
         }

    }
}


@Preview(showBackground = true)
@Composable
private fun sheetScreenPreview(){
    MojakTheme {
        sheetScreen()
    }
}
