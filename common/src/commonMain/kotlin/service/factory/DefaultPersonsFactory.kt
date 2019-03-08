package service.factory

import entities.Person

abstract class DefaultPersonsFactory: PersonsFactory {
    internal enum class Columns {
        FIRST_NAME,
        SURNAME,
        ISSUE_COUNT,
        BIRTHDAY
    }
    override fun create(row: PersonsFactoryRow): Person? {
        if (Columns.values().count() >= row.count()) return null

//        val firstName = row[Columns.FIRST_NAME.ordinal]
//        val surname = row[Columns.SURNAME.ordinal]
//        val issueCount = row[Columns.ISSUE_COUNT.ordinal].toIntOrNull() ?: return null
//        val birthday = row[Columns.BIRTHDAY.ordinal]

        return null
    }
}

//private let dateFormatter: DateFormatter = {
//    let formater = DateFormatter()
//    formater.dateFormat = "yyyy-MM-dd'T'HH:mm:ss"
//    formater.timeZone = TimeZone(identifier: "UTC")
//    return formater
//}()
//
//
//func create(row: [String]) -> Person? {
//    guard row.count >= Columns.allCases.count else { return nil }
//    guard let issuCount = Int(row[Columns.issueCount.rawValue]) else { return nil }
//
//    let strDate = row[Columns.birthday.rawValue].trimmingCharacters(in: .punctuationCharacters)
//    guard let date = dateFormatter.date(from: strDate) else { return nil }
//
//    let firstName = row[Columns.firstName.rawValue].trimmingCharacters(in: .punctuationCharacters)
//    let surname = row[Columns.surname.rawValue].trimmingCharacters(in: .punctuationCharacters)
//
//    return Person(firstName: firstName,
//            surname: surname,
//            issueCount: issuCount,
//            dateOfBirth: date)
//}