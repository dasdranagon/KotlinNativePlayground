package model.source

import model.entities.Person

sealed class Response {
    class Success (val list: List<Person>): Response()
    class Fail (val error: ListException): Response()
}

typealias ListDataSourceHandler = (Response) -> Unit
interface ListDataSource {
    fun fetch(handler: ListDataSourceHandler)
}