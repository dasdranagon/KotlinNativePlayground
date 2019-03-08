package service.date

expect class Date()

expect class DateFormatter {
    companion object {
        val shared: DateFormatter
    }
    fun configure(format: String)
    fun date(fromString: String): Date?
    fun string(fromDate: Date): String
}

