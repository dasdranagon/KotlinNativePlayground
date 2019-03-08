package service.date

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

actual typealias Date = NSDate
actual typealias DateFormatter = KotlinDateFormatter


class KotlinDateFormatter: NSDateFormatter() {
    companion object {
        val shared: DateFormatter
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    }

    fun configure(format: String) {
    }

    fun date(fromString: String): Date? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun string(fromDate: Date): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}