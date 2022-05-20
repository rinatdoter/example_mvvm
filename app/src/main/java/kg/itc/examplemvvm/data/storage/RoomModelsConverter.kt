package kg.itc.examplemvvm.data.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.itc.examplemvvm.data.models.CurrentForeCastEntity

class RoomModelsConverter {

    @TypeConverter
    fun fromCurrentForeCastToJson(forecast: CurrentForeCastEntity?): String? =
        Gson().toJson(forecast)

    @TypeConverter
    fun fromJsonToCurrentForeCast(json: String?): CurrentForeCastEntity? =
        Gson().fromJson(json, object: TypeToken<CurrentForeCastEntity>() {}.type)
}