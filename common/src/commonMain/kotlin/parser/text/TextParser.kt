package parser.text

typealias Row = List<String>

interface TextParser {
    fun parse(text: String): List<Row>?
}