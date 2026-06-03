package com.mojak.app.presentation.sheetCreate

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mojak.app.R
import com.mojak.app.core.design.RoundedCorner
import com.mojak.app.core.design.mojakBeige
import com.mojak.app.core.design.mojakFontFamily
import com.mojak.app.core.design.mojakGreen
import com.mojak.app.core.design.mojakWhite
import com.mojak.app.presentation.sheetCreate.components.bpmField
import com.mojak.app.presentation.sheetCreate.components.scaleDropdown
import com.mojak.app.presentation.sheetCreate.components.sheetNameField
import com.mojak.app.presentation.sheetCreate.components.timeDropdown

@Composable
fun SheetCreatePage(
    onClick: () -> Unit,
    viewModel: sheetCreateViewModel = viewModel()
) {
    val sheetName by viewModel.sheetName.collectAsState()
    val tonality by viewModel.tonality.collectAsState()
    val scale by viewModel.scale.collectAsState()
    val bpm by viewModel.bpm.collectAsState()
    val time by viewModel.time.collectAsState()

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
                sheetNameField(
                    value = sheetName,
                    onValueChange = viewModel::onSheetNameChange
                )
                scaleDropdown(
                    selectedTonality = tonality,
                    selectedScale = scale,
                    onTonalitySelected = viewModel::onTonalityChange,
                    onScaleSelected = viewModel::onScaleChange
                )
                bpmField(
                    value = bpm,
                    onValueChange = viewModel::onBpmChange,
                    onFocusLost = viewModel::onBpmFocusLost
                )
                timeDropdown(
                    selected = time,
                    onSelected = viewModel::onTimeChange
                )

                Button(
                    onClick = {
                        viewModel.createSheet()
                        onClick()
                    },
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