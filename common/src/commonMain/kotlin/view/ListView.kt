package view

import presenter.ListDisplayItem

interface ListView {
    fun update(items:List<ListDisplayItem>)
    fun processing(show: Boolean)
}