package model.source

import model.entities.Person
import service.errors.ErrorHandler
import service.factory.DefaultPersonsFactory
import service.factory.PersonsFactory
import service.parser.text.TextParser
import service.parser.text.TextParserRow
import service.source.TextSource

class DefaultListDataSource(
        val source: TextSource,
        val parser: TextParser,
        val factory: PersonsFactory) :ListDataSource {

    var errorHandler: ErrorHandler? = null

    var handler: ListDataSourceHandler? = null
    override fun fetch(handler: (Response) -> Unit) {
        this.handler = handler

        source.fetch {text ->
            text?.let {
                process(it)
            }  ?: run {
                proceed(ListException.Unknown())
            }
        }
    }

    // process
    private fun process(text: String) {
        parser.parse(text)?.apply {
            process(this)
        }
    }

    private fun process(rows: List<TextParserRow>) {
        rows.drop(0).mapNotNull {
            factory.create(it)
        }.apply {
            proceed(this)
        }
    }

    // proceed
    private fun proceed(exception: ListException) {
        handler?.run { this(Response.Fail(exception)) }
    }

    private fun proceed(list: List<Person>) {
        handler?.run { this(Response.Success(list)) }
    }

}