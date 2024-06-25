package Presentation.Di

import Presentation.ViewModel.HomeViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { HomeViewModel(get()) }
}