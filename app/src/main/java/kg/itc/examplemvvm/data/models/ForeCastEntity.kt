package kg.itc.examplemvvm.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ForeCastEntity(
    @PrimaryKey
    val id: Long = 0,
    var lat: Double? = null,
    var lon: Double? = null,
    var timezone: String,
    var timezone_offset: Long? = null,
    var current: CurrentForeCastEntity? = null,
    var hourly: List<HourlyForeCastEntity>? = null,
    var daily: List<DailyForeCastEntity>? = null
)

data class CurrentForeCastEntity(
    @SerializedName("dt")
    var date: Long? = null,
    var sunrise: Long? = null,
    var sunset: Long? = null,
    var temp: Double? = null,
    var feels_like: Double? = null,
    var humidity: Int? = null,
    var weather: List<WeatherEntity>? = null
)

data class WeatherEntity(
    var id: Long? = null,
    var description: String? = null,
    var icon: String? = null
)

data class HourlyForeCastEntity(
    var date: Long? = null,
    var temp: Double? = null,
    var weather: List<WeatherEntity>? = null,
    var probability: Double? = null
)

data class DailyForeCastEntity(
    var date: Long? = null,
    var temp: TemperatureEntity? = null,
    var weather: List<WeatherEntity>? = null,
    var probability: Double? = null
)

data class TemperatureEntity(
    var min: Double? = null,
    var max: Double? = null
)