package com.mojak.app.presentation.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

import com.mojak.app.core.design.backGround
import com.mojak.app.core.design.mainOrange
import com.mojak.app.core.design.Pacifico
import com.mojak.app.R

@Composable
fun StartPage(
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backGround)
            .clickable(
                interactionSource = remember { MutableInteractionSource()},
                indication = null
            ) { onClick() }
    ){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = "logo",
                modifier = Modifier
                    .width(371.dp)
                    .height(338.dp)
                    .padding(bottom = 30.dp)
            )
        }
        Text(
            text = "press the start button",
            fontSize = 28.sp,
            fontFamily = Pacifico,
            color = mainOrange,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 233.dp)
        )
    }
}
