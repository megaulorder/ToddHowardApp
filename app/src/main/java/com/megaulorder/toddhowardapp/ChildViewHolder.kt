package com.megaulorder.toddhowardapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

	lateinit var childItem: Child

	private val title: TextView = itemView.findViewById(R.id.title)

	fun bind() {
		title.text = childItem.title
	}
}
