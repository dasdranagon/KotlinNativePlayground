package service.async

typealias Block = () -> Unit
class Lock {
    private var locked = false
    fun lock(block: Block) {
        if (locked) { return }

        locked = true
        block()
    }

    fun release() {
        locked = false
    }
}
