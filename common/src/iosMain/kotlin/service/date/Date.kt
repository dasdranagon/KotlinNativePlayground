package service.date

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSTimeZone
import platform.Foundation.timeZoneForSecondsFromGMT

actual typealias Date = NSDate
actual typealias DateFormatter = KotlinDateFormatter

class KotlinDateFormatter(format: String): NSDateFormatter() {

    init {
        dateFormat = format
        timeZone = NSTimeZone.timeZoneForSecondsFromGMT(0)
    }

    fun date(fromString: String): Date? {
        return dateFromString(fromString)
    }

    fun string(fromDate: Date): String = stringFromDate(fromDate)
}
