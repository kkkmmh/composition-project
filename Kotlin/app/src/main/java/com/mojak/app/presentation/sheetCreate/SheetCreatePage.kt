package com.mojak.app.presentation.sheetCreate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

import com.mojak.app.core.design.mojakBeige
import com.mojak.app.core.design.mojakOrange
import com.mojak.app.core.design.mojakWhite
import com.mojak.app.core.design.mojakGreen
import com.mojak.app.core.design.mojakGray
import com.mojak.app.core.design.mojakBlack
import com.mojak.app.core.design.mojakFontFamily
import com.mojak.app.core.design.RoundedCorner
import com.mojak.app.core.utils.timeOptions
import com.mojak.app.core.utils.tonalityOptions
import com.mojak.app.core.utils.scaleOptions
import com.mojak.app.core.utils.maxBPM
import com.mojak.app.core.utils.minBPM
import com.mojak.app.core.utils.defaultBPM
import com.mojak.app.R

@Composable
fun SheetCreatePage(
    onClick: () -> Unit
) {

    var sheetName by remember {mutableStateOf("")}
    var tonality by remember {mutableStateOf(tonalityOptions[0])}
    var scale by remember {mutableStateOf(scaleOptions[0])}
    var bpm by remember {mutableStateOf(defaultBPM)}
    var time by remember {mutableStateOf(timeOptions[0])}

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mojakBeige)
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_ver2),
            contentDescription = "logo",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp)
                .width(242.dp)
                .height(221.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 28.dp)
                .padding(horizontal = 25.dp)
                .shadow(4.dp, RoundedCorner)
                .clip(RoundedCorner)
                .background(mojakWhite)
                .fillMaxWidth()
                .height(600.dp)
                .border(2.dp, mojakGreen, RoundedCorner)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
                    .padding(top = 30.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                InputField(
                    label = "Sheet Name",
                    value = sheetName,
                    onValueChange = { sheetName = it }
                )
                DropdownField(
                    label = "Tonality",
                    selected = tonality,
                    options = tonalityOptions,
                    onSelected = { tonality = it }
                )
                DropdownField(
                    label = "Scale",
                    selected = scale,
                    options = scaleOptions,
                    onSelected = { scale = it }
                )
                InputField(
                    label = "BPM",
                    value = bpm,
                    onValueChange = {
                        bpm = it
//                        val num = it.toIntOrNull()
//                        if (it.isEmpty() || (it.toIntOrNull() in minBPM..maxBPM)) {
//                            bpm = it
//                        }
                    },
                    keyboardType = KeyboardType.Number
                )
                DropdownField(
                    label = "Time",
                    selected = time,
                    options = timeOptions,
                    onSelected = { time = it }
                )

                Button(
                    onClick = onClick,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 14.dp)
                        .width(140.dp)
                        .height(70.dp)
                        .shadow(4.dp, RoundedCorner),
                    shape = RoundedCorner,
                    colors = ButtonDefaults.buttonColors(containerColor = mojakGreen)
                ) {
                    Text(
                        text = "Create",
                        fontFamily = mojakFontFamily,
                        fontSize = 30.sp,
                        color = mojakWhite
                    )
                }
            }
        }
    }
}

@Composable
private fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        Text(
            text = label,
            fontFamily = mojakFontFamily,
            fontSize = 20.sp,
            color = mojakOrange
        )
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontFamily = mojakFontFamily,
                fontSize = 16.sp,
                color = mojakBlack
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCorner),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = mojakGray,
                focusedContainerColor = mojakGray,
                unfocusedIndicatorColor = mojakGray,
                focusedIndicatorColor = mojakGray
            )
        )
    }
}

@Composable
private fun DropdownField(
    label: String,
    selected: String,
    options: List<String>,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = label,
            fontFamily = mojakFontFamily,
            fontSize = 20.sp,
            color = mojakOrange
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCorner)
                    .background(mojakGray)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = selected,
                    fontFamily = mojakFontFamily,
                    fontSize = 16.sp,
                    color = mojakBlack
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clickable { expanded = true }
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(mojakWhite)
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = option,
                                fontFamily = mojakFontFamily,
                                fontSize = 16.sp,
                                color = mojakBlack
                            )
                        },
                        onClick = {
                            onSelected(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}