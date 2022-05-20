package kg.itc.examplemvvm.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.itc.examplemvvm.data.models.ForeCastEntity
import kg.itc.examplemvvm.data.models.UserEntity

@Database(entities = [UserEntity::class, ForeCastEntity::class], version = 2)
@TypeConverters(RoomModelsConverter::class, RoomCollectionsConverter::class)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun userDao(): UserDao
    abstract fun foreCastDao(): ForeCastDao


    companion object {
        const val DB_NAME = "example.db"
    }
}