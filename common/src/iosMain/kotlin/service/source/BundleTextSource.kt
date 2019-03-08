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
        //FIXME: Implement multithreading
//        dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0)) {
            val text = NSString.stringWithContentsOfFile(urlString).toString()
//            dispatch_async(dispatch_get_main_queue()) {
                handler(text)
//            }
//        }
    }
}
