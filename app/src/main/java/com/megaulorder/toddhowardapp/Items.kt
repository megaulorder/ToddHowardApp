package com.megaulorder.toddhowardapp

interface Item {
	fun getItemType(): Int
}

const val PARENT = 0
const val CHILD = 1

data class Parent(
	val id: Long,
	val title: String
) : Item {
	val childItems = ArrayList<Child>()
	var isExpanded = false

	override fun getItemType() = PARENT
}

data class Child(
	val parent: Parent,
	val id: Long,
	val title: String
) : Item {

	override fun getItemType() = CHILD
}
