package com.mojak.app.presentation.composition.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun staffSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(560.dp)
    ) {
        Spacer(modifier = Modifier
            .height(36.dp))
        repeat(8){
            staffLine()

            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}