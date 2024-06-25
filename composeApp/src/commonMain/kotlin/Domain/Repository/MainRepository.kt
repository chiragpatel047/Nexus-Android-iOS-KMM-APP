package Domain.Repository

import Domain.Model.Show

interface MainRepository {
    suspend fun getShows() : Show
}