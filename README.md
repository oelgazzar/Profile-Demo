# 👤 Profile Demo

A simple Android profile application built with **Kotlin** and the traditional **XML-based Android UI toolkit**. The app demonstrates a multi-screen layout with bottom navigation, a profile page with tabbed content, and reusable UI components.

## ✨ Features

- **Bottom navigation** between Home, Timeline, Profile, and Settings.
- **Profile screen** with a ViewPager2-style tab layout for Timeline and Contents.
- **Interactive tooltips** using Balloon to introduce profile actions and UI elements.
- **Avatar and image loading** with Stream AvatarView and Coil.
- **Custom Data Binding adapters** for displaying rounded images and loading avatar images.
- **Navigation Component** for managing fragment destinations.
- **View Binding and Data Binding** to interact with XML layouts.
- **ViewModel and LiveData** for observable screen state.

## 📸 Screenshots

Add your app screenshots to a `screenshots/` directory, then update the paths below:

<img width="250" alt="profile" src="https://github.com/user-attachments/assets/15111f77-70a7-4a3f-99fc-6021859efdfa" />


## 🛠️ Built With

- **Kotlin** – Application programming language.
- **Android Views and XML** – Layouts and UI components.
- **AndroidX Fragments** – Screen composition.
- **View Binding & Data Binding** – Type-safe view access and binding adapters.
- **Android Navigation Component** – Fragment navigation.
- **ViewModel & LiveData** – Lifecycle-aware UI state.
- **Material Components** – Material Design components, including bottom navigation and tabs.
- **ViewPager2 & TabLayoutMediator** – Tabbed profile content.
- **Stream AvatarView + Coil** – Avatar image handling.
- **Balloon** – In-app tooltips and pop-up callouts.

## 🧭 App Structure

The main activity hosts a Navigation Component `NavHostFragment` and a `BottomNavigationView`.

| Screen | Description |
|---|---|
| Home | Home destination. |
| Timeline | Displays a list of people with their quotes and avatars. |
| Profile | Profile information with Timeline and Contents tabs, plus interactive tooltips. |
| Settings | Settings destination. |

## 🏗️ Project Structure

```text
app/
└── src/main/
    ├── java/com/example/profiledemo/
    │   ├── MainActivity.kt
    │   ├── BindingAdapters.kt
    │   └── ui/
    │       ├── home/
    │       ├── profile/
    │       ├── timeline/
    │       ├── settings/
    │       └── content/
    └── res/
        ├── layout/
        ├── menu/
        ├── navigation/
        ├── drawable/
        └── values/
```

## 🚀 Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/oelgazzar/Profile-Demo.git
   ```

2. Open the project in **Android Studio**.
3. Allow Gradle to sync.
4. Run the `app` configuration on an Android emulator or connected device.

## 📚 Learning Goals

This project is useful for practising:

- Building Android interfaces with XML layouts.
- Organizing an app into fragments.
- Setting up bottom navigation with the Navigation Component.
- Sharing a profile screen between tabbed pages using ViewPager2.
- Observing UI state with ViewModel and LiveData.
- Creating custom Data Binding adapters.
- Adding contextual tooltips with Balloon.

---

*Built with Kotlin and Android.*
