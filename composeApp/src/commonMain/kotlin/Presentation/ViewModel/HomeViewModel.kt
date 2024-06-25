package Presentation.ViewModel

import Data.Utils.NetworkResult
import Domain.Model.Show
import Domain.UseCases.GetShowListUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel(private val getShowListUseCase: GetShowListUseCase) : ViewModel() {

    private val _showListResult =
        MutableStateFlow<NetworkResult<Show>>(NetworkResult.Loading())
    val showListResult = _showListResult.asStateFlow()

    fun getShowList() {
        viewModelScope.launch {
            getShowListUseCase().collect {
                _showListResult.emit(it)
            }
        }
    }
    //val showList = getShowListUseCase()
}