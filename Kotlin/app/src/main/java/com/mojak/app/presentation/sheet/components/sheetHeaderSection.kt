    package com.mojak.app.presentation.sheet.components

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.HorizontalDivider
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import com.mojak.app.R
    import com.mojak.app.core.design.mojakBorderColor
    import com.mojak.app.core.design.mojakFontFamily
    import com.mojak.app.core.design.mojakTextColor

    @Composable
    fun sheetHeaderSection() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_ver3),
                contentDescription = "Mojak Header",
                modifier = Modifier
                    .width(203.dp)
                    .height(116.dp),
                contentScale = ContentScale.Fit
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = mojakBorderColor
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    text = "seungho's sheet",
                    color = mojakTextColor,
                    style = TextStyle(
                        fontFamily = mojakFontFamily,
                        fontSize = 25.sp
                    )
                )
            }
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = mojakBorderColor
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Scale : C",
                        color = mojakTextColor,
                        style = TextStyle(
                            fontFamily = mojakFontFamily,
                            fontSize = 20.sp
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(48.dp)
                        .background(mojakBorderColor)
                )

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Time : 4/4",
                        color = mojakTextColor,
                        style = TextStyle(
                            fontFamily = mojakFontFamily,
                            fontSize = 20.sp
                        )
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = mojakBorderColor
            )
        }
    }