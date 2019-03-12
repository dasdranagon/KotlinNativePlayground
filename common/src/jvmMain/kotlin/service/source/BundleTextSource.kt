package service.source

actual class BundleTextSource
actual constructor(val resource: String)
    : TextSource {
    override fun fetch(handler: (String?) -> Unit) {
        val issuesFile = this.javaClass.getResource("/${resource}.csv")
        issuesFile.readText().also(handler)
    }
}
