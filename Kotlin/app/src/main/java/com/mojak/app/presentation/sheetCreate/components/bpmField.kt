package com.mojak.app.presentation.sheetCreate.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mojak.app.core.design.RoundedCorner
import com.mojak.app.core.design.mojakBlack
import com.mojak.app.core.design.mojakGray
import com.mojak.app.core.design.mojakFontFamily
import com.mojak.app.core.design.mojakOrange

@Composable
fun bpmField(
    value: String,
    onValueChange: (String) -> Unit,
    onFocusLost: () -> Unit
) {
    Column {
        Text(
            text = "BPM",
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
                .clip(RoundedCorner)
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused) onFocusLost ()
                },
            keyboardOptions = KeyboardOptions(
              keyboardType = KeyboardType.Number,
              imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onFocusLost() }
            ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = mojakGray,
                focusedContainerColor = mojakGray,
                unfocusedIndicatorColor = mojakGray,
                focusedIndicatorColor = mojakGray
            )
        )
    }
}