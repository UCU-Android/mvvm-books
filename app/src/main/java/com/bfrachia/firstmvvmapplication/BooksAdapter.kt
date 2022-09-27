package com.bfrachia.firstmvvmapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BooksAdapter(): RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    var books: List<Book> = emptyList()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book) {
            itemView.findViewById<TextView>(R.id.title).text = book.title
            itemView.findViewById<TextView>(R.id.subtitle).text = book.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size
}