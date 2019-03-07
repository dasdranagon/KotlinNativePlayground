package parser.text

typealias TextParserRow = List<String>

interface TextParser {
    fun parse(text: String): List<TextParserRow>?
}