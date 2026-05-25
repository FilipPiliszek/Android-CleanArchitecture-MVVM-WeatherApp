package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.remote.WeatherDto
import com.example.weatherapp.domain.model.Weather

fun WeatherDto.toDomain(): Weather {
    return Weather(
        cityName = this.name,
        temperature = "${this.temp_c}°C",
        condition = this.weather_desc
    )
}
