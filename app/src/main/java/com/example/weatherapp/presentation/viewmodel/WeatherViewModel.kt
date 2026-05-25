package com.example.weatherapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val getWeatherUseCase: GetWeatherUseCase) : ViewModel() {

    private val _weatherState = MutableStateFlow<Weather?>(null)
    val weatherState = _weatherState.asStateFlow()

    fun loadWeather(city: String) {
        viewModelScope.launch {
            try {
                val result = getWeatherUseCase(city)
                _weatherState.value = result
            } catch (e: Exception) {
                // Obsluga bledow
            }
        }
    }
}
