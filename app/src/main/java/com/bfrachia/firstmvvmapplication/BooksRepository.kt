package com.bfrachia.firstmvvmapplication

object BooksRepository {
    fun fetchBooks(): List<Book> {
        return listOf(
            Book(1, "Book 1", "John Doe"),
            Book(2, "Book 2", "John Doe"),
            Book(3, "Book 3", "John Doe"),
            Book(4, "Book 4", "John Doe"),
            Book(5, "Book 5", "John Doe"),
            Book(6, "Book 6", "John Doe"),
            Book(7, "Book 7", "John Doe"),
            Book(8, "Book 8", "John Doe")
        )
    }
}

data class Book(
    val id: Int,
    val title: String,
    val author: String
)