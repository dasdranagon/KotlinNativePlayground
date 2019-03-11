import model.source.DefaultListDataSource
import presenter.ListPresenter
import service.factory.DefaultPersonsFactory
import service.parser.text.CSVTextParser
import service.source.BundleTextSource

class ListAssembly {
    val dataSource: DefaultListDataSource
    val presenter: ListPresenter

    init {
        val source = BundleTextSource("issues")
        val parser = CSVTextParser()
        val factory =  DefaultPersonsFactory()

        dataSource = DefaultListDataSource(
                source = source,
                parser = parser,
                factory = factory)

        presenter = ListPresenter()
        presenter.dataSource = dataSource
    }
}