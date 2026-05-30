package com.mojak.app.presentation.composition
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
import com.mojak.app.presentation.composition.components.sheetHeaderSection
import com.mojak.app.presentation.composition.components.staffSection


@Composable
fun compositionScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mojakBackgroundColor)
            .systemBarsPadding(),
        contentAlignment = Alignment.TopStart

    ){
        Column{
            sheetHeaderSection()
            staffSection()
         }

    }
}


@Preview(showBackground = true)
@Composable
private fun compositionScreenPreview(){
    MojakTheme {
        compositionScreen()
    }
}
