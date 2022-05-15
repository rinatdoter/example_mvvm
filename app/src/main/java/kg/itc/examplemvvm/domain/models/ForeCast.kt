package kg.itc.examplemvvm.domain.models

data class ForeCast(
    val id: Long? = null,
    var lat: Double? = null,
    var lon: Double? = null,
    var timezone: String,
    var current: CurrentForeCast? = null,
    var hourly: List<HourlyForeCast>? = null,
    var dailyDto: List<DailyForeCast>? = null
)


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