package kg.itc.examplemvvm.data.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.itc.examplemvvm.data.models.DailyForeCastEntity
import kg.itc.examplemvvm.data.models.HourlyForeCastEntity

class RoomCollectionsConverter {

    @TypeConverter
    fun fromHourlyForecastListToJson(list: List<HourlyForeCastEntity>?): String? =
        Gson().toJson(list)

    @TypeConverter
    fun fromJsonToHourlyForecastList(json: String?): List<HourlyForeCastEntity>? =
        Gson().fromJson(json, object : TypeToken<List<HourlyForeCastEntity>>() {}.type)

    @TypeConverter
    fun fromDailyForecastListToJson(list: List<DailyForeCastEntity>?): String? =
        Gson().toJson(list)

    @TypeConverter
    fun fromJsonToDailyForecastList(json: String?): List<DailyForeCastEntity>? =
        Gson().fromJson(json, object : TypeToken<List<DailyForeCastEntity>>() {}.type)
}