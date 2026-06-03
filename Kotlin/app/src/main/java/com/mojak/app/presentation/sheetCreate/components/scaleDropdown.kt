package com.mojak.app.presentation.sheetCreate.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.mojak.app.core.utils.scaleOptions
import com.mojak.app.core.utils.tonalityOptions

@Composable
fun scaleDropdown(
    selectedTonality: String,
    selectedScale: String,
    onTonalitySelected: (String) -> Unit,
    onScaleSelected: (String) -> Unit
) {
    var tonalityExpanded by remember { mutableStateOf(false) }
    var scaleExpanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = "Scale",
            fontFamily = mojakFontFamily,
            fontSize = 20.sp,
            color = mojakOrange
        )
        Spacer(modifier = Modifier.height(6.dp))
        Row(modifier = Modifier.fillMaxWidth()) {

            Box(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCorner)
                        .background(mojakGray)
                        .padding(horizontal = 16.dp)
                        .clickable { tonalityExpanded = true },
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = selectedTonality,
                        fontFamily = mojakFontFamily,
                        fontSize = 16.sp,
                        color = mojakBlack
                    )
                }
                DropdownMenu(
                    expanded = tonalityExpanded,
                    onDismissRequest = { tonalityExpanded = false },
                    modifier = Modifier.background(mojakWhite)
                ) {
                    tonalityOptions.forEach { option ->
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
                                onTonalitySelected(option)
                                tonalityExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Box(modifier = Modifier.weight(1f)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCorner)
                        .background(mojakGray)
                        .padding(horizontal = 16.dp)
                        .clickable { scaleExpanded = true },
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = selectedScale,
                        fontFamily = mojakFontFamily,
                        fontSize = 16.sp,
                        color = mojakBlack
                    )
                }
                DropdownMenu(
                    expanded = scaleExpanded,
                    onDismissRequest = { scaleExpanded = false },
                    modifier = Modifier.background(mojakWhite)
                ) {
                    scaleOptions.forEach { option ->
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
                                onScaleSelected(option)
                                scaleExpanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}