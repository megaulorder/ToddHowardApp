package com.megaulorder.toddhowardapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ParentViewHolder(itemView: View, adapter: ItemsAdapter) : RecyclerView.ViewHolder(itemView) {

	init {
		itemView.setOnClickListener {
			val startPosition = adapterPosition + 1
			val childItems = parentItem.childItems

			if (parentItem.isExpanded) {
				adapter.removeItems(startPosition, childItems)
				parentItem.isExpanded = false
			} else {
				adapter.insertItems(startPosition, childItems)
				parentItem.isExpanded = true
			}
			updateArrow()
		}
	}

	lateinit var parentItem: Parent

	private val title: TextView = itemView.findViewById(R.id.title)
	private val arrow: ImageView = itemView.findViewById(R.id.arrow)

	fun bind() {
		title.text = parentItem.title
		updateArrow()
	}

	private fun updateArrow() {
		if (parentItem.isExpanded) {
			arrow.setImageResource(R.drawable.ic_arrow_drop_up)
		} else {
			arrow.setImageResource(R.drawable.ic_arrow_drop_down)
		}
	}
}
