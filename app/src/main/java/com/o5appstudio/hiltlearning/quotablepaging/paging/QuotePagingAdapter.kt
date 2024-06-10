package com.o5appstudio.hiltlearning.quotablepaging.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.o5appstudio.hiltlearning.R
import com.o5appstudio.hiltlearning.quotablepaging.model.Result

class QuotePagingAdapter : PagingDataAdapter<Result, QuotePagingAdapter.QuoteViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item_view, parent, false)
        return QuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.quote.text = item.content
        }
    }

    class QuoteViewHolder(itemView: View) : ViewHolder(itemView){
        val quote : TextView = itemView.findViewById(R.id.quote)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }
}