package kg.itc.examplemvvm.data.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ForeCastDto(
    val id: Long? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    @PrimaryKey
    var timezone: String,
    var timezone_offset: Long? = null,
    var current: CurrentForeCastDto? = null,
    var hourly: List<HourlyForeCastDto>? = null,
    var dailyDto: List<DailyForeCastDto>? = null
)


data class CurrentForeCastDto(
    @SerializedName("dt")
    var date: Long? = null,
    var sunrise: Long? = null,
    var sunset: Long? = null,
    var temp: Double? = null,
    var feels_like: Double? = null,
    var humidity: Int? = null,
    var weather: List<WeatherDto>? = null
)

data class WeatherDto(
    var id: Long? = null,
    var description: String? = null,
    var icon: String? = null
)

data class HourlyForeCastDto(
    @SerializedName("dt")
    var date: Long? = null,
    var temp: Double? = null,
    var weather: List<WeatherDto>? = null,
    @SerializedName("pop")
    var probability: Double? = null
)

data class DailyForeCastDto(
    @SerializedName("dt")
    var date: Long? = null,
    var temp: TemperatureDto? = null,
    var weather: List<WeatherDto>? = null,
    @SerializedName("pop")
    var probability: Double? = null
)

data class TemperatureDto(
    var min: Double? = null,
    var max: Double? = null
)