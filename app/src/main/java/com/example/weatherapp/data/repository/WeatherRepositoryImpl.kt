package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mapper.toDomain
import com.example.weatherapp.data.remote.WeatherApiService
import com.example.weatherapp.data.remote.WeatherDto
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository

class FakeWeatherApiService : WeatherApiService {
    override suspend fun getWeatherFromApi(city: String): WeatherDto {
        return WeatherDto(name = "Warszawa", temp_c = 21.5, weather_desc = "Słonecznie")
    }
}

class WeatherRepositoryImpl(private val api: FakeWeatherApiService) : WeatherRepository {
    override suspend fun fetchWeather(city: String): Weather {
        val response = api.getWeatherFromApi(city) // Wywolanie np. Retrofit
        return response.toDomain() // Mapowanie na model domenowy
    }
}
