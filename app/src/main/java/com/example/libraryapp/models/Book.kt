package com.example.libraryapp.models

data class Book(
    val id : Int,
    val name : String,
    val description : String,
    val image : String,
    val author : String,
    val isFavorite : Boolean
)
val books = listOf(
    Book(1, "Cien años de soledad", "Novela de realismo mágico de Gabriel García Márquez.", "image1.jpg", "Gabriel García Márquez", false),
    Book(2, "1984", "Distopía clásica sobre un régimen totalitario.", "image2.jpg", "George Orwell", true),
    Book(3, "El principito", "Fábula filosófica sobre la vida y la amistad.", "image3.jpg", "Antoine de Saint-Exupéry", false),
    Book(4, "Don Quijote de la Mancha", "Obra maestra de la literatura española.", "image4.jpg", "Miguel de Cervantes", true),
    Book(5, "Orgullo y prejuicio", "Novela romántica de la Inglaterra del siglo XIX.", "image5.jpg", "Jane Austen", false),
    Book(6, "Crónica de una muerte anunciada", "Relato periodístico y trágico.", "image6.jpg", "Gabriel García Márquez", false),
    Book(7, "Rayuela", "Novela experimental de la literatura latinoamericana.", "image7.jpg", "Julio Cortázar", true),
    Book(8, "Fahrenheit 451", "Sociedad donde los libros están prohibidos.", "image8.jpg", "Ray Bradbury", false),
    Book(9, "Matar a un ruiseñor", "Historia sobre racismo y justicia.", "image9.jpg", "Harper Lee", false),
    Book(10, "La sombra del viento", "Misterio literario en la Barcelona de posguerra.", "image10.jpg", "Carlos Ruiz Zafón", true),
    Book(11, "El nombre de la rosa", "Misterio medieval en una abadía benedictina.", "image11.jpg", "Umberto Eco", false),
    Book(12, "Los juegos del hambre", "Distopía juvenil de supervivencia.", "image12.jpg", "Suzanne Collins", false),
    Book(13, "El alquimista", "Novela de autodescubrimiento y aventura.", "image13.jpg", "Paulo Coelho", true),
    Book(14, "La casa de los espíritus", "Saga familiar con elementos mágicos.", "image14.jpg", "Isabel Allende", false),
    Book(15, "Drácula", "Clásico de terror y vampiros.", "image15.jpg", "Bram Stoker", false)
)