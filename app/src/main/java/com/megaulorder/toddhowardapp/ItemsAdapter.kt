package com.megaulorder.toddhowardapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ItemsAdapter(private val itemList: LinkedList<Item>) :
	RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	override fun getItemCount() = itemList.size

	override fun getItemViewType(position: Int): Int {
		return itemList[position].getItemType()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
		return when (viewType) {
			CHILD -> ChildViewHolder(parent.inflate(R.layout.item_child))
			else -> ParentViewHolder(parent.inflate(R.layout.item_parent), this)
		}
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (holder.itemViewType) {
			CHILD -> {
				val childViewHolder = holder as ChildViewHolder
				childViewHolder.childItem = itemList[position] as Child
				childViewHolder.bind()
			}
			else -> {
				val parentViewHolder = holder as ParentViewHolder
				parentViewHolder.parentItem = itemList[position] as Parent
				parentViewHolder.bind()
			}
		}
	}

	fun removeItems(position: Int, items: List<Item>) {
		val iterator = itemList.listIterator(position)
		for (i in 1..items.size) {
			iterator.next()
			iterator.remove()
		}
		notifyItemRangeRemoved(position, items.size)
	}

	fun insertItems(position: Int, items: List<Item>) {
		val iterator = itemList.listIterator(position)
		for (item in items) {
			iterator.add(item)
		}
		notifyItemRangeInserted(position, items.size)
	}
}
