package parser.text

class CSVTextParser: TextParser {
    override fun parse(text: String): List<Row>? {

        val rows = text.lines().map {
             it.split(',')
        }

        if (rows.count() == 0) {
            throw Exception("Empty list")
            return null
        }

        return rows
    }
}