package com.splendo.rabobank

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import presenter.ListDisplayItem
import presenter.ListEventsHandler
import view.ListView
import assembly.ListAssembly
import kotlinx.android.synthetic.main.activity_list.*


class ListScreen : AppCompatActivity(), ListView {
    private val assembly = ListAssembly()
    var listener: ListEventsHandler =  assembly.presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        assembly.presenter.view = this

        swipeRefreshLayout?.setOnRefreshListener {
            listener.refresh()
        }

        listener.ready()
    }

    private val swipeRefreshLayout: SwipeRefreshLayout?
        get() = findViewById<SwipeRefreshLayout>(R.id.pull_to_refresh)

    // ListView
    override fun processing(show: Boolean) {
        swipeRefreshLayout?.isRefreshing = show
    }

    override fun update(items: List<ListDisplayItem>) {
       (list_fragment as ListFragment).apply {
           update(items)
       }
    }
}
