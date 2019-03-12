package com.splendo.rabobank

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_list_item.view.*

import presenter.ListDisplayItem

class ListRecyclerViewAdapter() : RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder>() {
    private val mValues =  mutableListOf<ListDisplayItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mFullNameView.text = item.fullName
        holder.mIssueCountView.text = item.issueCount
        holder.mDateView.text = item.dateOfBirth
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mFullNameView: TextView = mView.name
        val mIssueCountView: TextView = mView.issue_count
        val mDateView: TextView = mView.date

        override fun toString(): String {
            return super.toString() + " '${mFullNameView.text}'"
        }
    }

    fun update(items: List<ListDisplayItem> ) {
        mValues.apply {
            clear()
            addAll(items)
        }
    }
}
