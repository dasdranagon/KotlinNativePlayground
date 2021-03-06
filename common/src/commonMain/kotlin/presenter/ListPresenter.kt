package presenter

import model.entities.Person
import model.source.ListDataSource
import model.source.Response
import service.async.Lock
import service.date.DateFormatter
import view.ListView

class ListPresenter: ListEventsHandler {
    var view: ListView? = null
    var dataSource: ListDataSource? = null

    private val dateFormatter = DateFormatter("dd.MM.yyyy")
    private val loadingLock = Lock()

    fun load() {
        loadingLock.lock {
            view?.processing(true)
            dataSource?.fetch {
                when (it) {
                    is Response.Success -> update(it.list)
                    is Response.Fail -> println("error: ${it.error}")
                }
            }
        }
    }

    private fun update(items: List<Person>) {
        val displayItems = items.map { createDisplayItem(it) }

        view?.update(displayItems)
        view?.processing(false)
        loadingLock.release()
    }

    private fun createDisplayItem(person: Person): ListDisplayItem {
        return ListDisplayItem(
                fullName = "${person.firstName} ${person.surname}",
                dateOfBirth = dateFormatter.string(person.dateOfBirth),
                issueCount =  person.issueCount.toString())
    }

    override fun ready() {
        load()
    }

    override fun refresh() {
        load()
    }
}
