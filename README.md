# Scrap Clicker - Star Cost Calculator v2

A modern, high-performance Android utility application designed for **Scrap Clicker** players to calculate the precise scrap cost required to upgrade stars. 

This project has been completely rewritten from scratch using **Modern Android Development (MAD)** practices, transitioning from legacy XML to a fully reactive Jetpack Compose UI with robust background architecture.

---

## 🚀 Features

* **Precise Cost Calculation:** Accurately computes the total star cost by factoring in crucial game variables:
  * Current Star Level
  * Target Star Level
  * Scrapyard V2 Multipliers
  * Achievement Boost 2 Level
  * Mastery 17+ Barrels Bonus
* **Performance-Optimized Auto-Save:** Powered by Coroutines Flow with a `500ms` debounce mechanism. Your inputs are saved asynchronously on `Dispatchers.IO` without causing any UI lag.
* **Local Persistence:** Uses Room DB to ensure your latest inputs and configurations are safely stored and restored whenever you reopen the app.
* **Idle-Game Notation Formatter:** Converts massive numerical outputs into a clean, readable alphabetical format (e.g., `1.23a`), matching the native idle-game experience.

---

## 🛠️ Technical Stack & Architecture

This application follows **Clean Architecture** and **MVVM** design patterns, decoupling the codebase into distinct Data, Domain, and Presentation layers.

* **UI Framework:** Jetpack Compose (Declarative & Fluid UI)
* **Asynchronous Programming:** Kotlin Coroutines & Flow
* **Local Database:** Room DB
* **Dependency Injection:** Dagger-Hilt
* **Build System:** Gradle (Kotlin DSL)

---

## 📜 Acknowledgments & Inspiration

This project was inspired by and built upon the core calculation logic of existing web-based community tools. Special thanks to the creators of these repositories:
* [cubruce1103/StarCalc](https://github.com/cubruce1103/StarCalc)
* [jugh3ad/StarCalc](https://github.com/jugh3ad/StarCalc)

---

## 📦 Download & Installation

You can download the compiled, production-ready APK directly from the GitHub Releases section to install and use it on your Android device:

👉 **[Download the Latest Release (v2.0.0)]([https://github.com/YOUR_GITHUB_USERNAME/YOUR_REPO_NAME/releases/latest](https://github.com/alperen-sakin/star_calculator/releases/download/2.0.0/Star.Calculator.v.2.0.0.apk))**

