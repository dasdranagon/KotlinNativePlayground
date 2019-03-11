package service.parser.text

class CSVTextParser: TextParser {
    override fun parse(text: String): List<TextParserRow>? {
        return text.lines().map {
            it.split(',')
        }
    }
}