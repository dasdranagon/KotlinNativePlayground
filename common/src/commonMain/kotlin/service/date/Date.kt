package service.date

expect class Date

expect class DateFormater {
    companion object {
        val shared: DateFormater
    }
    fun configure(format: String)
    fun date(fromString: String): Date?
    fun string(fromDate: Date): String
}

