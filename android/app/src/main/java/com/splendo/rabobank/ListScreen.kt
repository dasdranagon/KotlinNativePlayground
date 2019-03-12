package com.splendo.rabobank

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

        listener.ready()
    }

    // ListView
    override fun processing(show: Boolean) {

    }

    override fun update(items: List<ListDisplayItem>) {
       (list_fragment as ListFragment).apply {
           update(items)
       }
    }
}
