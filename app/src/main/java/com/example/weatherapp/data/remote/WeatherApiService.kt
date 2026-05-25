package com.example.weatherapp.data.remote

// To jest interfejs, którego używa Retrofit do pobierania danych
interface WeatherApiService {

    // W prawdziwej aplikacji tutaj byłyby adnotacje typu @GET("weather")
    suspend fun getWeatherFromApi(city: String): WeatherDto
}