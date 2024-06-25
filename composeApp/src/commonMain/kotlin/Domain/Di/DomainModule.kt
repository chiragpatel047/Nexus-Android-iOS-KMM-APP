package Domain.Di

import Domain.UseCases.GetShowListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetShowListUseCase() }
}