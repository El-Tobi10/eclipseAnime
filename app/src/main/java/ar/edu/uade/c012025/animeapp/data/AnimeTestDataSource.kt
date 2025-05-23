package ar.edu.uade.c012025.animeapp.data

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.delay

class AnimeTestDataSource : IAnimeDataSource {

    override suspend fun getAnimeList(search: String) : List<Anime> {

        delay(5000)

        val gson = Gson()
        val animeResult = gson.fromJson(json, AnimeResult::class.java)
        Log.d("GSONDATA", animeResult.data.toString())
        Log.d("GSONDATATITLE", animeResult.data[0].title)
        return animeResult.data
    }

    override suspend fun getAnimeById(animeId: Int): Anime {
        return getAnimeList("")[0]
    }
    override suspend fun getCharactersForAnime(animeId: Int): List<CharacterData> {
        return emptyList()
    }
    override suspend fun getRecommendationsForAnime(animeId: Int): List<Anime> {
        return emptyList()
    }

    private var json = """
    {
      "pagination": {
        "last_visible_page": 7,
        "has_next_page": true,
        "current_page": 1,
        "items": {
          "count": 25,
          "total": 168,
          "per_page": 25
        }
      },
      "data": [
        {
          "mal_id": 39204,
          "url": "https://myanimelist.net/anime/39204/Demon_Dance_Tokyo",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1647/98866.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1647/98866t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1647/98866l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1647/98866.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1647/98866t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1647/98866l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Demon Dance Tokyo"
            },
            {
              "type": "Synonym",
              "title": "Eve"
            },
            {
              "type": "Japanese",
              "title": "デーモンダンストーキョー"
            },
            {
              "type": "English",
              "title": "Demon Dance Tokyo"
            }
          ],
          "title": "Demon Dance Tokyo",
          "title_english": "Demon Dance Tokyo",
          "title_japanese": "デーモンダンストーキョー",
          "title_synonyms": [
            "Eve"
          ],
          "type": "Music",
          "source": "Original",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2016-10-19T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 19,
                "month": 10,
                "year": 2016
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Oct 19, 2016"
          },
          "duration": "4 min",
          "rating": "G - All Ages",
          "score": 6.77,
          "scored_by": 626,
          "rank": null,
          "popularity": 14083,
          "members": 1092,
          "favorites": 3,
          "synopsis": "An original song by Eve, animated by Mah. The song became popular enough to be included in Joysound, a Japanese karaoke company who specializes in song libraries.",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [],
          "licensors": [],
          "studios": [],
          "genres": [],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 19,
              "type": "anime",
              "name": "Music",
              "url": "https://myanimelist.net/anime/genre/19/Music"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 6184,
          "url": "https://myanimelist.net/anime/6184/Makaryuudo_Demon_Hunter",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/11/69053.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/11/69053t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/11/69053l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/11/69053.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/11/69053t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/11/69053l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Makaryuudo Demon Hunter"
            },
            {
              "type": "Synonym",
              "title": "Demon Hunter Makaryuudo"
            },
            {
              "type": "Synonym",
              "title": "Makaryudo"
            },
            {
              "type": "Synonym",
              "title": "Demon Hunter"
            },
            {
              "type": "Japanese",
              "title": "魔狩人"
            }
          ],
          "title": "Makaryuudo Demon Hunter",
          "title_english": null,
          "title_japanese": "魔狩人",
          "title_synonyms": [
            "Demon Hunter Makaryuudo",
            "Makaryudo",
            "Demon Hunter"
          ],
          "type": "OVA",
          "source": "Manga",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "1989-11-08T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 8,
                "month": 11,
                "year": 1989
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Nov 8, 1989"
          },
          "duration": "30 min",
          "rating": "R+ - Mild Nudity",
          "score": 5.31,
          "scored_by": 1827,
          "rank": 12790,
          "popularity": 9467,
          "members": 4309,
          "favorites": 5,
          "synopsis": "Yama Rikudo is not your average teenage girl. With her trademark duo horn-like tufted hair, she’s really a kind of demon policewoman, charged with the duty of protecting Japan from demonic monsters that’ve gone AWOL. Even when her demon superiors try and pull her off the job, because demon-human relations are getting too hot for her to handle, she will stay and fight with her giant scythe, because, while disguised as a high school student, she has fallen for fellow student Sho Kurogane. Now she must save Sho, and his friends, from the evil plotting of the school’s eternal youth seeking, soul sucking, Headmistress.\n\n(Source: Chris' Cel Site)",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [
            {
              "mal_id": 230,
              "type": "anime",
              "name": "Bandai",
              "url": "https://myanimelist.net/anime/producer/230/Bandai"
            }
          ],
          "licensors": [],
          "studios": [
            {
              "mal_id": 24,
              "type": "anime",
              "name": "Studio Fantasia",
              "url": "https://myanimelist.net/anime/producer/24/Studio_Fantasia"
            }
          ],
          "genres": [
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Supernatural",
              "url": "https://myanimelist.net/anime/genre/37/Supernatural"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 58,
              "type": "anime",
              "name": "Gore",
              "url": "https://myanimelist.net/anime/genre/58/Gore"
            },
            {
              "mal_id": 6,
              "type": "anime",
              "name": "Mythology",
              "url": "https://myanimelist.net/anime/genre/6/Mythology"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 54880,
          "url": "https://myanimelist.net/anime/54880/Demon_Queen_Just_Wants_to_Make_Peace",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1540/134842.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1540/134842t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1540/134842l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1540/134842.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1540/134842t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1540/134842l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Demon Queen Just Wants to Make Peace"
            },
            {
              "type": "Synonym",
              "title": "The Demon Queen Has a Death Wish"
            },
            {
              "type": "Synonym",
              "title": "The Demon Queen Wants To Die"
            },
            {
              "type": "Synonym",
              "title": "The Demon Lord Wants to Die"
            },
            {
              "type": "Japanese",
              "title": "마왕님은 죽고 싶어"
            }
          ],
          "title": "Demon Queen Just Wants to Make Peace",
          "title_english": null,
          "title_japanese": "마왕님은 죽고 싶어",
          "title_synonyms": [
            "The Demon Queen Has a Death Wish",
            "The Demon Queen Wants To Die",
            "The Demon Lord Wants to Die"
          ],
          "type": "ONA",
          "source": "Web manga",
          "episodes": 10,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2023-03-27T00:00:00+00:00",
            "to": "2023-05-15T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 27,
                "month": 3,
                "year": 2023
              },
              "to": {
                "day": 15,
                "month": 5,
                "year": 2023
              }
            },
            "string": "Mar 27, 2023 to May 15, 2023"
          },
          "duration": "6 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": null,
          "scored_by": null,
          "rank": 20377,
          "popularity": 16219,
          "members": 621,
          "favorites": 2,
          "synopsis": "Jinjoo has suddenly been transported into her favorite fantasy romance novel. This might sound like a dream come true, but Jinjoo is stuck in the body of the story's villain, Demon Queen Astreia! If she doesn't change the storyline, she will inevitably be slain by the fierce warrior, Caine. To prevent her demise, Astreia sets out on a journey to end the war between the human and demon realms. But can she win the trust of not only the parties in question but also of her suspicious companion, Caine? Or is her destiny bound to the novel's pages?\n\n(Source: Tapas)",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [],
          "licensors": [],
          "studios": [],
          "genres": [
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 22,
              "type": "anime",
              "name": "Romance",
              "url": "https://myanimelist.net/anime/genre/22/Romance"
            }
          ],
          "explicit_genres": [],
          "themes": [],
          "demographics": []
        },
        {
          "mal_id": 31118,
          "url": "https://myanimelist.net/anime/31118/Demon_Busters__Ecchi_na_Ecchi_na_Demon_Taiji_The_Animation",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1112/104314.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1112/104314t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1112/104314l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1112/104314.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1112/104314t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1112/104314l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Demon Busters: Ecchi na Ecchi na Demon Taiji The Animation"
            },
            {
              "type": "Japanese",
              "title": "デーモンバスターズ ~えっちなえっちなデーモン退治~ THE ANIMATION"
            }
          ],
          "title": "Demon Busters: Ecchi na Ecchi na Demon Taiji The Animation",
          "title_english": null,
          "title_japanese": "デーモンバスターズ ~えっちなえっちなデーモン退治~ THE ANIMATION",
          "title_synonyms": [],
          "type": "OVA",
          "source": "Visual novel",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2015-09-25T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 25,
                "month": 9,
                "year": 2015
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Sep 25, 2015"
          },
          "duration": "26 min",
          "rating": "Rx - Hentai",
          "score": 6.75,
          "scored_by": 3344,
          "rank": null,
          "popularity": 7224,
          "members": 8722,
          "favorites": 41,
          "synopsis": "Kou is a member of the public morals committee at Moriyaji Gakuen, along with his childhood friend Ai and kouhai Karen. One day while he was making the rounds after school, he was attacked by a weird being. He was frozen in fear and could not evade its attack, but he was saved by two girls, Konoka and Lizera. They were 'daemon busters' who fight against daemons borne from the lust and cravings of humans. They told him that he was a kyuumashi who could absorb the desires that create daemons, and they asked for his help since his special ability makes their battles much easier. When he uses his ability, it causes him to be able to see girls naked and also makes them horny. If the daemons aren’t defeated, then their lust will cause the whole school to become an orgy. As part of the public morals committee, he can’t let that happen!\n\n(Source: Hau~ Omochikaeri!)",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [
            {
              "mal_id": 45,
              "type": "anime",
              "name": "Pink Pineapple",
              "url": "https://myanimelist.net/anime/producer/45/Pink_Pineapple"
            }
          ],
          "licensors": [],
          "studios": [
            {
              "mal_id": 405,
              "type": "anime",
              "name": "T-Rex",
              "url": "https://myanimelist.net/anime/producer/405/T-Rex"
            }
          ],
          "genres": [
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Supernatural",
              "url": "https://myanimelist.net/anime/genre/37/Supernatural"
            },
            {
              "mal_id": 12,
              "type": "anime",
              "name": "Hentai",
              "url": "https://myanimelist.net/anime/genre/12/Hentai"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 35,
              "type": "anime",
              "name": "Harem",
              "url": "https://myanimelist.net/anime/genre/35/Harem"
            },
            {
              "mal_id": 6,
              "type": "anime",
              "name": "Mythology",
              "url": "https://myanimelist.net/anime/genre/6/Mythology"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 22975,
          "url": "https://myanimelist.net/anime/22975/Kaibutsu-kun__Demon_no_Ken",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/10/59587.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/10/59587t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/10/59587l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/10/59587.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/10/59587t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/10/59587l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Kaibutsu-kun: Demon no Ken"
            },
            {
              "type": "Japanese",
              "title": "怪物くん デーモンの剣"
            }
          ],
          "title": "Kaibutsu-kun: Demon no Ken",
          "title_english": null,
          "title_japanese": "怪物くん デーモンの剣",
          "title_synonyms": [],
          "type": "Movie",
          "source": "Unknown",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "1982-03-13T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 13,
                "month": 3,
                "year": 1982
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Mar 13, 1982"
          },
          "duration": "52 min",
          "rating": "G - All Ages",
          "score": 5.82,
          "scored_by": 151,
          "rank": 10934,
          "popularity": 15361,
          "members": 761,
          "favorites": 0,
          "synopsis": "Based on the shounen manga by Fujiko Fujio.\n\nNote: Screened as a triple feature with Doraemon: Nobita no Daimakyou and Ninja Hattori-kun: Nin Nin Ninpo Enikki no Maki.\n\n(Source: AniDB)",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [],
          "licensors": [],
          "studios": [
            {
              "mal_id": 247,
              "type": "anime",
              "name": "Shin-Ei Animation",
              "url": "https://myanimelist.net/anime/producer/247/Shin-Ei_Animation"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 14,
              "type": "anime",
              "name": "Horror",
              "url": "https://myanimelist.net/anime/genre/14/Horror"
            }
          ],
          "explicit_genres": [],
          "themes": [],
          "demographics": [
            {
              "mal_id": 15,
              "type": "anime",
              "name": "Kids",
              "url": "https://myanimelist.net/anime/genre/15/Kids"
            },
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 5298,
          "url": "https://myanimelist.net/anime/5298/Yu☆Gi☆Oh_5Ds__Shinkasuru_Kettou_Stardust_vs_Red_Demons",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/8/10786.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/8/10786t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/8/10786l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/8/10786.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/8/10786t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/8/10786l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Yu☆Gi☆Oh! 5D's: Shinkasuru Kettou! Stardust vs. Red Demon's"
            },
            {
              "type": "Synonym",
              "title": "Yu-Gi-Oh! 5D's: Evolving Duel! Stardust vs. Red Daemon's"
            },
            {
              "type": "Japanese",
              "title": "遊☆戯☆王5D's 進化する決闘! スターダストVSレッド・デーモンズ"
            }
          ],
          "title": "Yu☆Gi☆Oh! 5D's: Shinkasuru Kettou! Stardust vs. Red Demon's",
          "title_english": null,
          "title_japanese": "遊☆戯☆王5D's 進化する決闘! スターダストVSレッド・デーモンズ",
          "title_synonyms": [
            "Yu-Gi-Oh! 5D's: Evolving Duel! Stardust vs. Red Daemon's"
          ],
          "type": "Special",
          "source": "Manga",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2008-09-21T00:00:00+00:00",
            "to": "2008-11-23T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 21,
                "month": 9,
                "year": 2008
              },
              "to": {
                "day": 23,
                "month": 11,
                "year": 2008
              }
            },
            "string": "Sep 21, 2008 to Nov 23, 2008"
          },
          "duration": "28 min",
          "rating": "PG-13 - Teens 13 or older",
          "score": 6.93,
          "scored_by": 4938,
          "rank": 4728,
          "popularity": 6555,
          "members": 11029,
          "favorites": 7,
          "synopsis": "A non-canon Yu☆Gi☆Oh! 5D's special from the 2008 Super Jump Anime Tour. Yuusei Fudou and Jack Atlas face off in a Riding Duel for the title of Duel King, with Aki and the twins watching. The ace dragons, Stardust Dragon and Red Daemon's Dragon, clash once again, and this time gain the power to 'evolve' using the Buster Mode trap card, becoming \"Stardust Dragon/Buster\" and \"Red Demon's Dragon/Buster.\"",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [],
          "licensors": [],
          "studios": [
            {
              "mal_id": 36,
              "type": "anime",
              "name": "Gallop",
              "url": "https://myanimelist.net/anime/producer/36/Gallop"
            }
          ],
          "genres": [
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 24,
              "type": "anime",
              "name": "Sci-Fi",
              "url": "https://myanimelist.net/anime/genre/24/Sci-Fi"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 11,
              "type": "anime",
              "name": "Strategy Game",
              "url": "https://myanimelist.net/anime/genre/11/Strategy_Game"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 40217,
          "url": "https://myanimelist.net/anime/40217/Naedoko_Demons_Ground",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1589/102640.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1589/102640t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1589/102640l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1589/102640.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1589/102640t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1589/102640l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Naedoko Demon's Ground"
            },
            {
              "type": "Japanese",
              "title": "苗床デモンズグラウンド"
            }
          ],
          "title": "Naedoko Demon's Ground",
          "title_english": null,
          "title_japanese": "苗床デモンズグラウンド",
          "title_synonyms": [],
          "type": "ONA",
          "source": "Game",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2019-07-26T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 26,
                "month": 7,
                "year": 2019
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Jul 26, 2019"
          },
          "duration": "15 min",
          "rating": "Rx - Hentai",
          "score": 5.43,
          "scored_by": 1005,
          "rank": null,
          "popularity": 11239,
          "members": 2517,
          "favorites": 3,
          "synopsis": "Lu Luu had went missing after heading to the town castle and Eliza and the gang went out to look for her.\n\nThere they found a girl named Jard bound up and violated...\n\nTo their horror, they discovered that the Acklem knights capture female adventurers and offer them to monsters as human seed beds... and they were next...\n\n(Source: hanime)",
          "background": "",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [
            {
              "mal_id": 2049,
              "type": "anime",
              "name": "BOMB! CUTE! BOMB!",
              "url": "https://myanimelist.net/anime/producer/2049/BOMB_CUTE_BOMB"
            }
          ],
          "licensors": [],
          "studios": [],
          "genres": [
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 12,
              "type": "anime",
              "name": "Hentai",
              "url": "https://myanimelist.net/anime/genre/12/Hentai"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 6,
              "type": "anime",
              "name": "Mythology",
              "url": "https://myanimelist.net/anime/genre/6/Mythology"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 38000,
          "url": "https://myanimelist.net/anime/38000/Kimetsu_no_Yaiba",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1286/99889.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1286/99889t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1286/99889l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1286/99889.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1286/99889t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1286/99889l.webp"
            }
          },
          "trailer": {
            "youtube_id": "6vMuWuWlW4I",
            "url": "https://www.youtube.com/watch?v=6vMuWuWlW4I",
            "embed_url": "https://www.youtube.com/embed/6vMuWuWlW4I?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/6vMuWuWlW4I/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/6vMuWuWlW4I/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/6vMuWuWlW4I/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/6vMuWuWlW4I/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/6vMuWuWlW4I/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Kimetsu no Yaiba"
            },
            {
              "type": "Synonym",
              "title": "Blade of Demon Destruction"
            },
            {
              "type": "Japanese",
              "title": "鬼滅の刃"
            },
            {
              "type": "English",
              "title": "Demon Slayer: Kimetsu no Yaiba"
            },
            {
              "type": "German",
              "title": "Demon Slayer"
            },
            {
              "type": "Spanish",
              "title": "Guardianes De La Noche: Kimetsu no Yaiba"
            },
            {
              "type": "French",
              "title": "Demon Slayer"
            }
          ],
          "title": "Kimetsu no Yaiba",
          "title_english": "Demon Slayer: Kimetsu no Yaiba",
          "title_japanese": "鬼滅の刃",
          "title_synonyms": [
            "Blade of Demon Destruction"
          ],
          "type": "TV",
          "source": "Manga",
          "episodes": 26,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2019-04-06T00:00:00+00:00",
            "to": "2019-09-28T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 6,
                "month": 4,
                "year": 2019
              },
              "to": {
                "day": 28,
                "month": 9,
                "year": 2019
              }
            },
            "string": "Apr 6, 2019 to Sep 28, 2019"
          },
          "duration": "23 min per ep",
          "rating": "R - 17+ (violence & profanity)",
          "score": 8.44,
          "scored_by": 2223254,
          "rank": 176,
          "popularity": 5,
          "members": 3235642,
          "favorites": 92773,
          "synopsis": "Ever since the death of his father, the burden of supporting the family has fallen upon Tanjirou Kamado's shoulders. Though living impoverished on a remote mountain, the Kamado family are able to enjoy a relatively peaceful and happy life. One day, Tanjirou decides to go down to the local village to make a little money selling charcoal. On his way back, night falls, forcing Tanjirou to take shelter in the house of a strange man, who warns him of the existence of flesh-eating demons that lurk in the woods at night.\n\nWhen he finally arrives back home the next day, he is met with a horrifying sight—his whole family has been slaughtered. Worse still, the sole survivor is his sister Nezuko, who has been turned into a bloodthirsty demon. Consumed by rage and hatred, Tanjirou swears to avenge his family and stay by his only remaining sibling. Alongside the mysterious group calling themselves the Demon Slayer Corps, Tanjirou will do whatever it takes to slay the demons and protect the remnants of his beloved sister's humanity.\n\n[Written by MAL Rewrite]",
          "background": "The anime covers chapters 1 to 53 of the manga. Kimetsu no Yaiba won the Animation of the Year award in the Television category at the Tokyo Anime Award Festival in 2020.",
          "season": "spring",
          "year": 2019,
          "broadcast": {
            "day": "Saturdays",
            "time": "23:30",
            "timezone": "Asia/Tokyo",
            "string": "Saturdays at 23:30 (JST)"
          },
          "producers": [
            {
              "mal_id": 17,
              "type": "anime",
              "name": "Aniplex",
              "url": "https://myanimelist.net/anime/producer/17/Aniplex"
            },
            {
              "mal_id": 719,
              "type": "anime",
              "name": "Studio Mausu",
              "url": "https://myanimelist.net/anime/producer/719/Studio_Mausu"
            },
            {
              "mal_id": 1365,
              "type": "anime",
              "name": "Shueisha",
              "url": "https://myanimelist.net/anime/producer/1365/Shueisha"
            }
          ],
          "licensors": [
            {
              "mal_id": 493,
              "type": "anime",
              "name": "Aniplex of America",
              "url": "https://myanimelist.net/anime/producer/493/Aniplex_of_America"
            }
          ],
          "studios": [
            {
              "mal_id": 43,
              "type": "anime",
              "name": "ufotable",
              "url": "https://myanimelist.net/anime/producer/43/ufotable"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 46,
              "type": "anime",
              "name": "Award Winning",
              "url": "https://myanimelist.net/anime/genre/46/Award_Winning"
            },
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Supernatural",
              "url": "https://myanimelist.net/anime/genre/37/Supernatural"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 13,
              "type": "anime",
              "name": "Historical",
              "url": "https://myanimelist.net/anime/genre/13/Historical"
            }
          ],
          "demographics": [
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 40456,
          "url": "https://myanimelist.net/anime/40456/Kimetsu_no_Yaiba_Movie__Mugen_Ressha-hen",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1704/106947.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1704/106947t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1704/106947l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1704/106947.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1704/106947t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1704/106947l.webp"
            }
          },
          "trailer": {
            "youtube_id": "PrZ0O8Qp18s",
            "url": "https://www.youtube.com/watch?v=PrZ0O8Qp18s",
            "embed_url": "https://www.youtube.com/embed/PrZ0O8Qp18s?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/PrZ0O8Qp18s/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/PrZ0O8Qp18s/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/PrZ0O8Qp18s/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/PrZ0O8Qp18s/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/PrZ0O8Qp18s/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Kimetsu no Yaiba Movie: Mugen Ressha-hen"
            },
            {
              "type": "Synonym",
              "title": "Gekijouban Kimetsu no Yaiba: Mugen Ressha-hen"
            },
            {
              "type": "Synonym",
              "title": "Kimetsu no Yaiba: Infinity Train"
            },
            {
              "type": "Synonym",
              "title": "Demon Slayer Movie: Infinity Train"
            },
            {
              "type": "Japanese",
              "title": "劇場版 鬼滅の刃 無限列車編"
            },
            {
              "type": "English",
              "title": "Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train"
            },
            {
              "type": "Spanish",
              "title": "Guardianes De La Noche - Kimetsu No Yaiba - Tren Infinito"
            },
            {
              "type": "French",
              "title": "Demon Slayer - Kimetsu no Yaiba - Le film : Le train de l'Infini"
            }
          ],
          "title": "Kimetsu no Yaiba Movie: Mugen Ressha-hen",
          "title_english": "Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train",
          "title_japanese": "劇場版 鬼滅の刃 無限列車編",
          "title_synonyms": [
            "Gekijouban Kimetsu no Yaiba: Mugen Ressha-hen",
            "Kimetsu no Yaiba: Infinity Train",
            "Demon Slayer Movie: Infinity Train"
          ],
          "type": "Movie",
          "source": "Manga",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2020-10-16T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 16,
                "month": 10,
                "year": 2020
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Oct 16, 2020"
          },
          "duration": "1 hr 56 min",
          "rating": "R - 17+ (violence & profanity)",
          "score": 8.56,
          "scored_by": 1101138,
          "rank": 109,
          "popularity": 71,
          "members": 1658816,
          "favorites": 13356,
          "synopsis": "After a string of mysterious disappearances begin to plague a train, the Demon Slayer Corps' multiple attempts to remedy the problem prove fruitless. To prevent further casualties, the Flame Pillar, Kyoujurou Rengoku, takes it upon himself to eliminate the threat. Accompanying him are some of the Corps' most promising new blood: Tanjirou Kamado, Zenitsu Agatsuma, and Inosuke Hashibira, who all hope to witness the fiery feats of this model demon slayer firsthand.\n\nUnbeknownst to them, the demonic forces responsible for the disappearances have already put their sinister plan in motion. Under this demonic presence, the group must muster every ounce of their willpower and draw their swords to save all two hundred passengers onboard. As things begin to spiral out of control, Tanjirou's resolve and commitment to duty are put to the test.\n\n[Written by MAL Rewrite]",
          "background": "The worldwide box office total for Kimetsu no Yaiba Movie: Mugen Ressha-hen is over ${'$'}503 million from more than 41 million tickets sold, making it the highest-grossing film of 2020 as well as the highest-grossing anime and Japanese film of all time. It was the first time in the history of cinema that a non-Hollywood production topped the annual worldwide box office. It also became the highest-grossing R-rated animated film of all time.",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [
            {
              "mal_id": 17,
              "type": "anime",
              "name": "Aniplex",
              "url": "https://myanimelist.net/anime/producer/17/Aniplex"
            },
            {
              "mal_id": 1365,
              "type": "anime",
              "name": "Shueisha",
              "url": "https://myanimelist.net/anime/producer/1365/Shueisha"
            }
          ],
          "licensors": [
            {
              "mal_id": 493,
              "type": "anime",
              "name": "Aniplex of America",
              "url": "https://myanimelist.net/anime/producer/493/Aniplex_of_America"
            }
          ],
          "studios": [
            {
              "mal_id": 43,
              "type": "anime",
              "name": "ufotable",
              "url": "https://myanimelist.net/anime/producer/43/ufotable"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Supernatural",
              "url": "https://myanimelist.net/anime/genre/37/Supernatural"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 13,
              "type": "anime",
              "name": "Historical",
              "url": "https://myanimelist.net/anime/genre/13/Historical"
            }
          ],
          "demographics": [
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 40496,
          "url": "https://myanimelist.net/anime/40496/Maou_Gakuin_no_Futekigousha__Shijou_Saikyou_no_Maou_no_Shiso_Tensei_shite_Shison-tachi_no_Gakkou_e_Kayou",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1126/108573.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1126/108573t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1126/108573l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1126/108573.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1126/108573t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1126/108573l.webp"
            }
          },
          "trailer": {
            "youtube_id": "1xmzzF0XQEY",
            "url": "https://www.youtube.com/watch?v=1xmzzF0XQEY",
            "embed_url": "https://www.youtube.com/embed/1xmzzF0XQEY?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/1xmzzF0XQEY/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/1xmzzF0XQEY/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/1xmzzF0XQEY/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/1xmzzF0XQEY/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/1xmzzF0XQEY/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Maou Gakuin no Futekigousha: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou"
            },
            {
              "type": "Synonym",
              "title": "The Misfit of Demon King Academy: History's Strongest Demon King Reincarnates and Goes to School with His Descendants"
            },
            {
              "type": "Japanese",
              "title": "魔王学院の不適合者 ～史上最強の魔王の始祖、転生して子孫たちの学校へ通う～"
            },
            {
              "type": "English",
              "title": "The Misfit of Demon King Academy"
            },
            {
              "type": "German",
              "title": "The Misfit of Demon King Academy"
            },
            {
              "type": "Spanish",
              "title": "The Misfit of Demon King Academy"
            },
            {
              "type": "French",
              "title": "The Misfit of Demon King Academy"
            }
          ],
          "title": "Maou Gakuin no Futekigousha: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou",
          "title_english": "The Misfit of Demon King Academy",
          "title_japanese": "魔王学院の不適合者 ～史上最強の魔王の始祖、転生して子孫たちの学校へ通う～",
          "title_synonyms": [
            "The Misfit of Demon King Academy: History's Strongest Demon King Reincarnates and Goes to School with His Descendants"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 13,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2020-07-04T00:00:00+00:00",
            "to": "2020-09-26T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 4,
                "month": 7,
                "year": 2020
              },
              "to": {
                "day": 26,
                "month": 9,
                "year": 2020
              }
            },
            "string": "Jul 4, 2020 to Sep 26, 2020"
          },
          "duration": "23 min per ep",
          "rating": "R - 17+ (violence & profanity)",
          "score": 7.33,
          "scored_by": 502258,
          "rank": 2696,
          "popularity": 229,
          "members": 859747,
          "favorites": 5791,
          "synopsis": "In the distant past, a war between humans and demons brought about widespread chaos and bloodshed. To put an end to this seemingly endless conflict, Demon King Anos Voldigoad willingly sacrificed his life, hoping to be reborn in a peaceful future.\n\nIn preparation for their king's return, the demon race created the Demon King Academy, an elite institution tasked with determining Anos' identity when he reawakens. He reincarnates two millennia later, but to his surprise, he soon learns that the level of magic in the world has drastically waned during his absence. Moreover, when he enrolls at the academy to reclaim his rightful title, he finds out that demonkind remembers him differently. His personality, his deeds, and even his legacy are all falsified—masked beneath the name of an impostor. This \"lack\" of common knowledge renders him the academy's outlier—a misfit never before seen in history.\n\nDespite these drawbacks, Anos remains unfazed. As he sets out to uncover those altering his glorious past, he takes it upon himself to make his descendants recognize that their ruler has finally returned.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "summer",
          "year": 2020,
          "broadcast": {
            "day": "Saturdays",
            "time": "23:30",
            "timezone": "Asia/Tokyo",
            "string": "Saturdays at 23:30 (JST)"
          },
          "producers": [
            {
              "mal_id": 17,
              "type": "anime",
              "name": "Aniplex",
              "url": "https://myanimelist.net/anime/producer/17/Aniplex"
            },
            {
              "mal_id": 166,
              "type": "anime",
              "name": "Movic",
              "url": "https://myanimelist.net/anime/producer/166/Movic"
            },
            {
              "mal_id": 238,
              "type": "anime",
              "name": "AT-X",
              "url": "https://myanimelist.net/anime/producer/238/AT-X"
            },
            {
              "mal_id": 719,
              "type": "anime",
              "name": "Studio Mausu",
              "url": "https://myanimelist.net/anime/producer/719/Studio_Mausu"
            },
            {
              "mal_id": 1211,
              "type": "anime",
              "name": "Tokyo MX",
              "url": "https://myanimelist.net/anime/producer/1211/Tokyo_MX"
            },
            {
              "mal_id": 1287,
              "type": "anime",
              "name": "Q-Tec",
              "url": "https://myanimelist.net/anime/producer/1287/Q-Tec"
            },
            {
              "mal_id": 1334,
              "type": "anime",
              "name": "Docomo Anime Store",
              "url": "https://myanimelist.net/anime/producer/1334/Docomo_Anime_Store"
            },
            {
              "mal_id": 1337,
              "type": "anime",
              "name": "Medicos Entertainment",
              "url": "https://myanimelist.net/anime/producer/1337/Medicos_Entertainment"
            },
            {
              "mal_id": 1416,
              "type": "anime",
              "name": "BS11",
              "url": "https://myanimelist.net/anime/producer/1416/BS11"
            },
            {
              "mal_id": 1554,
              "type": "anime",
              "name": "Contents Seed",
              "url": "https://myanimelist.net/anime/producer/1554/Contents_Seed"
            },
            {
              "mal_id": 1696,
              "type": "anime",
              "name": "Kadokawa",
              "url": "https://myanimelist.net/anime/producer/1696/Kadokawa"
            },
            {
              "mal_id": 2232,
              "type": "anime",
              "name": "ADK Marketing Solutions",
              "url": "https://myanimelist.net/anime/producer/2232/ADK_Marketing_Solutions"
            }
          ],
          "licensors": [
            {
              "mal_id": 493,
              "type": "anime",
              "name": "Aniplex of America",
              "url": "https://myanimelist.net/anime/producer/493/Aniplex_of_America"
            }
          ],
          "studios": [
            {
              "mal_id": 300,
              "type": "anime",
              "name": "SILVER LINK.",
              "url": "https://myanimelist.net/anime/producer/300/SILVER_LINK"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 72,
              "type": "anime",
              "name": "Reincarnation",
              "url": "https://myanimelist.net/anime/genre/72/Reincarnation"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 37210,
          "url": "https://myanimelist.net/anime/37210/Isekai_Maou_to_Shoukan_Shoujo_no_Dorei_Majutsu",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1649/93412.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1649/93412t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1649/93412l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1649/93412.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1649/93412t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1649/93412l.webp"
            }
          },
          "trailer": {
            "youtube_id": "8a0gn8mmnaY",
            "url": "https://www.youtube.com/watch?v=8a0gn8mmnaY",
            "embed_url": "https://www.youtube.com/embed/8a0gn8mmnaY?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/8a0gn8mmnaY/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/8a0gn8mmnaY/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/8a0gn8mmnaY/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/8a0gn8mmnaY/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/8a0gn8mmnaY/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Isekai Maou to Shoukan Shoujo no Dorei Majutsu"
            },
            {
              "type": "Synonym",
              "title": "The Otherworldly Demon King and the Summoner Girls' Slave Magic"
            },
            {
              "type": "Japanese",
              "title": "異世界魔王と召喚少女の奴隷魔術"
            },
            {
              "type": "English",
              "title": "How Not to Summon a Demon Lord"
            },
            {
              "type": "German",
              "title": "How Not To Summon A Demon Lord"
            },
            {
              "type": "Spanish",
              "title": "How not to Summon a Demon Lord"
            },
            {
              "type": "French",
              "title": "How Not to Summon a Demon Lord"
            }
          ],
          "title": "Isekai Maou to Shoukan Shoujo no Dorei Majutsu",
          "title_english": "How Not to Summon a Demon Lord",
          "title_japanese": "異世界魔王と召喚少女の奴隷魔術",
          "title_synonyms": [
            "The Otherworldly Demon King and the Summoner Girls' Slave Magic"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2018-07-05T00:00:00+00:00",
            "to": "2018-09-20T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 5,
                "month": 7,
                "year": 2018
              },
              "to": {
                "day": 20,
                "month": 9,
                "year": 2018
              }
            },
            "string": "Jul 5, 2018 to Sep 20, 2018"
          },
          "duration": "23 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 6.82,
          "scored_by": 443220,
          "rank": 5260,
          "popularity": 278,
          "members": 765704,
          "favorites": 2537,
          "synopsis": "When it comes to the fantasy MMORPG Cross Reverie, none can match the power of the Demon King Diablo. Possessing the game's rarest artifacts and an unrivaled player level, he overpowers all foolish enough to confront him. But despite his fearsome reputation, Diablo's true identity is Takuma Sakamoto, a shut-in gamer devoid of any social skills. Defeating hopeless challengers day by day, Takuma cares about nothing else but his virtual life—that is, until a summoning spell suddenly transports him to another world where he has Diablo's appearance! \n\nIn this new world resembling his favorite game, Takuma is greeted by the two girls who summoned him: Rem Galeu, a petite Pantherian adventurer, and Shera L. Greenwood, a busty Elf summoner. They perform an Enslavement Ritual in an attempt to subjugate him, but the spell backfires and causes them to become his slaves instead. With the situation now becoming more awkward than ever, Takuma decides to accompany the girls in finding a way to unbind their contract while learning to adapt to his new existence as the menacing Demon King.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "summer",
          "year": 2018,
          "broadcast": {
            "day": "Thursdays",
            "time": "21:30",
            "timezone": "Asia/Tokyo",
            "string": "Thursdays at 21:30 (JST)"
          },
          "producers": [
            {
              "mal_id": 64,
              "type": "anime",
              "name": "Sotsu",
              "url": "https://myanimelist.net/anime/producer/64/Sotsu"
            },
            {
              "mal_id": 159,
              "type": "anime",
              "name": "Kodansha",
              "url": "https://myanimelist.net/anime/producer/159/Kodansha"
            },
            {
              "mal_id": 213,
              "type": "anime",
              "name": "Half H.P Studio",
              "url": "https://myanimelist.net/anime/producer/213/Half_HP_Studio"
            },
            {
              "mal_id": 238,
              "type": "anime",
              "name": "AT-X",
              "url": "https://myanimelist.net/anime/producer/238/AT-X"
            },
            {
              "mal_id": 460,
              "type": "anime",
              "name": "KlockWorx",
              "url": "https://myanimelist.net/anime/producer/460/KlockWorx"
            },
            {
              "mal_id": 1039,
              "type": "anime",
              "name": "DIVE II Entertainment",
              "url": "https://myanimelist.net/anime/producer/1039/DIVE_II_Entertainment"
            },
            {
              "mal_id": 1185,
              "type": "anime",
              "name": "81 Produce",
              "url": "https://myanimelist.net/anime/producer/1185/81_Produce"
            },
            {
              "mal_id": 1211,
              "type": "anime",
              "name": "Tokyo MX",
              "url": "https://myanimelist.net/anime/producer/1211/Tokyo_MX"
            },
            {
              "mal_id": 1284,
              "type": "anime",
              "name": "Avex Pictures",
              "url": "https://myanimelist.net/anime/producer/1284/Avex_Pictures"
            },
            {
              "mal_id": 1287,
              "type": "anime",
              "name": "Q-Tec",
              "url": "https://myanimelist.net/anime/producer/1287/Q-Tec"
            },
            {
              "mal_id": 1449,
              "type": "anime",
              "name": "Animatic",
              "url": "https://myanimelist.net/anime/producer/1449/Animatic"
            },
            {
              "mal_id": 2038,
              "type": "anime",
              "name": "S-Wood",
              "url": "https://myanimelist.net/anime/producer/2038/S-Wood"
            }
          ],
          "licensors": [
            {
              "mal_id": 102,
              "type": "anime",
              "name": "Funimation",
              "url": "https://myanimelist.net/anime/producer/102/Funimation"
            }
          ],
          "studios": [
            {
              "mal_id": 30,
              "type": "anime",
              "name": "Ajia-do",
              "url": "https://myanimelist.net/anime/producer/30/Ajia-do"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 22,
              "type": "anime",
              "name": "Romance",
              "url": "https://myanimelist.net/anime/genre/22/Romance"
            },
            {
              "mal_id": 9,
              "type": "anime",
              "name": "Ecchi",
              "url": "https://myanimelist.net/anime/genre/9/Ecchi"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 35,
              "type": "anime",
              "name": "Harem",
              "url": "https://myanimelist.net/anime/genre/35/Harem"
            },
            {
              "mal_id": 62,
              "type": "anime",
              "name": "Isekai",
              "url": "https://myanimelist.net/anime/genre/62/Isekai"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 7088,
          "url": "https://myanimelist.net/anime/7088/Ichiban_Ushiro_no_Daimaou",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/11/75554.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/11/75554t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/11/75554l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/11/75554.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/11/75554t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/11/75554l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Ichiban Ushiro no Daimaou"
            },
            {
              "type": "Synonym",
              "title": "Ichiban Ushiro no Dai Mao"
            },
            {
              "type": "Japanese",
              "title": "いちばんうしろの大魔王"
            },
            {
              "type": "English",
              "title": "Demon King Daimao"
            },
            {
              "type": "German",
              "title": "Demon King Daimao"
            },
            {
              "type": "Spanish",
              "title": "Demon King Daimao"
            },
            {
              "type": "French",
              "title": "Demon King Daimao"
            }
          ],
          "title": "Ichiban Ushiro no Daimaou",
          "title_english": "Demon King Daimao",
          "title_japanese": "いちばんうしろの大魔王",
          "title_synonyms": [
            "Ichiban Ushiro no Dai Mao"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2010-04-03T00:00:00+00:00",
            "to": "2010-06-19T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 3,
                "month": 4,
                "year": 2010
              },
              "to": {
                "day": 19,
                "month": 6,
                "year": 2010
              }
            },
            "string": "Apr 3, 2010 to Jun 19, 2010"
          },
          "duration": "23 min per ep",
          "rating": "R+ - Mild Nudity",
          "score": 6.71,
          "scored_by": 310939,
          "rank": 5891,
          "popularity": 435,
          "members": 547875,
          "favorites": 1296,
          "synopsis": "Dreaming of changing the world for good, Akuto Sai transfers to Constant Magic Academy where he befriends a virtuous ninja clan member, Junko Hattori. On the way to the academy, they vow to make the world a better place together; however, the situation suddenly takes a turn for the worse upon his arrival—it is prophesied that he will become the Demon King!\n\nAs word of his destiny spreads, the school begins to fear him, and Junko's trust in him falters. While Akuto is determined to not let his predicted future control his fate, it seems as though everything he says and does only serve to reinforce the fact that he is destined to be the Demon King. Moreover, he is surrounded by a harem of beautiful girls who each have their own plans for him, ranging from bringing him to justice to simply showering him with love. With his newly awakened powers, Akuto must cope with his constantly growing list of misfortunes and fight to prove that his fate is not set in stone.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "spring",
          "year": 2010,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": "Unknown"
          },
          "producers": [
            {
              "mal_id": 82,
              "type": "anime",
              "name": "Marvelous Entertainment",
              "url": "https://myanimelist.net/anime/producer/82/Marvelous_Entertainment"
            },
            {
              "mal_id": 547,
              "type": "anime",
              "name": "Hobby Japan",
              "url": "https://myanimelist.net/anime/producer/547/Hobby_Japan"
            },
            {
              "mal_id": 711,
              "type": "anime",
              "name": "Delfi Sound",
              "url": "https://myanimelist.net/anime/producer/711/Delfi_Sound"
            }
          ],
          "licensors": [
            {
              "mal_id": 376,
              "type": "anime",
              "name": "Sentai Filmworks",
              "url": "https://myanimelist.net/anime/producer/376/Sentai_Filmworks"
            }
          ],
          "studios": [
            {
              "mal_id": 8,
              "type": "anime",
              "name": "Artland",
              "url": "https://myanimelist.net/anime/producer/8/Artland"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 22,
              "type": "anime",
              "name": "Romance",
              "url": "https://myanimelist.net/anime/genre/22/Romance"
            },
            {
              "mal_id": 9,
              "type": "anime",
              "name": "Ecchi",
              "url": "https://myanimelist.net/anime/genre/9/Ecchi"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 35,
              "type": "anime",
              "name": "Harem",
              "url": "https://myanimelist.net/anime/genre/35/Harem"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 39196,
          "url": "https://myanimelist.net/anime/39196/Mairimashita_Iruma-kun",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1009/103187.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1009/103187t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1009/103187l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1009/103187.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1009/103187t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1009/103187l.webp"
            }
          },
          "trailer": {
            "youtube_id": "kkeuJt0DE7g",
            "url": "https://www.youtube.com/watch?v=kkeuJt0DE7g",
            "embed_url": "https://www.youtube.com/embed/kkeuJt0DE7g?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/kkeuJt0DE7g/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/kkeuJt0DE7g/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/kkeuJt0DE7g/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/kkeuJt0DE7g/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/kkeuJt0DE7g/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Mairimashita! Iruma-kun"
            },
            {
              "type": "Japanese",
              "title": "魔入りました！入間くん"
            },
            {
              "type": "English",
              "title": "Welcome to Demon School! Iruma-kun"
            },
            {
              "type": "German",
              "title": "Welcome to Demon School! Iruma-kun"
            },
            {
              "type": "Spanish",
              "title": "Welcome to Demon School! Iruma-kun"
            },
            {
              "type": "French",
              "title": "Welcome to Demon School! Iruma-kun"
            }
          ],
          "title": "Mairimashita! Iruma-kun",
          "title_english": "Welcome to Demon School! Iruma-kun",
          "title_japanese": "魔入りました！入間くん",
          "title_synonyms": [],
          "type": "TV",
          "source": "Manga",
          "episodes": 23,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2019-10-05T00:00:00+00:00",
            "to": "2020-03-07T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 5,
                "month": 10,
                "year": 2019
              },
              "to": {
                "day": 7,
                "month": 3,
                "year": 2020
              }
            },
            "string": "Oct 5, 2019 to Mar 7, 2020"
          },
          "duration": "23 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.74,
          "scored_by": 278531,
          "rank": 1202,
          "popularity": 450,
          "members": 530330,
          "favorites": 4691,
          "synopsis": "Fourteen-year-old Iruma Suzuki has been unfortunate all his life, having to work to earn money for his irresponsible parents despite being underage. One day, he finds out that his parents sold him to the demon Sullivan. However, Iruma's worries about what will become of him are soon relieved, for Sullivan merely wants a grandchild, pampering him and making him attend the demon school Babyls. \n\nAt first, Iruma tries to keep a low profile in fear of his peers discovering that he is human. Unfortunately, this ends up being more difficult than he expected. It turns out that Sullivan himself is the chairman of the school, and everyone expects him to become the next Demon King!\n\nIruma immediately finds himself in an outrageous situation when he has to chant a forbidden spell in front of the entire school. With this, Iruma instantly earns a reputation he does not want. Even so, he is bound to be roped into more bizarre circumstances.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "fall",
          "year": 2019,
          "broadcast": {
            "day": "Saturdays",
            "time": "17:35",
            "timezone": "Asia/Tokyo",
            "string": "Saturdays at 17:35 (JST)"
          },
          "producers": [
            {
              "mal_id": 111,
              "type": "anime",
              "name": "NHK",
              "url": "https://myanimelist.net/anime/producer/111/NHK"
            },
            {
              "mal_id": 1797,
              "type": "anime",
              "name": "NHK Enterprises",
              "url": "https://myanimelist.net/anime/producer/1797/NHK_Enterprises"
            }
          ],
          "licensors": [],
          "studios": [
            {
              "mal_id": 1258,
              "type": "anime",
              "name": "Bandai Namco Pictures",
              "url": "https://myanimelist.net/anime/producer/1258/Bandai_Namco_Pictures"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": [
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 41623,
          "url": "https://myanimelist.net/anime/41623/Isekai_Maou_to_Shoukan_Shoujo_no_Dorei_Majutsu_Ω",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1011/113703.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1011/113703t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1011/113703l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1011/113703.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1011/113703t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1011/113703l.webp"
            }
          },
          "trailer": {
            "youtube_id": "TQokj-9LYv8",
            "url": "https://www.youtube.com/watch?v=TQokj-9LYv8",
            "embed_url": "https://www.youtube.com/embed/TQokj-9LYv8?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/TQokj-9LYv8/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/TQokj-9LYv8/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/TQokj-9LYv8/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/TQokj-9LYv8/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/TQokj-9LYv8/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Isekai Maou to Shoukan Shoujo no Dorei Majutsu Ω"
            },
            {
              "type": "Synonym",
              "title": "How Not to Summon a Demon Lord 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "Isekai Maou to Shoukan Shoujo no Dorei Majutsu 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "The Otherworldly Demon King and the Summoner Girls' Slave Magic 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "Isekai Maou to Shoukan Shoujo no Dorei Majutsu Omega"
            },
            {
              "type": "Japanese",
              "title": "異世界魔王と召喚少女の奴隷魔術Ω"
            },
            {
              "type": "English",
              "title": "How Not to Summon a Demon Lord Ω"
            },
            {
              "type": "German",
              "title": "How Not to Summon a Demon Lord Ω"
            },
            {
              "type": "Spanish",
              "title": "How Not to Summon a Demon Lord Ω"
            },
            {
              "type": "French",
              "title": "How Not to Summon a Demon Lord Ω"
            }
          ],
          "title": "Isekai Maou to Shoukan Shoujo no Dorei Majutsu Ω",
          "title_english": "How Not to Summon a Demon Lord Ω",
          "title_japanese": "異世界魔王と召喚少女の奴隷魔術Ω",
          "title_synonyms": [
            "How Not to Summon a Demon Lord 2nd Season",
            "Isekai Maou to Shoukan Shoujo no Dorei Majutsu 2nd Season",
            "The Otherworldly Demon King and the Summoner Girls' Slave Magic 2nd Season",
            "Isekai Maou to Shoukan Shoujo no Dorei Majutsu Omega"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 10,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2021-04-09T00:00:00+00:00",
            "to": "2021-06-11T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 9,
                "month": 4,
                "year": 2021
              },
              "to": {
                "day": 11,
                "month": 6,
                "year": 2021
              }
            },
            "string": "Apr 9, 2021 to Jun 11, 2021"
          },
          "duration": "24 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 6.69,
          "scored_by": 200227,
          "rank": 6032,
          "popularity": 555,
          "members": 443256,
          "favorites": 2756,
          "synopsis": "The Demon King Diablo is back as... God? A fateful encounter with the High Priest Lumachina Weselia finds Diablo and his party accompanying this mysterious stranger on a journey to cleanse the Church of its corruption. Believed to be God by Lumachina, Diablo eventually decides to protect her on her initial quest to find the head paladin, the virtuous Batutta.\n\nDiablo, Rem, Shera and Lumachina are joined by the grasswalker, Horn and the Magmatic Maid, Rose. Will Diablo fulfil Lumachina's wish? And can the Demon Lord from Another World truly play the role of God?",
          "background": "",
          "season": "spring",
          "year": 2021,
          "broadcast": {
            "day": "Fridays",
            "time": "01:28",
            "timezone": "Asia/Tokyo",
            "string": "Fridays at 01:28 (JST)"
          },
          "producers": [
            {
              "mal_id": 145,
              "type": "anime",
              "name": "TBS",
              "url": "https://myanimelist.net/anime/producer/145/TBS"
            },
            {
              "mal_id": 159,
              "type": "anime",
              "name": "Kodansha",
              "url": "https://myanimelist.net/anime/producer/159/Kodansha"
            },
            {
              "mal_id": 213,
              "type": "anime",
              "name": "Half H.P Studio",
              "url": "https://myanimelist.net/anime/producer/213/Half_HP_Studio"
            },
            {
              "mal_id": 460,
              "type": "anime",
              "name": "KlockWorx",
              "url": "https://myanimelist.net/anime/producer/460/KlockWorx"
            },
            {
              "mal_id": 1185,
              "type": "anime",
              "name": "81 Produce",
              "url": "https://myanimelist.net/anime/producer/1185/81_Produce"
            },
            {
              "mal_id": 1284,
              "type": "anime",
              "name": "Avex Pictures",
              "url": "https://myanimelist.net/anime/producer/1284/Avex_Pictures"
            },
            {
              "mal_id": 1468,
              "type": "anime",
              "name": "Crunchyroll",
              "url": "https://myanimelist.net/anime/producer/1468/Crunchyroll"
            },
            {
              "mal_id": 1815,
              "type": "anime",
              "name": "GREE",
              "url": "https://myanimelist.net/anime/producer/1815/GREE"
            }
          ],
          "licensors": [
            {
              "mal_id": 102,
              "type": "anime",
              "name": "Funimation",
              "url": "https://myanimelist.net/anime/producer/102/Funimation"
            }
          ],
          "studios": [
            {
              "mal_id": 200,
              "type": "anime",
              "name": "Tezuka Productions",
              "url": "https://myanimelist.net/anime/producer/200/Tezuka_Productions"
            },
            {
              "mal_id": 2037,
              "type": "anime",
              "name": "Okuruto Noboru",
              "url": "https://myanimelist.net/anime/producer/2037/Okuruto_Noboru"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 22,
              "type": "anime",
              "name": "Romance",
              "url": "https://myanimelist.net/anime/genre/22/Romance"
            },
            {
              "mal_id": 9,
              "type": "anime",
              "name": "Ecchi",
              "url": "https://myanimelist.net/anime/genre/9/Ecchi"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 35,
              "type": "anime",
              "name": "Harem",
              "url": "https://myanimelist.net/anime/genre/35/Harem"
            },
            {
              "mal_id": 62,
              "type": "anime",
              "name": "Isekai",
              "url": "https://myanimelist.net/anime/genre/62/Isekai"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 48417,
          "url": "https://myanimelist.net/anime/48417/Maou_Gakuin_no_Futekigousha_II__Shijou_Saikyou_no_Maou_no_Shiso_Tensei_shite_Shison-tachi_no_Gakkou_e_Kayou",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1369/139553.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1369/139553t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1369/139553l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1369/139553.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1369/139553t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1369/139553l.webp"
            }
          },
          "trailer": {
            "youtube_id": "9u32S8C8L3g",
            "url": "https://www.youtube.com/watch?v=9u32S8C8L3g",
            "embed_url": "https://www.youtube.com/embed/9u32S8C8L3g?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/9u32S8C8L3g/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/9u32S8C8L3g/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/9u32S8C8L3g/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/9u32S8C8L3g/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/9u32S8C8L3g/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Maou Gakuin no Futekigousha II: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou"
            },
            {
              "type": "Synonym",
              "title": "Maou Gakuin no Futekigousha: Shijou Saikyou no Maou no Shiso"
            },
            {
              "type": "Synonym",
              "title": "Tensei shite Shison-tachi no Gakkou e Kayou 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "The Misfit of Demon King Academy 2nd Season"
            },
            {
              "type": "Japanese",
              "title": "魔王学院の不適合者 II～史上最強の魔王の始祖、転生して子孫たちの学校へ通う～"
            },
            {
              "type": "English",
              "title": "The Misfit of Demon King Academy Ⅱ"
            }
          ],
          "title": "Maou Gakuin no Futekigousha II: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou",
          "title_english": "The Misfit of Demon King Academy Ⅱ",
          "title_japanese": "魔王学院の不適合者 II～史上最強の魔王の始祖、転生して子孫たちの学校へ通う～",
          "title_synonyms": [
            "Maou Gakuin no Futekigousha: Shijou Saikyou no Maou no Shiso",
            "Tensei shite Shison-tachi no Gakkou e Kayou 2nd Season",
            "The Misfit of Demon King Academy 2nd Season"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2023-01-08T00:00:00+00:00",
            "to": "2023-09-24T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 8,
                "month": 1,
                "year": 2023
              },
              "to": {
                "day": 24,
                "month": 9,
                "year": 2023
              }
            },
            "string": "Jan 8, 2023 to Sep 24, 2023"
          },
          "duration": "23 min per ep",
          "rating": "R - 17+ (violence & profanity)",
          "score": 6.85,
          "scored_by": 116817,
          "rank": 5122,
          "popularity": 669,
          "members": 380195,
          "favorites": 4001,
          "synopsis": "As peace returns to the demon realm, Anos Voldigoad wishes nothing more than to put his reputation as the Demon King of Tyranny to rest and go back to being a misfit at the prestigious Demon King Academy. Unfortunately, any tranquility is fleeting: sinister demons, kings, and deities plot Anos's demise from the shadows.\n\nRumors spread about the \"Child of God,\" a being whose power may rival that of Anos. To uncover the truth and eliminate the potential threat, Anos must journey deep into the land of spirits. However, the spirit world is shrouded in mystery, and it may only be entered after undergoing a series of difficult trials.\n\nWith unrivaled power and confidence, Anos braces himself to defeat various formidable enemies with grandiose titles. But he—with the assistance of his trusted allies—will barely have to break a sweat as the true Demon King of Tyranny.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "winter",
          "year": 2023,
          "broadcast": {
            "day": "Sundays",
            "time": "00:30",
            "timezone": "Asia/Tokyo",
            "string": "Sundays at 00:30 (JST)"
          },
          "producers": [
            {
              "mal_id": 17,
              "type": "anime",
              "name": "Aniplex",
              "url": "https://myanimelist.net/anime/producer/17/Aniplex"
            },
            {
              "mal_id": 166,
              "type": "anime",
              "name": "Movic",
              "url": "https://myanimelist.net/anime/producer/166/Movic"
            },
            {
              "mal_id": 238,
              "type": "anime",
              "name": "AT-X",
              "url": "https://myanimelist.net/anime/producer/238/AT-X"
            },
            {
              "mal_id": 1211,
              "type": "anime",
              "name": "Tokyo MX",
              "url": "https://myanimelist.net/anime/producer/1211/Tokyo_MX"
            },
            {
              "mal_id": 1287,
              "type": "anime",
              "name": "Q-Tec",
              "url": "https://myanimelist.net/anime/producer/1287/Q-Tec"
            },
            {
              "mal_id": 1334,
              "type": "anime",
              "name": "Docomo Anime Store",
              "url": "https://myanimelist.net/anime/producer/1334/Docomo_Anime_Store"
            },
            {
              "mal_id": 1337,
              "type": "anime",
              "name": "Medicos Entertainment",
              "url": "https://myanimelist.net/anime/producer/1337/Medicos_Entertainment"
            },
            {
              "mal_id": 1416,
              "type": "anime",
              "name": "BS11",
              "url": "https://myanimelist.net/anime/producer/1416/BS11"
            },
            {
              "mal_id": 1492,
              "type": "anime",
              "name": "Yomiuri TV Enterprise",
              "url": "https://myanimelist.net/anime/producer/1492/Yomiuri_TV_Enterprise"
            },
            {
              "mal_id": 1554,
              "type": "anime",
              "name": "Contents Seed",
              "url": "https://myanimelist.net/anime/producer/1554/Contents_Seed"
            },
            {
              "mal_id": 1696,
              "type": "anime",
              "name": "Kadokawa",
              "url": "https://myanimelist.net/anime/producer/1696/Kadokawa"
            },
            {
              "mal_id": 2232,
              "type": "anime",
              "name": "ADK Marketing Solutions",
              "url": "https://myanimelist.net/anime/producer/2232/ADK_Marketing_Solutions"
            }
          ],
          "licensors": [
            {
              "mal_id": 493,
              "type": "anime",
              "name": "Aniplex of America",
              "url": "https://myanimelist.net/anime/producer/493/Aniplex_of_America"
            }
          ],
          "studios": [
            {
              "mal_id": 300,
              "type": "anime",
              "name": "SILVER LINK.",
              "url": "https://myanimelist.net/anime/producer/300/SILVER_LINK"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 72,
              "type": "anime",
              "name": "Reincarnation",
              "url": "https://myanimelist.net/anime/genre/72/Reincarnation"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 41402,
          "url": "https://myanimelist.net/anime/41402/Mairimashita_Iruma-kun_2nd_Season",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1527/113656.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1527/113656t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1527/113656l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1527/113656.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1527/113656t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1527/113656l.webp"
            }
          },
          "trailer": {
            "youtube_id": "NxqfMRZfVTA",
            "url": "https://www.youtube.com/watch?v=NxqfMRZfVTA",
            "embed_url": "https://www.youtube.com/embed/NxqfMRZfVTA?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/NxqfMRZfVTA/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/NxqfMRZfVTA/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/NxqfMRZfVTA/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/NxqfMRZfVTA/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/NxqfMRZfVTA/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Mairimashita! Iruma-kun 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "Welcome to Demon School! Iruma-kun 2nd Season"
            },
            {
              "type": "Japanese",
              "title": "魔入りました！入間くん"
            },
            {
              "type": "English",
              "title": "Welcome to Demon School! Iruma-kun Season 2"
            },
            {
              "type": "German",
              "title": "Welcome to Demon School! Iruma-kun Staffel 2"
            },
            {
              "type": "Spanish",
              "title": "Welcome to Demon School! Iruma-kun Temporada 2"
            },
            {
              "type": "French",
              "title": "Welcome to Demon School! Iruma-kun Saison 2"
            }
          ],
          "title": "Mairimashita! Iruma-kun 2nd Season",
          "title_english": "Welcome to Demon School! Iruma-kun Season 2",
          "title_japanese": "魔入りました！入間くん",
          "title_synonyms": [
            "Welcome to Demon School! Iruma-kun 2nd Season"
          ],
          "type": "TV",
          "source": "Manga",
          "episodes": 21,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2021-04-17T00:00:00+00:00",
            "to": "2021-09-11T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 17,
                "month": 4,
                "year": 2021
              },
              "to": {
                "day": 11,
                "month": 9,
                "year": 2021
              }
            },
            "string": "Apr 17, 2021 to Sep 11, 2021"
          },
          "duration": "24 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 8.03,
          "scored_by": 173801,
          "rank": 635,
          "popularity": 734,
          "members": 349081,
          "favorites": 2447,
          "synopsis": "After many trials and tribulations, Iruma Suzuki is finally happily living among demons despite having to hide his true identity as a human. Even more so, he has now found his ambition in life: keep ranking up in this world!\n\nHowever, that plan is halted when Iruma's club is temporarily dismissed, and he is forced to be part of the student council, known for its strictness toward rowdy students. Its cold-hearted president is Amelie Azazel, Iruma's friend. Although Iruma is not used to following their rigid schedule and many rules, he still wants to prove himself and help Amelie alongside all of the other members of the council. \n\nBut trouble arises when Amelie's personality completely changes due to strange circumstances, putting the student council's reputation in jeopardy. Will Iruma be able to save them and avoid having the whole school turn into pure chaos?\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "spring",
          "year": 2021,
          "broadcast": {
            "day": "Saturdays",
            "time": "17:35",
            "timezone": "Asia/Tokyo",
            "string": "Saturdays at 17:35 (JST)"
          },
          "producers": [
            {
              "mal_id": 111,
              "type": "anime",
              "name": "NHK",
              "url": "https://myanimelist.net/anime/producer/111/NHK"
            },
            {
              "mal_id": 1797,
              "type": "anime",
              "name": "NHK Enterprises",
              "url": "https://myanimelist.net/anime/producer/1797/NHK_Enterprises"
            }
          ],
          "licensors": [
            {
              "mal_id": 1468,
              "type": "anime",
              "name": "Crunchyroll",
              "url": "https://myanimelist.net/anime/producer/1468/Crunchyroll"
            }
          ],
          "studios": [
            {
              "mal_id": 1258,
              "type": "anime",
              "name": "Bandai Namco Pictures",
              "url": "https://myanimelist.net/anime/producer/1258/Bandai_Namco_Pictures"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": [
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 38297,
          "url": "https://myanimelist.net/anime/38297/Maou-sama_Retry",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1754/113897.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1754/113897t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1754/113897l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1754/113897.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1754/113897t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1754/113897l.webp"
            }
          },
          "trailer": {
            "youtube_id": "dfm4V4eHPRk",
            "url": "https://www.youtube.com/watch?v=dfm4V4eHPRk",
            "embed_url": "https://www.youtube.com/embed/dfm4V4eHPRk?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/dfm4V4eHPRk/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/dfm4V4eHPRk/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/dfm4V4eHPRk/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/dfm4V4eHPRk/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/dfm4V4eHPRk/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Maou-sama, Retry!"
            },
            {
              "type": "Japanese",
              "title": "魔王様、リトライ！"
            },
            {
              "type": "English",
              "title": "Demon Lord, Retry!"
            },
            {
              "type": "German",
              "title": "Demon Lord, Retry!"
            }
          ],
          "title": "Maou-sama, Retry!",
          "title_english": "Demon Lord, Retry!",
          "title_japanese": "魔王様、リトライ！",
          "title_synonyms": [],
          "type": "TV",
          "source": "Light novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2019-07-04T00:00:00+00:00",
            "to": "2019-09-19T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 4,
                "month": 7,
                "year": 2019
              },
              "to": {
                "day": 19,
                "month": 9,
                "year": 2019
              }
            },
            "string": "Jul 4, 2019 to Sep 19, 2019"
          },
          "duration": "23 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 6.55,
          "scored_by": 141825,
          "rank": 6820,
          "popularity": 962,
          "members": 270706,
          "favorites": 672,
          "synopsis": "Akira Oono is an ordinary working adult who manages the MMORPG Infinity Game. Fifteen years after creating the game, Oono decides to shut the servers down once and for all. However, as the clock strikes midnight, he somehow finds himself in the body of middle-aged Hakuto Kunai, Infinity Game's Demon Lord!\n\nSoon after his mysterious transportation, he witnesses the demon Greole chasing after a little girl named Aku. Although he effortlessly dispatches the creature, Hakuto is still concerned; after all, he does not remember creating the girl or the demon! Doubting whether he truly is in the world of his creation, Hakuto decides to investigate. Bringing Aku along as his guide and companion, Hakuto sets out on a journey to find out exactly who or what summoned him to this fantasy world—all while leaving chaos and destruction in his wake.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "summer",
          "year": 2019,
          "broadcast": {
            "day": "Thursdays",
            "time": "00:00",
            "timezone": "Asia/Tokyo",
            "string": "Thursdays at 00:00 (JST)"
          },
          "producers": [],
          "licensors": [
            {
              "mal_id": 102,
              "type": "anime",
              "name": "Funimation",
              "url": "https://myanimelist.net/anime/producer/102/Funimation"
            }
          ],
          "studios": [
            {
              "mal_id": 1794,
              "type": "anime",
              "name": "EKACHI EPILKA",
              "url": "https://myanimelist.net/anime/producer/1794/EKACHI_EPILKA"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 2,
              "type": "anime",
              "name": "Adventure",
              "url": "https://myanimelist.net/anime/genre/2/Adventure"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 62,
              "type": "anime",
              "name": "Isekai",
              "url": "https://myanimelist.net/anime/genre/62/Isekai"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 40397,
          "url": "https://myanimelist.net/anime/40397/Maoujou_de_Oyasumi",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1448/108514.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1448/108514t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1448/108514l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1448/108514.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1448/108514t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1448/108514l.webp"
            }
          },
          "trailer": {
            "youtube_id": "k1zuZHvl9ic",
            "url": "https://www.youtube.com/watch?v=k1zuZHvl9ic",
            "embed_url": "https://www.youtube.com/embed/k1zuZHvl9ic?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/k1zuZHvl9ic/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/k1zuZHvl9ic/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/k1zuZHvl9ic/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/k1zuZHvl9ic/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/k1zuZHvl9ic/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Maoujou de Oyasumi"
            },
            {
              "type": "Synonym",
              "title": "Sleeping in Devil's Castle"
            },
            {
              "type": "Japanese",
              "title": "魔王城でおやすみ"
            },
            {
              "type": "English",
              "title": "Sleepy Princess in the Demon Castle"
            },
            {
              "type": "German",
              "title": "Sleepy Princess in the Demon Castle"
            },
            {
              "type": "French",
              "title": "Sleepy Princess in the Demon Castle"
            }
          ],
          "title": "Maoujou de Oyasumi",
          "title_english": "Sleepy Princess in the Demon Castle",
          "title_japanese": "魔王城でおやすみ",
          "title_synonyms": [
            "Sleeping in Devil's Castle"
          ],
          "type": "TV",
          "source": "Manga",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2020-10-06T00:00:00+00:00",
            "to": "2020-12-22T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 6,
                "month": 10,
                "year": 2020
              },
              "to": {
                "day": 22,
                "month": 12,
                "year": 2020
              }
            },
            "string": "Oct 6, 2020 to Dec 22, 2020"
          },
          "duration": "23 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.96,
          "scored_by": 106595,
          "rank": 716,
          "popularity": 1130,
          "members": 233397,
          "favorites": 2465,
          "synopsis": "The Demon Lord Tasogare's castle is a dark and frightening place, filled to the brim with various monsters. Any soul unfortunate enough to be imprisoned here is sure to be terrified by the horrors within. However, the human princess Aurora Suya Rhys \"Syalis\" Kaymin is a different case. Rather indifferent to her situation, Syalis worries about one thing and one thing only—sleep. Ever since the demon lord kidnapped her from her kingdom, she has not had a single good night's rest.\n\nTo alleviate her dozen dozing issues, the princess makes do with what she can find in the castle. Whether it be the fur of fluffy demonic teddy bears or the silky, blanket-like bodies of ghost shrouds, everything is but a means to ensure a peaceful slumber. With so many potential materials to craft items that can help her sleep at her disposal, nothing will stop the sleepy princess—not even death.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "fall",
          "year": 2020,
          "broadcast": {
            "day": "Tuesdays",
            "time": "02:00",
            "timezone": "Asia/Tokyo",
            "string": "Tuesdays at 02:00 (JST)"
          },
          "producers": [
            {
              "mal_id": 104,
              "type": "anime",
              "name": "Lantis",
              "url": "https://myanimelist.net/anime/producer/104/Lantis"
            },
            {
              "mal_id": 1590,
              "type": "anime",
              "name": "FuRyu",
              "url": "https://myanimelist.net/anime/producer/1590/FuRyu"
            }
          ],
          "licensors": [
            {
              "mal_id": 102,
              "type": "anime",
              "name": "Funimation",
              "url": "https://myanimelist.net/anime/producer/102/Funimation"
            }
          ],
          "studios": [
            {
              "mal_id": 95,
              "type": "anime",
              "name": "Doga Kobo",
              "url": "https://myanimelist.net/anime/producer/95/Doga_Kobo"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 20,
              "type": "anime",
              "name": "Parody",
              "url": "https://myanimelist.net/anime/genre/20/Parody"
            }
          ],
          "demographics": [
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 39324,
          "url": "https://myanimelist.net/anime/39324/Uchi_no_Ko_no_Tame_naraba_Ore_wa_Moshikashitara_Maou_mo_Taoseru_kamo_Shirenai",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1568/101203.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1568/101203t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1568/101203l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1568/101203.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1568/101203t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1568/101203l.webp"
            }
          },
          "trailer": {
            "youtube_id": "aJT6_qQBYs8",
            "url": "https://www.youtube.com/watch?v=aJT6_qQBYs8",
            "embed_url": "https://www.youtube.com/embed/aJT6_qQBYs8?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/aJT6_qQBYs8/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/aJT6_qQBYs8/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/aJT6_qQBYs8/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/aJT6_qQBYs8/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/aJT6_qQBYs8/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Uchi no Ko no Tame naraba, Ore wa Moshikashitara Maou mo Taoseru kamo Shirenai."
            },
            {
              "type": "Synonym",
              "title": "Uchi no Musume no Tame naraba"
            },
            {
              "type": "Synonym",
              "title": "Ore wa Moshikashitara Maou mo Taoseru kamo Shirenai."
            },
            {
              "type": "Synonym",
              "title": "UchiMusume"
            },
            {
              "type": "Japanese",
              "title": "うちの娘の為ならば、俺はもしかしたら魔王も倒せるかもしれない。"
            },
            {
              "type": "English",
              "title": "If It's for My Daughter, I'd Even Defeat a Demon Lord"
            },
            {
              "type": "German",
              "title": "If It'sFor My Daughter, I'd Even Defeat A Demon Lord"
            },
            {
              "type": "Spanish",
              "title": "If it's for My Daughter, I'd Even Defeat a Demon Lord"
            },
            {
              "type": "French",
              "title": "If it's for My Daughter, I'd Even Defeat a Demon Lord"
            }
          ],
          "title": "Uchi no Ko no Tame naraba, Ore wa Moshikashitara Maou mo Taoseru kamo Shirenai.",
          "title_english": "If It's for My Daughter, I'd Even Defeat a Demon Lord",
          "title_japanese": "うちの娘の為ならば、俺はもしかしたら魔王も倒せるかもしれない。",
          "title_synonyms": [
            "Uchi no Musume no Tame naraba",
            "Ore wa Moshikashitara Maou mo Taoseru kamo Shirenai.",
            "UchiMusume"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2019-07-04T00:00:00+00:00",
            "to": "2019-09-19T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 4,
                "month": 7,
                "year": 2019
              },
              "to": {
                "day": 19,
                "month": 9,
                "year": 2019
              }
            },
            "string": "Jul 4, 2019 to Sep 19, 2019"
          },
          "duration": "23 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.08,
          "scored_by": 111508,
          "rank": 4070,
          "popularity": 1139,
          "members": 231045,
          "favorites": 778,
          "synopsis": "Eighteen-year-old Dale Reki is a skilled, kind, and respected traveler, acknowledged as one of the leading adventurers in the city of Kreuz. One day while on the hunt for magical beasts, he comes across a sweet devil girl named Latina. She is alone, dressed in rags, and bears the devils' symbol of a criminal: a broken horn. Concerned for her wellbeing, Dale decides to ensure Latina's safety by bringing her to his home, eventually leading to him adopting her.\n\nLatina is sweet, innocent and compassionate, charming Dale beyond his expectations. He begins to enjoy the life of parenthood— experiencing the trials that come with raising a child and coping with the heartache he feels whenever his busy lifestyle as an adventurer parts him from her.\n\nAlthough work and life as a new parent become reassuring constants for Dale, the mysteries surrounding the girl remain. Why was Latina alone in the forest, and why does she harbor the symbol of a criminal? At the same time, Latina also begins to learn about the world and herself as she adjusts to her new life with Dale.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "summer",
          "year": 2019,
          "broadcast": {
            "day": "Thursdays",
            "time": "23:30",
            "timezone": "Asia/Tokyo",
            "string": "Thursdays at 23:30 (JST)"
          },
          "producers": [
            {
              "mal_id": 79,
              "type": "anime",
              "name": "Genco",
              "url": "https://myanimelist.net/anime/producer/79/Genco"
            },
            {
              "mal_id": 517,
              "type": "anime",
              "name": "Asmik Ace",
              "url": "https://myanimelist.net/anime/producer/517/Asmik_Ace"
            },
            {
              "mal_id": 547,
              "type": "anime",
              "name": "Hobby Japan",
              "url": "https://myanimelist.net/anime/producer/547/Hobby_Japan"
            },
            {
              "mal_id": 1081,
              "type": "anime",
              "name": "ZERO-A",
              "url": "https://myanimelist.net/anime/producer/1081/ZERO-A"
            },
            {
              "mal_id": 1416,
              "type": "anime",
              "name": "BS11",
              "url": "https://myanimelist.net/anime/producer/1416/BS11"
            },
            {
              "mal_id": 1786,
              "type": "anime",
              "name": "Muse Communication",
              "url": "https://myanimelist.net/anime/producer/1786/Muse_Communication"
            }
          ],
          "licensors": [],
          "studios": [
            {
              "mal_id": 1978,
              "type": "anime",
              "name": "Maho Film",
              "url": "https://myanimelist.net/anime/producer/1978/Maho_Film"
            }
          ],
          "genres": [
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            },
            {
              "mal_id": 36,
              "type": "anime",
              "name": "Slice of Life",
              "url": "https://myanimelist.net/anime/genre/36/Slice_of_Life"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 53,
              "type": "anime",
              "name": "Childcare",
              "url": "https://myanimelist.net/anime/genre/53/Childcare"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 49784,
          "url": "https://myanimelist.net/anime/49784/Mairimashita_Iruma-kun_3rd_Season",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1688/128720.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1688/128720t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1688/128720l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1688/128720.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1688/128720t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1688/128720l.webp"
            }
          },
          "trailer": {
            "youtube_id": "v0M9JojWdFA",
            "url": "https://www.youtube.com/watch?v=v0M9JojWdFA",
            "embed_url": "https://www.youtube.com/embed/v0M9JojWdFA?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/v0M9JojWdFA/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/v0M9JojWdFA/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/v0M9JojWdFA/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/v0M9JojWdFA/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/v0M9JojWdFA/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Mairimashita! Iruma-kun 3rd Season"
            },
            {
              "type": "Synonym",
              "title": "Welcome to Demon School! Iruma-kun 3rd Season"
            },
            {
              "type": "Japanese",
              "title": "魔入りました！入間くん"
            },
            {
              "type": "English",
              "title": "Welcome to Demon School! Iruma-kun Season 3"
            }
          ],
          "title": "Mairimashita! Iruma-kun 3rd Season",
          "title_english": "Welcome to Demon School! Iruma-kun Season 3",
          "title_japanese": "魔入りました！入間くん",
          "title_synonyms": [
            "Welcome to Demon School! Iruma-kun 3rd Season"
          ],
          "type": "TV",
          "source": "Manga",
          "episodes": 21,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2022-10-08T00:00:00+00:00",
            "to": "2023-03-04T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 8,
                "month": 10,
                "year": 2022
              },
              "to": {
                "day": 4,
                "month": 3,
                "year": 2023
              }
            },
            "string": "Oct 8, 2022 to Mar 4, 2023"
          },
          "duration": "24 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.82,
          "scored_by": 105419,
          "rank": 1011,
          "popularity": 1151,
          "members": 228073,
          "favorites": 1306,
          "synopsis": "Following their heroic efforts at Walter Park, the students of the misfit class return to Babyls Demon School after their summer vacation. What awaits them is not only adoration and admiration but also the shocking revelation that, in order to stay in the luxurious Royal One classroom, the entire class must be promoted to Dalet rank before entering the second year.\n\nAs the Harvest and Music Festivals are right around the corner, there seem to be ample opportunities to rank up. Doing so will not be simple, however, as no class thus far has managed to accomplish such a feat. Hoping to give the misfit class a chance to achieve the improbable, the school appoints special tutors to aid in confronting the challenges that lie ahead.\n\nWith his sights set beyond Dalet, Iruma Suzuki decides to take strides toward the goal of ranking up, starting with gaining acknowledgement from his special tutor: the short-tempered and selfish Bachiko Barbatos.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "fall",
          "year": 2022,
          "broadcast": {
            "day": "Saturdays",
            "time": "18:25",
            "timezone": "Asia/Tokyo",
            "string": "Saturdays at 18:25 (JST)"
          },
          "producers": [
            {
              "mal_id": 111,
              "type": "anime",
              "name": "NHK",
              "url": "https://myanimelist.net/anime/producer/111/NHK"
            },
            {
              "mal_id": 1797,
              "type": "anime",
              "name": "NHK Enterprises",
              "url": "https://myanimelist.net/anime/producer/1797/NHK_Enterprises"
            }
          ],
          "licensors": [
            {
              "mal_id": 1468,
              "type": "anime",
              "name": "Crunchyroll",
              "url": "https://myanimelist.net/anime/producer/1468/Crunchyroll"
            }
          ],
          "studios": [
            {
              "mal_id": 1258,
              "type": "anime",
              "name": "Bandai Namco Pictures",
              "url": "https://myanimelist.net/anime/producer/1258/Bandai_Namco_Pictures"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": [
            {
              "mal_id": 27,
              "type": "anime",
              "name": "Shounen",
              "url": "https://myanimelist.net/anime/genre/27/Shounen"
            }
          ]
        },
        {
          "mal_id": 48418,
          "url": "https://myanimelist.net/anime/48418/Maou_Gakuin_no_Futekigousha_II__Shijou_Saikyou_no_Maou_no_Shiso_Tensei_shite_Shison-tachi_no_Gakkou_e_Kayou_Part_2",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1399/141651.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1399/141651t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1399/141651l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1399/141651.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1399/141651t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1399/141651l.webp"
            }
          },
          "trailer": {
            "youtube_id": "NvD4Qg2DgJc",
            "url": "https://www.youtube.com/watch?v=NvD4Qg2DgJc",
            "embed_url": "https://www.youtube.com/embed/NvD4Qg2DgJc?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/NvD4Qg2DgJc/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/NvD4Qg2DgJc/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/NvD4Qg2DgJc/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/NvD4Qg2DgJc/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/NvD4Qg2DgJc/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Maou Gakuin no Futekigousha II: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou Part 2"
            },
            {
              "type": "Synonym",
              "title": "Maou Gakuin no Futekigousha 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "The Misfit of Demon King Academy 2nd Season"
            },
            {
              "type": "Japanese",
              "title": "魔王学院の不適合者 II ～史上最強の魔王の始祖、転生して子孫たちの学校へ通う～ 第2クール"
            },
            {
              "type": "English",
              "title": "The Misfit of Demon King Academy II Part 2"
            }
          ],
          "title": "Maou Gakuin no Futekigousha II: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou Part 2",
          "title_english": "The Misfit of Demon King Academy II Part 2",
          "title_japanese": "魔王学院の不適合者 II ～史上最強の魔王の始祖、転生して子孫たちの学校へ通う～ 第2クール",
          "title_synonyms": [
            "Maou Gakuin no Futekigousha 2nd Season",
            "The Misfit of Demon King Academy 2nd Season"
          ],
          "type": "TV",
          "source": "Light novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2024-04-12T00:00:00+00:00",
            "to": "2024-07-25T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 12,
                "month": 4,
                "year": 2024
              },
              "to": {
                "day": 25,
                "month": 7,
                "year": 2024
              }
            },
            "string": "Apr 12, 2024 to Jul 25, 2024"
          },
          "duration": "23 min per ep",
          "rating": "R - 17+ (violence & profanity)",
          "score": 6.44,
          "scored_by": 43186,
          "rank": 7539,
          "popularity": 1391,
          "members": 184833,
          "favorites": 825,
          "synopsis": "Part two of Maou Gakuin no Futekigousha: Shijou Saikyou no Maou no Shiso, Tensei shite Shison-tachi no Gakkou e Kayou II.",
          "background": "",
          "season": "spring",
          "year": 2024,
          "broadcast": {
            "day": "Fridays",
            "time": "22:00",
            "timezone": "Asia/Tokyo",
            "string": "Fridays at 22:00 (JST)"
          },
          "producers": [
            {
              "mal_id": 17,
              "type": "anime",
              "name": "Aniplex",
              "url": "https://myanimelist.net/anime/producer/17/Aniplex"
            },
            {
              "mal_id": 76,
              "type": "anime",
              "name": "Yomiuri Telecasting",
              "url": "https://myanimelist.net/anime/producer/76/Yomiuri_Telecasting"
            },
            {
              "mal_id": 166,
              "type": "anime",
              "name": "Movic",
              "url": "https://myanimelist.net/anime/producer/166/Movic"
            },
            {
              "mal_id": 238,
              "type": "anime",
              "name": "AT-X",
              "url": "https://myanimelist.net/anime/producer/238/AT-X"
            },
            {
              "mal_id": 1211,
              "type": "anime",
              "name": "Tokyo MX",
              "url": "https://myanimelist.net/anime/producer/1211/Tokyo_MX"
            },
            {
              "mal_id": 1334,
              "type": "anime",
              "name": "Docomo Anime Store",
              "url": "https://myanimelist.net/anime/producer/1334/Docomo_Anime_Store"
            },
            {
              "mal_id": 1337,
              "type": "anime",
              "name": "Medicos Entertainment",
              "url": "https://myanimelist.net/anime/producer/1337/Medicos_Entertainment"
            },
            {
              "mal_id": 1416,
              "type": "anime",
              "name": "BS11",
              "url": "https://myanimelist.net/anime/producer/1416/BS11"
            },
            {
              "mal_id": 1554,
              "type": "anime",
              "name": "Contents Seed",
              "url": "https://myanimelist.net/anime/producer/1554/Contents_Seed"
            },
            {
              "mal_id": 1696,
              "type": "anime",
              "name": "Kadokawa",
              "url": "https://myanimelist.net/anime/producer/1696/Kadokawa"
            },
            {
              "mal_id": 2232,
              "type": "anime",
              "name": "ADK Marketing Solutions",
              "url": "https://myanimelist.net/anime/producer/2232/ADK_Marketing_Solutions"
            },
            {
              "mal_id": 2840,
              "type": "anime",
              "name": "qooop",
              "url": "https://myanimelist.net/anime/producer/2840/qooop"
            }
          ],
          "licensors": [
            {
              "mal_id": 493,
              "type": "anime",
              "name": "Aniplex of America",
              "url": "https://myanimelist.net/anime/producer/493/Aniplex_of_America"
            }
          ],
          "studios": [
            {
              "mal_id": 300,
              "type": "anime",
              "name": "SILVER LINK.",
              "url": "https://myanimelist.net/anime/producer/300/SILVER_LINK"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 10,
              "type": "anime",
              "name": "Fantasy",
              "url": "https://myanimelist.net/anime/genre/10/Fantasy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 72,
              "type": "anime",
              "name": "Reincarnation",
              "url": "https://myanimelist.net/anime/genre/72/Reincarnation"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 39071,
          "url": "https://myanimelist.net/anime/39071/Machikado_Mazoku",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1633/111518.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1633/111518t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1633/111518l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1633/111518.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1633/111518t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1633/111518l.webp"
            }
          },
          "trailer": {
            "youtube_id": "ESNhhG3QQBQ",
            "url": "https://www.youtube.com/watch?v=ESNhhG3QQBQ",
            "embed_url": "https://www.youtube.com/embed/ESNhhG3QQBQ?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/ESNhhG3QQBQ/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/ESNhhG3QQBQ/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/ESNhhG3QQBQ/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/ESNhhG3QQBQ/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/ESNhhG3QQBQ/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Machikado Mazoku"
            },
            {
              "type": "Synonym",
              "title": "Street Corner Demon"
            },
            {
              "type": "Japanese",
              "title": "まちカドまぞく"
            },
            {
              "type": "English",
              "title": "The Demon Girl Next Door"
            }
          ],
          "title": "Machikado Mazoku",
          "title_english": "The Demon Girl Next Door",
          "title_japanese": "まちカドまぞく",
          "title_synonyms": [
            "Street Corner Demon"
          ],
          "type": "TV",
          "source": "4-koma manga",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2019-07-12T00:00:00+00:00",
            "to": "2019-09-27T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 12,
                "month": 7,
                "year": 2019
              },
              "to": {
                "day": 27,
                "month": 9,
                "year": 2019
              }
            },
            "string": "Jul 12, 2019 to Sep 27, 2019"
          },
          "duration": "24 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.63,
          "scored_by": 66480,
          "rank": 1483,
          "popularity": 1469,
          "members": 174537,
          "favorites": 1233,
          "synopsis": "After a strange dream of a mysterious ancestor, high school student Yuuko Yoshida wakes to see that she has grown demonic horns and a tail. Dazed and confused, her mother reveals to her a dark family secret: her family is descended from a Dark Clan that was banished to live powerless and destitute by their mortal enemies, the magical girls of the Light Clan. The only way to lift their ancestry's curse is for Yuuko to find a magical girl, murder her, and splatter her blood all over her ancestor's Demon God statue.\n\nFortunately for \"Shadow Mistress Yuuko,\" a magical girl saves her from being run over by an oncoming truck. Unfortunately, Momo Chiyoda happens to be Yuuko's classmate at Sakuragaoka High and is much stronger than her in both strength and endurance. Taking pity on her wimpy assailant, the magical girl agrees to train Yuuko and help her unlock her dormant powers. Now, Yuuko must rise up and defeat her generous frenemy to save her family from the terrible grip of poverty.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "summer",
          "year": 2019,
          "broadcast": {
            "day": "Fridays",
            "time": "01:28",
            "timezone": "Asia/Tokyo",
            "string": "Fridays at 01:28 (JST)"
          },
          "producers": [
            {
              "mal_id": 144,
              "type": "anime",
              "name": "Pony Canyon",
              "url": "https://myanimelist.net/anime/producer/144/Pony_Canyon"
            },
            {
              "mal_id": 145,
              "type": "anime",
              "name": "TBS",
              "url": "https://myanimelist.net/anime/producer/145/TBS"
            },
            {
              "mal_id": 797,
              "type": "anime",
              "name": "Houbunsha",
              "url": "https://myanimelist.net/anime/producer/797/Houbunsha"
            },
            {
              "mal_id": 1337,
              "type": "anime",
              "name": "Medicos Entertainment",
              "url": "https://myanimelist.net/anime/producer/1337/Medicos_Entertainment"
            },
            {
              "mal_id": 1581,
              "type": "anime",
              "name": "RAY",
              "url": "https://myanimelist.net/anime/producer/1581/RAY"
            }
          ],
          "licensors": [
            {
              "mal_id": 376,
              "type": "anime",
              "name": "Sentai Filmworks",
              "url": "https://myanimelist.net/anime/producer/376/Sentai_Filmworks"
            }
          ],
          "studios": [
            {
              "mal_id": 7,
              "type": "anime",
              "name": "J.C.Staff",
              "url": "https://myanimelist.net/anime/producer/7/JCStaff"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 52,
              "type": "anime",
              "name": "CGDCT",
              "url": "https://myanimelist.net/anime/genre/52/CGDCT"
            },
            {
              "mal_id": 66,
              "type": "anime",
              "name": "Mahou Shoujo",
              "url": "https://myanimelist.net/anime/genre/66/Mahou_Shoujo"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 6895,
          "url": "https://myanimelist.net/anime/6895/Hakuouki",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/3/71800.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/3/71800t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/3/71800l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/3/71800.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/3/71800t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/3/71800l.webp"
            }
          },
          "trailer": {
            "youtube_id": null,
            "url": null,
            "embed_url": null,
            "images": {
              "image_url": null,
              "small_image_url": null,
              "medium_image_url": null,
              "large_image_url": null,
              "maximum_image_url": null
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Hakuouki"
            },
            {
              "type": "Synonym",
              "title": "Hakuoki,Hakuouki: Shinsengumi Kitan"
            },
            {
              "type": "Japanese",
              "title": "薄桜鬼"
            },
            {
              "type": "English",
              "title": "Hakuoki ~Demon of the Fleeting Blossom~"
            },
            {
              "type": "Spanish",
              "title": "Hakuoki: Demon of the Fleeting Blossom"
            }
          ],
          "title": "Hakuouki",
          "title_english": "Hakuoki ~Demon of the Fleeting Blossom~",
          "title_japanese": "薄桜鬼",
          "title_synonyms": [
            "Hakuoki,Hakuouki: Shinsengumi Kitan"
          ],
          "type": "TV",
          "source": "Visual novel",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2010-04-04T00:00:00+00:00",
            "to": "2010-06-20T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 4,
                "month": 4,
                "year": 2010
              },
              "to": {
                "day": 20,
                "month": 6,
                "year": 2010
              }
            },
            "string": "Apr 4, 2010 to Jun 20, 2010"
          },
          "duration": "23 min per ep",
          "rating": "R - 17+ (violence & profanity)",
          "score": 7.35,
          "scored_by": 71324,
          "rank": 2603,
          "popularity": 1471,
          "members": 173564,
          "favorites": 1916,
          "synopsis": "In 1864 Japan, a young woman named Chizuru Yukimura is searching for her missing father, Koudou, a doctor by trade whose work often takes him far from home. But with no word from him in months, Chizuru disguises herself as a man and heads to Kyoto in search of him. Attracting the attention of ronin, she tries to hide and ends up witnessing a horrifying sight: the ronin being brutally murdered by crazed white-haired men. In a startling turn of events, members of the Shinsengumi arrive to dispatch the creatures. But Chizuru's safety doesn't last long, as this group of men tie her up and take her back to their headquarters, unsure of whether to let her live or silence her permanently.\n\nHowever, once she reveals the name of her father, the Shinsengumi decide to keep her safe, as they too have been searching for him. But Koudou is more connected to the Shinsengumi than they let on, and soon Chizuru finds herself embroiled in a conflict between the Shinsengumi and their enemies, as well as political tension in Kyoto.\n\n[Written by MAL Rewrite]",
          "background": "",
          "season": "spring",
          "year": 2010,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": "Unknown"
          },
          "producers": [],
          "licensors": [
            {
              "mal_id": 376,
              "type": "anime",
              "name": "Sentai Filmworks",
              "url": "https://myanimelist.net/anime/producer/376/Sentai_Filmworks"
            }
          ],
          "studios": [
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Studio Deen",
              "url": "https://myanimelist.net/anime/producer/37/Studio_Deen"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 8,
              "type": "anime",
              "name": "Drama",
              "url": "https://myanimelist.net/anime/genre/8/Drama"
            },
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Supernatural",
              "url": "https://myanimelist.net/anime/genre/37/Supernatural"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 13,
              "type": "anime",
              "name": "Historical",
              "url": "https://myanimelist.net/anime/genre/13/Historical"
            },
            {
              "mal_id": 21,
              "type": "anime",
              "name": "Samurai",
              "url": "https://myanimelist.net/anime/genre/21/Samurai"
            }
          ],
          "demographics": [
            {
              "mal_id": 43,
              "type": "anime",
              "name": "Josei",
              "url": "https://myanimelist.net/anime/genre/43/Josei"
            }
          ]
        },
        {
          "mal_id": 42745,
          "url": "https://myanimelist.net/anime/42745/Machikado_Mazoku__2-choume",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1036/121135.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1036/121135t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1036/121135l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/1036/121135.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/1036/121135t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/1036/121135l.webp"
            }
          },
          "trailer": {
            "youtube_id": "kgBxGlnG7no",
            "url": "https://www.youtube.com/watch?v=kgBxGlnG7no",
            "embed_url": "https://www.youtube.com/embed/kgBxGlnG7no?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/kgBxGlnG7no/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/kgBxGlnG7no/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/kgBxGlnG7no/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/kgBxGlnG7no/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/kgBxGlnG7no/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Machikado Mazoku: 2-choume"
            },
            {
              "type": "Synonym",
              "title": "Machikado Mazoku 2nd Season"
            },
            {
              "type": "Synonym",
              "title": "The Demon Girl Next Door 2nd Season"
            },
            {
              "type": "Japanese",
              "title": "まちカドまぞく 2丁目"
            },
            {
              "type": "English",
              "title": "The Demon Girl Next Door 2"
            }
          ],
          "title": "Machikado Mazoku: 2-choume",
          "title_english": "The Demon Girl Next Door 2",
          "title_japanese": "まちカドまぞく 2丁目",
          "title_synonyms": [
            "Machikado Mazoku 2nd Season",
            "The Demon Girl Next Door 2nd Season"
          ],
          "type": "TV",
          "source": "4-koma manga",
          "episodes": 12,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2022-04-08T00:00:00+00:00",
            "to": "2022-07-01T00:00:00+00:00",
            "prop": {
              "from": {
                "day": 8,
                "month": 4,
                "year": 2022
              },
              "to": {
                "day": 1,
                "month": 7,
                "year": 2022
              }
            },
            "string": "Apr 8, 2022 to Jul 1, 2022"
          },
          "duration": "24 min per ep",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.85,
          "scored_by": 26741,
          "rank": 945,
          "popularity": 2718,
          "members": 73613,
          "favorites": 342,
          "synopsis": "Second season of Machikado Mazoku.",
          "background": "",
          "season": "spring",
          "year": 2022,
          "broadcast": {
            "day": "Fridays",
            "time": "01:28",
            "timezone": "Asia/Tokyo",
            "string": "Fridays at 01:28 (JST)"
          },
          "producers": [
            {
              "mal_id": 144,
              "type": "anime",
              "name": "Pony Canyon",
              "url": "https://myanimelist.net/anime/producer/144/Pony_Canyon"
            },
            {
              "mal_id": 797,
              "type": "anime",
              "name": "Houbunsha",
              "url": "https://myanimelist.net/anime/producer/797/Houbunsha"
            },
            {
              "mal_id": 1337,
              "type": "anime",
              "name": "Medicos Entertainment",
              "url": "https://myanimelist.net/anime/producer/1337/Medicos_Entertainment"
            },
            {
              "mal_id": 1416,
              "type": "anime",
              "name": "BS11",
              "url": "https://myanimelist.net/anime/producer/1416/BS11"
            },
            {
              "mal_id": 1581,
              "type": "anime",
              "name": "RAY",
              "url": "https://myanimelist.net/anime/producer/1581/RAY"
            },
            {
              "mal_id": 1585,
              "type": "anime",
              "name": "Nichion",
              "url": "https://myanimelist.net/anime/producer/1585/Nichion"
            }
          ],
          "licensors": [
            {
              "mal_id": 376,
              "type": "anime",
              "name": "Sentai Filmworks",
              "url": "https://myanimelist.net/anime/producer/376/Sentai_Filmworks"
            }
          ],
          "studios": [
            {
              "mal_id": 7,
              "type": "anime",
              "name": "J.C.Staff",
              "url": "https://myanimelist.net/anime/producer/7/JCStaff"
            }
          ],
          "genres": [
            {
              "mal_id": 4,
              "type": "anime",
              "name": "Comedy",
              "url": "https://myanimelist.net/anime/genre/4/Comedy"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 52,
              "type": "anime",
              "name": "CGDCT",
              "url": "https://myanimelist.net/anime/genre/52/CGDCT"
            },
            {
              "mal_id": 66,
              "type": "anime",
              "name": "Mahou Shoujo",
              "url": "https://myanimelist.net/anime/genre/66/Mahou_Shoujo"
            },
            {
              "mal_id": 23,
              "type": "anime",
              "name": "School",
              "url": "https://myanimelist.net/anime/genre/23/School"
            }
          ],
          "demographics": []
        },
        {
          "mal_id": 13117,
          "url": "https://myanimelist.net/anime/13117/Hakuouki_Movie_1__Kyoto_Ranbu",
          "images": {
            "jpg": {
              "image_url": "https://cdn.myanimelist.net/images/anime/9/49399.jpg",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/9/49399t.jpg",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/9/49399l.jpg"
            },
            "webp": {
              "image_url": "https://cdn.myanimelist.net/images/anime/9/49399.webp",
              "small_image_url": "https://cdn.myanimelist.net/images/anime/9/49399t.webp",
              "large_image_url": "https://cdn.myanimelist.net/images/anime/9/49399l.webp"
            }
          },
          "trailer": {
            "youtube_id": "GAaJSagI-mw",
            "url": "https://www.youtube.com/watch?v=GAaJSagI-mw",
            "embed_url": "https://www.youtube.com/embed/GAaJSagI-mw?enablejsapi=1&wmode=opaque&autoplay=1",
            "images": {
              "image_url": "https://img.youtube.com/vi/GAaJSagI-mw/default.jpg",
              "small_image_url": "https://img.youtube.com/vi/GAaJSagI-mw/sddefault.jpg",
              "medium_image_url": "https://img.youtube.com/vi/GAaJSagI-mw/mqdefault.jpg",
              "large_image_url": "https://img.youtube.com/vi/GAaJSagI-mw/hqdefault.jpg",
              "maximum_image_url": "https://img.youtube.com/vi/GAaJSagI-mw/maxresdefault.jpg"
            }
          },
          "approved": true,
          "titles": [
            {
              "type": "Default",
              "title": "Hakuouki Movie 1: Kyoto Ranbu"
            },
            {
              "type": "Synonym",
              "title": "Hakuoki Movie 1"
            },
            {
              "type": "Synonym",
              "title": "Hakuouki Shinsengumi Kitan Movie 1"
            },
            {
              "type": "Synonym",
              "title": "Hakuoki: Wild Dance of Kyoto"
            },
            {
              "type": "Japanese",
              "title": "劇場版 薄桜鬼 第一章 京都乱舞"
            },
            {
              "type": "English",
              "title": "Hakuoki ~Demon of the Fleeting Blossom~ Wild Dance of Kyoto"
            },
            {
              "type": "German",
              "title": "Hakuoki - Demon of the Fleeting Blossom FIlm 1: Wild Dance of Kyoto"
            },
            {
              "type": "French",
              "title": "Hakuoki - Film 1 : Danse Sanglante à Kyoto"
            }
          ],
          "title": "Hakuouki Movie 1: Kyoto Ranbu",
          "title_english": "Hakuoki ~Demon of the Fleeting Blossom~ Wild Dance of Kyoto",
          "title_japanese": "劇場版 薄桜鬼 第一章 京都乱舞",
          "title_synonyms": [
            "Hakuoki Movie 1",
            "Hakuouki Shinsengumi Kitan Movie 1",
            "Hakuoki: Wild Dance of Kyoto"
          ],
          "type": "Movie",
          "source": "Visual novel",
          "episodes": 1,
          "status": "Finished Airing",
          "airing": false,
          "aired": {
            "from": "2013-08-24T00:00:00+00:00",
            "to": null,
            "prop": {
              "from": {
                "day": 24,
                "month": 8,
                "year": 2013
              },
              "to": {
                "day": null,
                "month": null,
                "year": null
              }
            },
            "string": "Aug 24, 2013"
          },
          "duration": "1 hr 35 min",
          "rating": "PG-13 - Teens 13 or older",
          "score": 7.59,
          "scored_by": 9936,
          "rank": 1626,
          "popularity": 4324,
          "members": 30528,
          "favorites": 83,
          "synopsis": "Disguised as a boy, young Chizuru Yukimura leaves her quiet home and heads to Kyoto in search of her missing father—a medical doctor by the name of Koudou. She soon learns that the volatile capital city is a dangerous place to be in as she is ambushed by a pair of ronin while in the streets. Much to her horror, the ronin are slain right in front of her eyes by white-haired, red-eyed samurai, only to be quickly disposed of by three men from the Shinsengumi—a special police force who serve the shogun.\n\nAfter the incident, Chizuru finds herself being taken into custody by the Shinsengumi for further questioning. Upon learning that her missing father is also the same man they are searching for, the chief allows her to stay in their care while they look for his whereabouts. While working as an assistant for second-in-command Toshizou Hijikata, Chizuru slowly discovers just how connected the troubling political environment of Kyoto and the demonic-looking white-haired samurai are to her.\n\n[Written by MAL Rewrite]",
          "background": "Hakuouki Movie 1: Kyoto Ranbu was released on Blu-ray and DVD by Sentai Filmworks as Hakuoki: Demon of the Fleeting Blossom: Wild Dance of Kyoto on June 28, 2016.",
          "season": null,
          "year": null,
          "broadcast": {
            "day": null,
            "time": null,
            "timezone": null,
            "string": null
          },
          "producers": [
            {
              "mal_id": 31,
              "type": "anime",
              "name": "Geneon Universal Entertainment",
              "url": "https://myanimelist.net/anime/producer/31/Geneon_Universal_Entertainment"
            },
            {
              "mal_id": 61,
              "type": "anime",
              "name": "Frontier Works",
              "url": "https://myanimelist.net/anime/producer/61/Frontier_Works"
            },
            {
              "mal_id": 460,
              "type": "anime",
              "name": "KlockWorx",
              "url": "https://myanimelist.net/anime/producer/460/KlockWorx"
            }
          ],
          "licensors": [
            {
              "mal_id": 376,
              "type": "anime",
              "name": "Sentai Filmworks",
              "url": "https://myanimelist.net/anime/producer/376/Sentai_Filmworks"
            }
          ],
          "studios": [
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Studio Deen",
              "url": "https://myanimelist.net/anime/producer/37/Studio_Deen"
            }
          ],
          "genres": [
            {
              "mal_id": 1,
              "type": "anime",
              "name": "Action",
              "url": "https://myanimelist.net/anime/genre/1/Action"
            },
            {
              "mal_id": 8,
              "type": "anime",
              "name": "Drama",
              "url": "https://myanimelist.net/anime/genre/8/Drama"
            },
            {
              "mal_id": 37,
              "type": "anime",
              "name": "Supernatural",
              "url": "https://myanimelist.net/anime/genre/37/Supernatural"
            }
          ],
          "explicit_genres": [],
          "themes": [
            {
              "mal_id": 13,
              "type": "anime",
              "name": "Historical",
              "url": "https://myanimelist.net/anime/genre/13/Historical"
            },
            {
              "mal_id": 21,
              "type": "anime",
              "name": "Samurai",
              "url": "https://myanimelist.net/anime/genre/21/Samurai"
            }
          ],
          "demographics": [
            {
              "mal_id": 43,
              "type": "anime",
              "name": "Josei",
              "url": "https://myanimelist.net/anime/genre/43/Josei"
            }
          ]
        }
      ]
    }
""".trimIndent()

}