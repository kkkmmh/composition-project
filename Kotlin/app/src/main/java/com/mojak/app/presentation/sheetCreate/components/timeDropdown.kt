package com.mojak.app.presentation.sheetCreate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mojak.app.core.design.RoundedCorner
import com.mojak.app.core.design.mojakBlack
import com.mojak.app.core.design.mojakFontFamily
import com.mojak.app.core.design.mojakGray
import com.mojak.app.core.design.mojakOrange
import com.mojak.app.core.design.mojakWhite
import com.mojak.app.core.utils.timeOptions

@Composable
fun timeDropdown(
    selected: String,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = "Time",
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
                    .padding(horizontal = 16.dp)
                    .clickable { expanded = true },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = selected,
                    fontFamily = mojakFontFamily,
                    fontSize = 16.sp,
                    color = mojakBlack
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(mojakWhite)
            ) {
                timeOptions.forEach { option ->
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