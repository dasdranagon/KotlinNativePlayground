package com.splendo.rabobank

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.splendo.rabobank.dummy.DummyContent

class ListScreen : AppCompatActivity(), ListFragment.OnListFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented")
    }
}
