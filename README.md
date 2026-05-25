# WeatherApp - Clean Architecture & MVVM Demo

Projekt demonstracyjny przygotowany na potrzeby wykładu, prezentujący zastosowanie nowoczesnych wzorców projektowych w systemie Android.

## Zastosowana architektura
Aplikacja została zbudowana w oparciu o zasady **Clean Architecture** z podziałem na trzy główne warstwy:
- **Domain**: Logika biznesowa, Use Cases i modele domenowe.
- **Data**: Implementacja repozytoriów, mapowanie danych (Mappers) oraz obsługa źródeł danych (Fake API).
- **Presentation**: Warstwa UI zbudowana w **Jetpack Compose** oraz **ViewModel** (wzorzec MVVM).

## Technologie i biblioteki
- **Kotlin** + **Coroutines** (asynchroniczność)
- **StateFlow** (reaktywne zarządzanie stanem)
- **Jetpack Compose** (nowoczesny interfejs użytkownika)
- **ViewModel** (przechowywanie stanu UI)

## Jak uruchomić projekt?
1. Sklonuj repozytorium.
2. Otwórz projekt w najnowszej wersji **Android Studio**.
3. Zsynchronizuj pliki Gradle.
4. Uruchom aplikację na emulatorze lub fizycznym urządzeniu (min. API 26).
