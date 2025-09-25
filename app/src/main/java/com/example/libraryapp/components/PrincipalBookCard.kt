package com.example.libraryapp.components

import android.R
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil3.Image
import coil3.compose.AsyncImage
import com.example.libraryapp.models.Book
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.libraryapp.models.books
import com.example.libraryapp.ui.theme.AccentYellow
import com.example.libraryapp.ui.theme.HeaderGreen
import com.example.libraryapp.ui.theme.LibraryAppTheme


@Composable
fun PrincipalBookCard(book : Book){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        AsyncImage(
            model = book.image,
            contentDescription = book.name,
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .padding(10.dp)
        ) {
            Text(
                text = book.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = book.author,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            Row(
                modifier = Modifier
                    .border(2.dp, AccentYellow,RoundedCornerShape(16.dp))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = null,
                    tint = AccentYellow
                )
                Text(
                    text = "Leer",
                    modifier = Modifier.padding(start = 10.dp),
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}

@Preview(
)
@Composable
fun PrincipalBookPreview(){
    LibraryAppTheme {
        PrincipalBookCard(books[0])
    }
}