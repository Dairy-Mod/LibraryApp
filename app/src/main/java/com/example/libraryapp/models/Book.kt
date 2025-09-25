package com.example.libraryapp.models

import android.media.Rating
import org.intellij.lang.annotations.Language

data class Book(
    val id : Int,
    val name : String,
    val description : String,
    val image : String,
    val author : String,
    val isFavorite : Boolean,
    val rating: Double,
    val pages : Int,
    val audio : String,
    val language: String
)
val books = listOf(
    Book(1, "Cien años de soledad", "Novela de realismo mágico de Gabriel García Márquez.", "https://m.media-amazon.com/images/I/91TvVQS7loL.jpg", "Gabriel García Márquez", false, 4.8, 417, "18h 20m", "ESP"),
    Book(2, "1984", "Distopía clásica sobre un régimen totalitario.", "https://m.media-amazon.com/images/I/91jHOlKEPwL.jpg", "George Orwell", true, 4.7, 328, "11h 22m", "ENG"),
    Book(3, "El principito", "Fábula filosófica sobre la vida y la amistad.", "image3.jpg", "Antoine de Saint-Exupéry", false, 4.6, 96, "2h 30m", "FRA"),
    Book(4, "Don Quijote de la Mancha", "Obra maestra de la literatura española.", "image4.jpg", "Miguel de Cervantes", true, 4.9, 863, "36h 45m", "ESP"),
    Book(5, "Orgullo y prejuicio", "Novela romántica de la Inglaterra del siglo XIX.", "image5.jpg", "Jane Austen", false, 4.5, 279, "11h 35m", "ENG"),
    Book(6, "Crónica de una muerte anunciada", "Relato periodístico y trágico.", "image6.jpg", "Gabriel García Márquez", false, 4.4, 120, "3h 50m", "ESP"),
    Book(7, "Rayuela", "Novela experimental de la literatura latinoamericana.", "image7.jpg", "Julio Cortázar", true, 4.3, 736, "24h 10m", "ESP"),
    Book(8, "Fahrenheit 451", "Sociedad donde los libros están prohibidos.", "image8.jpg", "Ray Bradbury", false, 4.2, 194, "5h 1m", "ENG"),
    Book(9, "Matar a un ruiseñor", "Historia sobre racismo y justicia.", "image9.jpg", "Harper Lee", false, 4.8, 281, "12h 17m", "ENG"),
    Book(10, "La sombra del viento", "Misterio literario en la Barcelona de posguerra.", "image10.jpg", "Carlos Ruiz Zafón", true, 4.7, 565, "17h 45m", "ESP"),
    Book(11, "El nombre de la rosa", "Misterio medieval en una abadía benedictina.", "image11.jpg", "Umberto Eco", false, 4.6, 512, "21h 30m", "ITA"),
    Book(12, "Los juegos del hambre", "Distopía juvenil de supervivencia.", "image12.jpg", "Suzanne Collins", false, 4.5, 374, "11h 14m", "ENG"),
    Book(13, "El alquimista", "Novela de autodescubrimiento y aventura.", "image13.jpg", "Paulo Coelho", true, 4.3, 208, "4h 0m", "POR"),
    Book(14, "La casa de los espíritus", "Saga familiar con elementos mágicos.", "image14.jpg", "Isabel Allende", false, 4.4, 433, "15h 10m", "ESP"),
    Book(15, "Drácula", "Clásico de terror y vampiros.", "image15.jpg", "Bram Stoker", false, 4.6, 418, "16h 18m", "ENG")
)