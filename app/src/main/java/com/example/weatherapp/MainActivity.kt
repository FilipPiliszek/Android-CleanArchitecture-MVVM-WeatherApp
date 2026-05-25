package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.data.repository.FakeWeatherApiService
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.usecase.GetWeatherUseCase
import com.example.weatherapp.presentation.ui.WeatherScreen
import com.example.weatherapp.presentation.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Tworzymy warstwę danych (przykład z mockiem do tutoriala)
        val apiService = FakeWeatherApiService()
        val repository = WeatherRepositoryImpl(apiService)

        // 2. Tworzymy warstwę domeny (Use Case)
        val getWeatherUseCase = GetWeatherUseCase(repository)

        // 3. Tworzymy ViewModel i przekazujemy mu Use Case
        val viewModel = WeatherViewModel(getWeatherUseCase)

        setContent {
            MaterialTheme {
                WeatherScreen(viewModel)
            }
        }
    }
}


