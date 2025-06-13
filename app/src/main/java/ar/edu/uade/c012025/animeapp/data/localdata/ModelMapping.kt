package ar.edu.uade.c012025.animeapp.data.localdata

import ar.edu.uade.c012025.animeapp.data.Anime
import ar.edu.uade.c012025.animeapp.data.Author
import ar.edu.uade.c012025.animeapp.data.CharacterAnime
import ar.edu.uade.c012025.animeapp.data.CharacterData
import ar.edu.uade.c012025.animeapp.data.CharacterManga
import ar.edu.uade.c012025.animeapp.data.Genre
import ar.edu.uade.c012025.animeapp.data.Genres
import ar.edu.uade.c012025.animeapp.data.Images
import ar.edu.uade.c012025.animeapp.data.ImagesJpg
import ar.edu.uade.c012025.animeapp.data.Manga
import ar.edu.uade.c012025.animeapp.data.Opening
import ar.edu.uade.c012025.animeapp.data.Published
import ar.edu.uade.c012025.animeapp.data.Serialization
import ar.edu.uade.c012025.animeapp.data.Streaming
import ar.edu.uade.c012025.animeapp.data.Studios
import ar.edu.uade.c012025.animeapp.data.Trailer
import kotlin.collections.joinToString

fun Anime.toLocal() = AnimeEntity(
    id = id,
    imageUrl = images?.jpg?.imageUrl,
    title = title,
    titleJapanese = titleJapanese,
    type = type,
    trailerUrl = trailer?.youtubeId,
    episodes = episodes,
    status = status,
    score = score,
    genres = genres.joinToString { it.name },
    studios = studios.joinToString { it.name },
    theme = theme.openings.firstOrNull(),
    synopsis = synopsis,
    duration = duration,
    rating = rating,
    season = season,
    streaming = streaming.joinToString { it.name },
    year = year
)

fun List<Anime>.toLocal() = map(Anime::toLocal)

fun AnimeEntity.toExternal() = Anime(
    id = id,
    images = Images(ImagesJpg(imageUrl ?: "")),
    title = title,
    titleJapanese = titleJapanese,
    type = type,
    trailer = Trailer(trailerUrl ?: "", "", ""),
    episodes = episodes ?: 0,
    status = status,
    score = score ?: 0.0,
    synopsis = synopsis,
    genres = listOfNotNull(Genre(name = genres)),
    themes = emptyList(),
    studios = listOfNotNull(Studios(id = 0, name = studios)),
    theme = Opening(openings = listOfNotNull(theme)),
    streaming = listOfNotNull(Streaming(name = streaming, "")),
    duration = duration,
    rating = rating,
    season = season,
    year = year
)

fun List<AnimeEntity>.toExternal() = map(AnimeEntity::toExternal)


fun Manga.toMangaLocal() = MangaEntity(
    id = id,
    title = title,
    titleJapanese = titleJapanese,
    synopsis = synopsis,
    background = background,
    chapters = chapters,
    volumes = volumes,
    status = status,
    publishing = publishing,
    score = score,
    rank = rank,
    popularity = popularity,
    imagesUrl = images.jpg?.imageUrl.toString(),
    genres = genres.joinToString { it.name },
    authors = authors.joinToString { it.name },
    serializations = serializations.joinToString { it.name },
    published = published?.string.toString()
)

fun List<Manga>.toMangaLocal() = map(Manga::toMangaLocal)

fun MangaEntity.toMangaExternal() = Manga(
    id = id,
    title = title,
    titleJapanese = titleJapanese,
    synopsis = synopsis,
    background = background,
    chapters = chapters,
    volumes = volumes,
    status = status,
    publishing = publishing,
    score = score,
    rank = rank,
    popularity = popularity,
    images = Images(ImagesJpg(imagesUrl)),
    genres = listOfNotNull(Genres(id = 0, name = genres, url = "")),
    authors = listOfNotNull(Author(id = 0, name = authors, url = "")),
    serializations = listOfNotNull(Serialization(id = 0, name = serializations, url = "")),
    published = Published(string = published),
    themes = emptyList(),
    demographics = emptyList()
)

fun List<MangaEntity>.toMangaExternal() = map(MangaEntity::toMangaExternal)


fun CharacterData.toCharacterLocal() = CharacterEntity(
    id = id,
    imagesUrl = images?.jpg?.imageUrl ?: "",
    name = name ?: "",
    nameKanji = nameKanji ?: "",
    nicknames = nicknames?.joinToString() ?: "",
    about = about ?: "",
    anime = anime,
    manga = manga,
)

fun List<CharacterData>.toCharacterLocal() = map(CharacterData::toCharacterLocal)

fun CharacterEntity.toCharacterExternal() = CharacterData(
    id = id,
    images = Images(ImagesJpg(imagesUrl)),
    name = name,
    nameKanji = nameKanji,
    nicknames = nicknames.split(","),
    about = about,
    anime = anime,
    manga = manga
)

fun List<CharacterEntity>.toCharacterExternal() = map(CharacterEntity::toCharacterExternal)