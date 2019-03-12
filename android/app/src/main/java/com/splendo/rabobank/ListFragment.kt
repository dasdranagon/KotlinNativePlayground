package com.splendo.rabobank

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import presenter.ListDisplayItem

class ListFragment() : Fragment() {
    private var listAdapter = ListRecyclerViewAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        if (view is RecyclerView) {
            with(view) {
                adapter = listAdapter
            }
        }

        return view
    }

    fun update(items: List<ListDisplayItem>) {
        listAdapter.update(items)
    }
}
