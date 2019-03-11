package model.source


sealed class ListException(message: String): Throwable("List screen exception: $message") {
    class DataAccessError: ListException("Cannot read CSV file")
    class ParsingError: ListException("Unexpected content of CSV file")
    class Unknown: ListException("Unknown error occurred")
}
