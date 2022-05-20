package kg.itc.examplemvvm.data.storage

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import kg.itc.examplemvvm.data.models.ForeCastEntity

@Dao
interface ForeCastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(foreCast: ForeCastEntity)

    @Query("select * from ForeCastEntity")
    fun getAll(): LiveData<ForeCastEntity>

    //Все, что ниже, в целях демонстрации. Они не используются на самом деле
    @Update
    fun update(foreCast: ForeCastEntity): Completable

    @Delete
    fun delete(foreCast: ForeCastEntity): Completable

    @Query("select * from ForeCastEntity where id = :id")
    fun getById(id: Long): Single<ForeCastEntity>

    @Query("delete from ForeCastEntity")
    fun deleteAll(): Completable
}