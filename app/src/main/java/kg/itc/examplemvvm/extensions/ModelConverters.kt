package kg.itc.examplemvvm.extensions

import kg.itc.examplemvvm.data.models.*
import kg.itc.examplemvvm.domain.models.*


fun UserDto.toUserEntity(): UserEntity{
    return UserEntity(
        id,
        name,
        surname
    )
}


fun UserDto.toUser(): User {
    return User(
        id,name,surname
    )
}


fun ForeCastDto.toForeCast(): ForeCast{
    return ForeCast(
        id,
        lat,
        lon,
        timezone,
        current?.toCurrentForeCast(),
        hourly?.map { it.toHourlyForeCast()},
        daily?.map { it.toDailyForeCast() },
    )

}


fun CurrentForeCastDto.toCurrentForeCast(): CurrentForeCast{
    return CurrentForeCast(
        date,sunrise,sunset,temp,feels_like,humidity,weather?.map { it.toWeather() }
    )
}

fun WeatherDto.toWeather(): Weather{
    return Weather(id,description,icon)
}

fun HourlyForeCastDto.toHourlyForeCast(): HourlyForeCast{
    return HourlyForeCast(
        date,
        temp,
        weather?.map { it.toWeather() },
        probability
    )
}

fun DailyForeCastDto.toDailyForeCast(): DailyForeCast{
    return DailyForeCast(
        date,
        temp?.toTemperature(),
        weather?.map { it.toWeather()},
        probability

    )
}

fun TemperatureDto.toTemperature(): Temperature{
    return Temperature(
        min,
        max
    )
}

