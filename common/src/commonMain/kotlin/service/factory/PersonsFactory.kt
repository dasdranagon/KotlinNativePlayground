package service.factory

import model.entities.Person

typealias PersonsFactoryRow = List<String>
interface PersonsFactory {
    fun create(row: PersonsFactoryRow): Person?
}