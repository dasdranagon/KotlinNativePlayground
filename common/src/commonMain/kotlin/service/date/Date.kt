package service.date

expect class Date {
    constructor()
}

expect class DateFormatter {
    constructor(format: String)
    fun date(fromString: String): Date?
    fun string(fromDate: Date): String
}

