package parser.text

import kotlin.reflect.KClass
typealias Row = Array<String>

expect annotation class Throws(val exceptionClasses: KClass<out Throwable>)

interface TextParser {
    @Throws(ParsingException::class)
    fun parse(text: String): Array<Row>  //{
//    throw Exception("Hi There!")
//} /*  */

//    annotation class Throws(val value: KClass<Exception>)
}