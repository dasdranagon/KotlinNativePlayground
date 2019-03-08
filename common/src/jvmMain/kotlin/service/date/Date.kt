package service.date
import java.util.Date

actual typealias Date = Date

actual class DateFormatter {
    actual companion object {
        actual val shared: DateFormatter
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    }

    actual fun configure(format: String) {
    }

    actual fun date(fromString: String): Date? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    actual fun string(fromDate: Date): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}