package service.factory

import entities.Person

typealias PersonsFactoryRow = List<String>
interface PersonsFactory {
    fun create(row: PersonsFactoryRow): Person?
}