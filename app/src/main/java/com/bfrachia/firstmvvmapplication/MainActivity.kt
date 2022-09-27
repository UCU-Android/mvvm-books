package com.bfrachia.firstmvvmapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    lateinit var progressBar: ProgressBar

    lateinit var recyclerView: RecyclerView
    private val adapter = BooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        setObservers()
    }

    private fun setObservers() {
        viewModel.loading.observe(this) { visible ->
            progressBar.visibility = if (visible) View.VISIBLE else View.GONE
        }

        viewModel.books.observe(this) { books ->
            adapter.books = books
            adapter.notifyDataSetChanged()
        }
    }

}