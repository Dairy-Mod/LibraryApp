package com.example.libraryapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StatChip(statName: String, statValue : String){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(80.dp)
            .padding(horizontal = 5.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = statName,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = statValue,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}