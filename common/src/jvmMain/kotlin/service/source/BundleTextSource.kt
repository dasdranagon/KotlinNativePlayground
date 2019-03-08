package service.source

actual class BundleTextSource
actual constructor(resource: String)
    : TextSource {
    override fun fetch(handler: (String?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
