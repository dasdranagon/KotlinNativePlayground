package model.source

import model.entities.Person
import service.errors.ErrorHandler
import service.factory.DefaultPersonsFactory
import service.factory.PersonsFactory
import service.parser.text.TextParser
import service.source.TextSource

class DefaultListDataSource(
        val source: TextSource,
        val parser: TextParser,
        val factory: PersonsFactory = DefaultPersonsFactory()) :ListDataSource {

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

    private fun process(text: String) {

    }

    // proceed
    private fun proceed(exception: ListException) {
        handler?.run { this(Response.Fail(exception)) }
    }

    private fun proceed(list: List<Person>) {
        handler?.run { this(Response.Success(list)) }
    }

}

/**

    func fetch() {
        source.fetch { [weak self] text in
            guard let text = text else {
                self?.proceed(error: .dataAccessError)
                return KotlinUnit()
            }

            self?.process(text: text)
            return KotlinUnit()
        }
    }
}

extension DefaultListDataSource {

    func process(text: String) {
        /// Kotlin native code is thread local
//        DispatchQueue.global(qos: .utility).async { [weak self] in
        guard let rows = parser.parse(text: text) else {
        self.proceedInMainThread(error: .unknown)
        return
    }
        process(rows: rows)
//        }
    }

    private func process(rows: [[String]] ) {
        let persons = rows.dropFirst().compactMap { [weak self] row in
            return self?.factory.create(row: row)
        }

        DispatchQueue.main.async { [weak self] in
                self?.proceed(persons: persons)
        }
    }

}

*/