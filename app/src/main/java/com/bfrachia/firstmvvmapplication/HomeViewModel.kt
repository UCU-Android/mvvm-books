package com.bfrachia.firstmvvmapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> get() = _loading

    private val _books = MutableLiveData<List<Book>>(emptyList())
    val books: LiveData<List<Book>> get() = _books

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        _loading.value = true
        _books.value = BooksRepository.fetchBooks()
        _loading.value = false
    }

}