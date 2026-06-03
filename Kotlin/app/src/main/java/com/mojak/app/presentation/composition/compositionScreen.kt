package com.mojak.app.presentation.composition
import com.mojak.app.domain.entity.Sheet
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
import com.mojak.app.core.design.mojakBeige
import com.mojak.app.presentation.composition.components.sheetHeaderSection
import com.mojak.app.presentation.composition.components.staffSection


@Composable
fun compositionScreen(sheet: Sheet){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mojakBeige)
            .systemBarsPadding(),
        contentAlignment = Alignment.TopStart

    ){
        Column{
            sheetHeaderSection(
                sheetName = sheet.sheetName,
                scale = sheet.scale,
                timeSignature = sheet.timeSignature,
                bpm = sheet.bpm
            )
            staffSection()
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun compositionScreenPreview(){
    MojakTheme {
        compositionScreen(
            sheet = Sheet(
                sheetName = "test",
                scale = "major C",
                timeSignature = "4/4",
                bpm = 80
            )
        )
    }
}
