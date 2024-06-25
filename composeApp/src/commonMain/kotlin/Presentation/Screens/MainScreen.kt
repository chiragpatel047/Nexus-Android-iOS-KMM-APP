package Presentation.Screens

import Data.Utils.NetworkResult
import Presentation.ViewModel.HomeViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.koin.compose.currentKoinScope

@Composable
fun MainScreen(navController: NavController) {

    val homeViewModel = koinViewModel<HomeViewModel>()
    val showListResult by homeViewModel.showListResult.collectAsState()

    LaunchedEffect(key1 = Unit){
        homeViewModel.getShowList()
    }

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {

            when (showListResult) {
                is NetworkResult.Error -> {
                    Text(text = showListResult.errorMsg.toString())
                    println("Result Error ==" + showListResult.errorMsg)
                }

                is NetworkResult.Loading -> {
                    CircularProgressIndicator()
                    println("Result ==" + "Loading")
                }

                is NetworkResult.Success -> {
                    Text(text = showListResult.data.toString())
                    println("Result Success ==" + showListResult.data.toString())
                }
            }


        }
    }
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}