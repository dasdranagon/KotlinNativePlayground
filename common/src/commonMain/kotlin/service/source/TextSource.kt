package service.source

interface TextSource {
    fun fetch(handler: (String?) -> Unit)
}
