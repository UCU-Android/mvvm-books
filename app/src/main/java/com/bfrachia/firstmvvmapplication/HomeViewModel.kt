package com.bfrachia.firstmvvmapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> get() = _loading

    private val _books = MutableLiveData<List<Book>>(emptyList())
    val books: LiveData<List<Book>> get() = _books

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        viewModelScope.launch {
            _loading.value = true
            delay(2000)
            _books.value = BooksRepository.fetchBooks()
            _loading.value = false
        }
    }

}