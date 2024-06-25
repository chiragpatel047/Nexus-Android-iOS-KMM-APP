package Domain.UseCases

import Data.Utils.NetworkResult
import Domain.Model.Show
import Domain.Repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetShowListUseCase : KoinComponent {
    private val mainRepository: MainRepository by inject()

    operator fun invoke() = flow<NetworkResult<Show>> {

        emit(NetworkResult.Success(mainRepository.getShows()))

    }.catch {
        emit(NetworkResult.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}