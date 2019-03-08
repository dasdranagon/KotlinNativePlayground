package service.errors

expect class NativeError
interface ErrorHandler {
    fun proceed(error: NativeError)
}

