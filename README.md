# README

## Fitness Android App

A simple yet effective fitness tracking application for Android devices.

### Features
- 🔥 Track Calories Burned
- 👟 Count Steps Walked
- 💧 Monitor Water Intake
- 📊 Persistent Data Storage
- 🎨 Modern Material Design UI

## Prerequisites

To build and run this app, you need:

- **Android SDK**: API Level 21 or higher
- **Java Development Kit (JDK)**: Version 8 or higher  
- **Gradle**: 8.9 (included)
- **Android Studio** (recommended) or command-line build tools

## Setup & Installation

### Step 1: Install Android SDK

#### Option A: Using Android Studio (Recommended)
- Download and install [Android Studio](https://developer.android.com/studio)
- Android SDK will be installed automatically
- Set `ANDROID_HOME` environment variable to SDK location:
  - Default location: `C:\Users\YourUsername\AppData\Local\Android\Sdk`

#### Option B: Command Line
- Download [Android SDK Command Line Tools](https://developer.android.com/studio)
- Extract and set `ANDROID_HOME` environment variable

### Step 2: Create local.properties File

In the project root directory, create a file named `local.properties` with:

```properties
sdk.dir=C:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk
```

Replace `YourUsername` with your actual Windows username.

### Step 3: Build the APK

#### Option 1: Using Command Line (Windows)

```powershell
# Navigate to project directory
cd "path\to\fitness android app"

# Build debug APK
.\gradlew build

# Build release APK (Recommended for sharing)
.\gradlew assembleRelease
```

#### Option 2: Using Android Studio

1. Open the project folder in Android Studio
2. Click **Build** menu → **Build APK** (or **Build Bundle**)
3. Wait for build to complete
4. Click **Locate** to open the output folder

### APK Output Locations

- **Debug APK**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release APK**: `app/build/outputs/apk/release/app-release.apk`

## Sharing the APK

### Via WhatsApp/Telegram
1. Locate the APK file from the build output
2. Open WhatsApp/Telegram
3. Drag and drop the APK file to share
4. Or use "Share" option after build completion

### Via Email
1. Locate the APK file
2. Right-click → Send to → Mail recipient
3. Attach and share with your contacts

### Via Cloud Storage
- Upload to Google Drive, Dropbox, OneDrive, or similar service
- Share the link with others

## Installation Instructions for Users

Recipients can install the app using these steps:

1. **Download the APK** from shared link or message
2. **Enable Installation from Unknown Sources**:
   - Go to Settings → Security (or About Phone)
   - Toggle "Unknown Sources" ON
3. **Open the APK file** on the device
4. **Click "Install"** button
5. **Grant permissions** as requested
6. **Launch the app** from app drawer

## Troubleshooting

### Build Error: "SDK location not found"
- Create `local.properties` with correct SDK path
- Verify Android SDK is installed: `C:\Users\YourUsername\AppData\Local\Android\Sdk`

### Build Error: "Unrecognized VM option 'MaxPermSize'"
- Ensure you're using JDK 11 or higher
- This has been fixed in gradle.properties

### Gradle Build Taking Too Long
- First build downloads dependencies (this is normal)
- Subsequent builds will be faster
- If it fails, delete `.gradle` folder and retry

## Project Structure

```
fitness-android-app/
├── app/
│   ├── src/main/
│   │   ├── AndroidManifest.xml
│   │   ├── java/com/fitness/app/
│   │   │   └── MainActivity.kt
│   │   └── res/
│   │       ├── drawable/
│   │       ├── layout/
│   │       ├── mipmap/
│   │       └── values/
│   └── build.gradle
├── gradle/                 # Gradle wrapper
├── build.gradle           # Project config
├── settings.gradle        # Module config
└── local.properties       # Local SDK path (create this)
```

## Building Documentation

For more detailed information, refer to:
- [Android Developer Documentation](https://developer.android.com/docs)
- [Gradle Build Guide](https://developer.android.com/build)
- [Kotlin Documentation](https://kotlinlang.org/docs/)

## Requirements
- Android 5.1 (API 21) or higher
- 50MB free storage space

## Author
Created by Abhay

---

**GitHub Repository**: https://github.com/abhay-codes07/fitness-android-app
