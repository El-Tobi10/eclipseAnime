package ar.edu.uade.c012025.animeapp.data.localdata

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Database(entities = [AnimeEntity::class, MangaEntity::class, CharacterEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animeDao(): IAnimeDao
    abstract fun mangaDao(): IMangaDao
    abstract fun characterDao(): ICharactersDao

    companion object{
        @Volatile
        private var _instance: AppDatabase? = null

        fun createInstance(context: Context): AppDatabase = _instance ?: synchronized(this){
            _instance ?: buildDatabase(context).also { _instance = it }
        }

//        fun getInstance() : AppDatabase {
//            return _instance!!
//        }

        private fun buildDatabase(context: Context): AppDatabase =
             Room.databaseBuilder(context, AppDatabase::class.java, "eclipse_db")
                 .fallbackToDestructiveMigration()
                 .build()

        suspend fun clearDatabase(context: Context) = coroutineScope{
            launch(Dispatchers.IO){
                createInstance(context).clearAllTables()
            }
        }
    }
}