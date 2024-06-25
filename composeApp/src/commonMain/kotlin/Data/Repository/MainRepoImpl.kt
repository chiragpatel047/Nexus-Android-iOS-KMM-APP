package Data.Repository

import Data.Model.ShowDTO
import Domain.Mappers.toDomain
import Domain.Model.Show
import Domain.Repository.MainRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MainRepoImpl(private val httpClient: HttpClient) : MainRepository{
    override suspend fun getShows(): Show {

        val res =  httpClient.get("https://meme-api.com/gimme").body<ShowDTO>().toDomain()

        return res
    }
}