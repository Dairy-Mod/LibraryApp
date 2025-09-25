package com.example.libraryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.libraryapp.screens.BookDetailScreen
import com.example.libraryapp.screens.BooksScreen
import com.example.libraryapp.screens.FavoritesScreen
import com.example.libraryapp.ui.theme.AccentYellow
import com.example.libraryapp.ui.theme.BackgroundLight
import com.example.libraryapp.ui.theme.LibraryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LibraryAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    //agregar una barra de navegación para navegar a través de iconos
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier
                                .background(BackgroundLight)
                                .clip(RoundedCornerShape(topStart = 38.dp, topEnd = 30.dp)),
                            containerColor = Color.White
                        ) {
                            NavigationBarItem(
                                selected = false,
                                onClick = {
                                    navController.navigate("/books")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.List,
                                        contentDescription = null,
                                        modifier = Modifier.size(40.dp),
                                        tint = AccentYellow
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {
                                    navController.navigate("/favorites")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = null,
                                        modifier = Modifier.size(40.dp),
                                        tint = AccentYellow
                                    )
                                }
                            )
                        }
                    }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "/books"
                    ) {
                        composable(route = "/books") {
                            BooksScreen(navController)

                        }
                        composable(route = "/favorites") {
                            FavoritesScreen()
                        }
                        composable(route = "/books/{id}",
                            arguments = listOf(
                                navArgument("id") { //jala información de otra vista a través del ID
                                    type = NavType.IntType
                                }
                            )
                        ) { backStack ->
                            //BackStack
                            val data = backStack.arguments?.getInt("id") ?: 0 // si es nulo devuelve 0
                            BookDetailScreen(id)
                        }
                    }
                }
            }
        }
    }
}

