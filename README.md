# 🌒 Eclipse - App de Anime y Manga

_Eclipse_ es una aplicación Android desarrollada con Kotlin y Jetpack Compose, pensada para los verdaderos fanáticos del anime y manga. Permite explorar títulos populares, ver detalles, personajes, trailers, openings, y gestionar tus favoritos.

---

## 📱 Funcionalidades principales

- 🔍 **Buscador de Animes y Mangas**
- 🎬 **Reproducción de trailers desde YouTube**
- 📖 **Información detallada de cada anime/manga**
- 👤 **Pantalla de personajes con apariciones**
- ❤️ **Agregar a favoritos (con Firebase)**
- 🔀 **Random Anime / Manga**
- 🌐 **Inicio de sesión con Google**
- 🧭 **Navegación fluida entre pantallas**
- 📦 **Consumo de API Jikan (MyAnimeList)**

---

## 🧰 Tecnologías utilizadas

| Tecnología      | Uso principal                          |
|------------------|----------------------------------------|
| Kotlin + Compose | UI moderna y declarativa               |
| Jetpack ViewModel | Gestión de estado                     |
| Firebase Auth    | Autenticación con Google               |
| Firebase Firestore | Almacenamiento de favoritos          |
| Retrofit         | Consumo de API                         |
| Coil             | Carga de imágenes                      |
| Navigation       | Sistema de rutas                       |
| Room (próximamente) | Base de datos local                 |

---

## 🏗️ Arquitectura

La app está dividida en módulos siguiendo una estructura **MVVM** limpia:

data/
├── models/
├── repository/
└── api/
domain/
ui/
├── screens/
└── components/

📸 Capturas

<img src="https://kksqeezvcyujrkjnkrjo.supabase.co/storage/v1/object/public/logo//index.webp" width="200"/>  <img src="https://kksqeezvcyujrkjnkrjo.supabase.co/storage/v1/object/public/logo//busqueda.webp" width="200"/>
<img src="https://kksqeezvcyujrkjnkrjo.supabase.co/storage/v1/object/public/logo//Anime.webp" width="200"/> <img src="https://kksqeezvcyujrkjnkrjo.supabase.co/storage/v1/object/public/logo//manga.webp" width="200"/>

💬 Créditos
Desarrollado por El-Tobi10 🌌
Diseñado con ❤️ por un fan del anime, para fans del anime.

📄 Licencia
MIT License - podés usar, modificar y compartir libremente.


