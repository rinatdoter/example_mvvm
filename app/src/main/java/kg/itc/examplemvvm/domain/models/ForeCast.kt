package kg.itc.examplemvvm.domain.models

import kg.itc.examplemvvm.extensions.format
import kotlin.math.roundToInt

data class ForeCast(
    val id: Long? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    var timezone: String,
    var current: CurrentForeCast? = null,
    var hourly: List<HourlyForeCast>? = null,
    var daily: List<DailyForeCast>? = null
){

    val temperature: String?
    get() = current?.temp?.roundToInt()?.toString()

    val currentDate: String?
    get() = current?.date?.format()

    val tempMax: String?
    get() = daily?.get(0)?.temp?.max?.roundToInt()?.toString()

    val tempMin: String?
    get()= daily?.get(0)?.temp?.min?.roundToInt()?.toString()

    val feelsLike: String?
    get() = current?.feels_like?.roundToInt()?.toString()

    val weatherDescription: String?
    get() = current?.weather?.get(0)?.description

    val sunrise: String?
    get() = current?.sunrise?.format("hh:mm")

    val sunset: String?
    get() = current?.sunset?.format("hh:mm")

    val humidity: String
    get() =  current?.humidity?.toString() ?: ""

}



data class CurrentForeCast(
    var date: Long? = null,
    var sunrise: Long? = null,
    var sunset: Long? = null,
    var temp: Double? = null,
    var feels_like: Double? = null,
    var humidity: Int? = null,
    var weather: List<Weather>? = null
)

data class Weather(
    var id: Long? = null,
    var description: String? = null,
    var icon: String? = null
)

data class HourlyForeCast(
    var date: Long? = null,
    var temp: Double? = null,
    var weather: List<Weather>? = null,
    var probability: Double? = null
)

data class DailyForeCast(
    var date: Long? = null,
    var temp: Temperature? = null,
    var weather: List<Weather>? = null,
    var probability: Double? = null
)

data class Temperature(
    var min: Double? = null,
    var max: Double? = null
)