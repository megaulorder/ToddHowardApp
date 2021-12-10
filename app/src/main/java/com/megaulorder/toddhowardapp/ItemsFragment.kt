package com.megaulorder.toddhowardapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.collections4.list.TreeList
import java.util.*

class ItemsFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val rootView = inflater.inflate(R.layout.fragment_list, container, false)

		val parent1 = Parent(0, "Skyrim")
		val childItems1 = ArrayList<Child>()
		childItems1.add(Child(parent1, 0, "купи x1"))
		childItems1.add(Child(parent1, 1, "купи x2"))
		childItems1.add(Child(parent1, 2, "купи x3"))
		childItems1.add(Child(parent1, 3, "купи x4"))
		parent1.childItems.clear()
		parent1.childItems.addAll(childItems1)

		val parent2 = Parent(1, "Morrowind")
		val childItems2 = ArrayList<Child>()
		childItems2.add(Child(parent2, 9, "купи x5"))
		childItems2.add(Child(parent2, 10, "купи x6"))
		childItems2.add(Child(parent2, 11, "купи x7"))
		parent2.childItems.clear()
		parent2.childItems.addAll(childItems2)

		val parent3 = Parent(2, "TESO")
		val childItems3 = ArrayList<Child>()
		childItems3.add(Child(parent3, 12, "купи x8"))
		childItems3.add(Child(parent3, 13, "купи x9"))
		childItems3.add(Child(parent3, 14, "купи x10"))
		parent3.childItems.clear()
		parent3.childItems.addAll(childItems3)

		val itemList = TreeList<Item>()
		itemList.add(parent1)
		itemList.add(parent2)
		itemList.add(parent3)

		val list = rootView.findViewById<RecyclerView>(R.id.list)
		list.adapter = ItemsAdapter(itemList)

		return rootView
	}

	companion object {
		fun getInstance() = ItemsFragment()
	}
}
