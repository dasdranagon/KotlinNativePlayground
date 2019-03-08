package service.factory

import entities.Person
import service.date.Date
import service.date.DateFormatter

class DefaultPersonsFactory: PersonsFactory {
    internal enum class Columns {
        FIRST_NAME,
        SURNAME,
        ISSUE_COUNT,
        BIRTHDAY
    }

    private val dateFormatter = DateFormatter("yyyy-MM-dd'T'HH:mm:ss")

    override fun create(row: PersonsFactoryRow): Person? {
        if (Columns.values().count() > row.count()) return null

        val firstName = row[Columns.FIRST_NAME.ordinal]
        val surname = row[Columns.SURNAME.ordinal]
        val issueCount = row[Columns.ISSUE_COUNT.ordinal].toIntOrNull() ?: return null
        val birthday = dateFormatter.date(row[Columns.BIRTHDAY.ordinal]) ?: Date()//return null //FIXME: dataFormatter interop does not work properly

        return Person(firstName, surname, issueCount, birthday)
    }
}
