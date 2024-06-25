package Domain.Mappers

import Data.Model.ShowDTO
import Domain.Model.Show

//fun List<ShowDTO>.toDomain(): List<Show> = map {
//    Show(
//        title = it.title,
//        url = it.url
//    )
//}

fun ShowDTO.toDomain(): Show =
    Show(
        author = author,
        nsfw = nsfw,
        postLink = postLink,
        preview = preview,
        spoiler = spoiler,
        subreddit = subreddit,
        title = title,
        ups = ups,
        url = url
    )
