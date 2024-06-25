package Data.Utils

sealed class NetworkResult<T>(val data: T? = null, val errorMsg: String? = null) {

    class Success<T>(data: T) : NetworkResult<T>(data = data)
    class Error<T>(errorMsg: String) : NetworkResult<T>(errorMsg = errorMsg)
    class Loading<T>() : NetworkResult<T>()

}