package com.example.weatherapp.presentation.ui

import ads_mobile_sdk.h4
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.weatherapp.presentation.viewmodel.WeatherViewModel


@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    // Obserwujemy stan z ViewModela
    val weather by viewModel.weatherState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (weather != null) {
            Text(text = "Miasto: ${weather!!.cityName}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Temperatura: ${weather!!.temperature}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Stan: ${weather!!.condition}")
        } else {
            Text(text = "Ładowanie danych...")
            Button(onClick = { viewModel.loadWeather("Warszawa") }) {
                Text("Pobierz pogodę")
            }
        }
    }
}