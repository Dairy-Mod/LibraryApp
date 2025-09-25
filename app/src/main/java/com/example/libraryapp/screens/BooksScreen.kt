package com.example.libraryapp.screens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import com.example.libraryapp.components.PopularBookCard
import com.example.libraryapp.components.PrincipalBookCard
import com.example.libraryapp.models.books
import com.example.libraryapp.ui.theme.BackgroundLight
import com.example.libraryapp.ui.theme.HeaderGreen
import com.example.libraryapp.ui.theme.HeaderGreenLight
import com.example.libraryapp.ui.theme.LibraryAppTheme

@Composable
fun BooksScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        //HEADER

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = HeaderGreen,
                        shape = RoundedCornerShape(bottomStart = 70.dp)
                    )
                    .padding(top = 10.dp)
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text("Hola Alberto",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White
                        )
                        Text("Comenzamos a leer",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(HeaderGreenLight)
                            .padding(8.dp),
                        tint = Color.White
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(HeaderGreenLight)
                    )
                }

                // título dentro del header (opcional, como en tu mock)
                Spacer(Modifier.height(12.dp))
                Text(
                    "Continuar leyendo",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )

                // ← Aquí usamos tu componente TAL CUAL
                Spacer(Modifier.height(8.dp))
                PrincipalBookCard(book = books[0])
                Spacer(Modifier.height(12.dp))
            }
        }


        item {
            Text(
                "Libros populares",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)

            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(books) { book ->
                    PopularBookCard(book = book)
                }
            }
        }


        items(books) { book ->
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(12.dp)
                    .clickable {
                        navController.navigate("/books/${book.id}")
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                SubcomposeAsyncImage( //Muestra imagen
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.Magenta),
                    model = book.image,
                    contentDescription = book.name,
                    contentScale = ContentScale.Crop,
                    error = { //En caso de que haya un error, se muestra lo siguiente:
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = book.name.take(2).uppercase(),
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                        }
                    }
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = book.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = book.author, style = MaterialTheme.typography.bodyMedium)
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun BookScreenPreview(){
    LibraryAppTheme {
        BooksScreen(navController = rememberNavController())
    }
}