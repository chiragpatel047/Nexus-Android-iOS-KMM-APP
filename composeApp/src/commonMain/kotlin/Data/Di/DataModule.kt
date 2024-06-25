package Data.Di

import Data.Repository.MainRepoImpl
import Domain.Repository.MainRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    factory<MainRepository> { MainRepoImpl(get<HttpClient>()) }
}