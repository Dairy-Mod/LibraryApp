package com.example.libraryapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.libraryapp.components.StatChip
import com.example.libraryapp.models.books
import com.example.libraryapp.ui.theme.AccentYellow
import com.example.libraryapp.ui.theme.BackgroundLight
import com.example.libraryapp.ui.theme.HeaderGreen
import com.example.libraryapp.ui.theme.LibraryAppTheme

@Composable
fun BookDetailScreen(id: Int) {
    val book = books.firstOrNull{ it.id == id }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .clip(RoundedCornerShape(bottomStart = 80.dp))
                    .background(HeaderGreen)
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = book?.image,
                    contentDescription = book?.name,
                    modifier = Modifier
                        .width(180.dp)
                        .weight(2f)
                        .shadow(20.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = book?.name ?: "",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = book?.author ?: "",
                        color = Color.LightGray,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 15.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        StatChip("RATING", book?.rating.toString())
                        StatChip("PAGES", book?.pages.toString())
                        StatChip("AUDIO", book?.audio.toString())
                        StatChip("LANG", book?.language.toString())
                    }
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AccentYellow
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 10.dp)
                    ) {
                        Text(
                            text = "Escuchar ahora"
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(AccentYellow)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Descripción"
                )
                Text(
                    text = book?.description ?: ""
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun BookDetailScreenPreview(){
    LibraryAppTheme {
        BookDetailScreen(id = 1)
    }
}