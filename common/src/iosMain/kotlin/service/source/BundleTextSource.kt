package service.source

import platform.Foundation.*
import platform.darwin.*

actual class BundleTextSource
actual constructor(val resource: String)
    : TextSource {

    override fun fetch(handler: (String?) -> Unit) {
        val urlString = NSBundle.mainBundle.pathForResource(resource, "csv")
        if (urlString == null) {
            handler(null)
            return
        }
        val text = NSString.stringWithContentsOfFile(urlString).toString()
        handler(text)
    }
}
