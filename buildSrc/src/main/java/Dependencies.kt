object Versions {
        const val gradle_tools                = "7.1.0-alpha02"   // https://mvnrepository.com/artifact/com.android.tools.build/gradle
//    const val gradle_tools                = "7.0.0-beta03"    // https://mvnrepository.com/artifact/com.android.tools.build/gradle

    // AndroidX / Jetpack
    // Check versions at: https://maven.google.com/web/index.html
    const val arch_navigation             = "1.0.0"
    const val material                    = "1.3.0"
    const val support                     = "28.0.0"
    const val wearable_support            = "2.8.1"
    const val x_annotation                = "1.2.0"
    const val x_appcompat                 = "1.3.0" // 1.4.0-alpha01
    const val x_camera_core               = "1.0.0" // 1.1.0-alpha04
    const val x_camera                    = "1.0.0-alpha25"
    const val x_constraint_layout         = "2.0.4" // 2.1.0-beta02
    const val x_coordinator_layout        = "1.1.0"
    const val x_core_ktx                  = "1.5.0" // 1.6.0-beta02
    const val x_junit                     = "1.1.2"
    const val x_legacy                    = "1.0.0"
    const val x_lifecycle                 = "2.3.1"
    const val x_lifecycle_extensions      = "2.2.0"
    const val x_multidex                  = "2.0.1"
    const val x_navigation                = "2.3.5"
    const val x_percent_layout            = "1.0.0"
    const val x_preference                = "1.1.1"
    const val x_recyclerview              = "1.2.1" // 1.2.0-rc01
    const val x_room                      = "2.3.0" // 2.4.0-alpha01
    const val x_test                      = "1.3.0"
    const val x_test_espresso             = "3.3.0"
    const val x_wear                      = "1.1.0" // 1.2.0-alpha08
    const val x_work_runtime              = "2.5.0"           // https://mvnrepository.com/artifact/androidx.work/work-runtime-ktx

    // Google
    const val firebase_bom                = "28.1.0"          // https://mvnrepository.com/artifact/com.google.firebase/firebase-bom
    const val firebase_crashlytics_plugin = "2.7.0"           // https://mvnrepository.com/artifact/com.google.firebase/firebase-crashlytics-gradle?repo=google
    const val firebase_perf_plugin        = "1.4.0"           // https://mvnrepository.com/artifact/com.google.firebase/perf-plugin
    const val gms_auth                    = "19.0.0"          // https://mvnrepository.com/artifact/com.google.android.gms/play-services-auth
    const val gms_drive                   = "17.0.0"          // https://mvnrepository.com/artifact/com.google.android.gms/play-services-drive
    const val gms_google_services         = "4.3.8"           // https://mvnrepository.com/artifact/com.google.gms/google-services?repo=google
    const val gms_location                = "18.0.0"          // https://mvnrepository.com/artifact/com.google.android.gms/play-services-location
    const val gms_play_services           = "12.0.1"          // https://mvnrepository.com/artifact/com.google.android.gms/play-services
    const val gms_wearable                = "17.1.0"          // https://mvnrepository.com/artifact/com.google.android.gms/play-services-wearable
    const val gson                        = "2.8.7"           // https://mvnrepository.com/artifact/com.google.code.gson/gson

    // Jetbrains
    const val kotlin                      = "1.5.10"          // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib
    const val kotlinx_coroutines          = "1.5.0"           // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core

    // Microsoft
    const val azure_mobile                = "2.0.3"           // https://mvnrepository.com/artifact/com.microsoft.azure/azure-mobile-services-android-sdk
    const val azure_storage               = "2.0.0"           // https://mvnrepository.com/artifact/com.microsoft.azure.android/azure-storage-android

    // SquareUp
    const val squareup_okhttp             = "4.9.1"           // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    const val squareup_moshi              = "1.12.0"          // https://mvnrepository.com/artifact/com.squareup.moshi/moshi
    const val squareup_retrofit           = "2.9.0"           // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit

    // Others                         
    const val crashlytics                 = "2.9.6"           // https://mvnrepository.com/artifact/com.crashlytics.sdk.android/crashlytics
    const val crashlytics_answers         = "1.4.4"           // https://mvnrepository.com/artifact/com.crashlytics.sdk.android/answers
    const val dataformat_csv              = "2.9.7"           // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-csv
    const val hamcrest                    = "1.3"             // https://mvnrepository.com/artifact/org.hamcrest/hamcrest-library
    const val junit                       = "4.12"            // https://mvnrepository.com/artifact/junit/junit
    const val junit_jupiter_api           = "5.3.2"           // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    const val pebble_kit                  = "4.0.1"           // https://mvnrepository.com/artifact/com.getpebble/pebblekit
}

object Libs {
    const val gradle_build_tools          = "com.android.tools.build:gradle:${Versions.gradle_tools}"
    const val x_junit_runner              = "androidx.test.runner.AndroidJUnitRunner"

    // AndroidX / Jetpack
    // Check versions at: https://maven.google.com/web/index.html
    const val x_annotation                = "androidx.annotation:annotation:${Versions.x_annotation}"
    const val x_appcompat                 = "androidx.appcompat:appcompat:${Versions.x_appcompat}"
    const val x_camera_core               = "androidx.camera:camera-core:${Versions.x_camera_core}"
    const val x_camera_camera2            = "androidx.camera:camera-camera2:${Versions.x_camera_core}"
    const val x_camera_view               = "androidx.camera:camera-view:${Versions.x_camera}"
    const val x_camera_extensions         = "androidx.camera:camera-extensions:${Versions.x_camera}"
    const val x_constraint_layout         = "androidx.constraintlayout:constraintlayout:${Versions.x_constraint_layout}"
    const val x_coordinator_layout        = "androidx.coordinatorlayout:coordinatorlayout:${Versions.x_coordinator_layout}"
    const val x_core_ktx                  = "androidx.core:core-ktx:${Versions.x_core_ktx}"
    const val x_espresso                  = "androidx.test.espresso:espresso-core:${Versions.x_test_espresso}"
    const val x_junit                     = "androidx.test.ext:junit:${Versions.x_junit}"
    const val x_legacy_support_v4         = "androidx.legacy:legacy-support-v4:${Versions.x_legacy}"
    const val x_lifecycle_common          = "androidx.lifecycle:lifecycle-common-java8:${Versions.x_lifecycle}"
    const val x_lifecycle_compiler        = "androidx.lifecycle:lifecycle-compiler:${Versions.x_lifecycle}"
    const val x_lifecycle_extensions      = "androidx.lifecycle:lifecycle-extensions:${Versions.x_lifecycle_extensions}"
    const val x_lifecycle_runtime         = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.x_lifecycle}"
    const val x_lifecycle_viewmodel       = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.x_lifecycle}"
    const val x_multidex                  = "androidx.multidex:multidex:${Versions.x_multidex}"
    const val x_navigation_fragment       = "androidx.navigation:navigation-fragment-ktx:${Versions.x_navigation}"
    const val x_navigation_ui             = "androidx.navigation:navigation-ui-ktx:${Versions.x_navigation}"
    const val x_percent_layout            = "androidx.percentlayout:percentlayout:${Versions.x_percent_layout}"
    const val x_preference                = "androidx.preference:preference-ktx:${Versions.x_preference}"
    const val x_recyclerview              = "androidx.recyclerview:recyclerview:${Versions.x_recyclerview}"
    const val x_room_runtime              = "androidx.room:room-runtime:${Versions.x_room}"
    const val x_test_rules                = "androidx.test:rules:${Versions.x_test}"
    const val x_test_runner               = "androidx.test:runner:${Versions.x_test}"
    const val x_wear                      = "androidx.wear:wear:${Versions.x_wear}"
    const val x_work_runtime              = "androidx.work:work-runtime-ktx:${Versions.x_work_runtime}"

    // Google
    const val firebase_bom                = "com.google.firebase:firebase-bom:${Versions.firebase_bom}"
    const val firebase_analytics_ktx      = "com.google.firebase:firebase-analytics-ktx"
    const val firebase_auth               = "com.google.firebase:firebase-auth"
    const val firebase_crashlytics_ktx    = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebase_crashlytics_plugin = "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebase_crashlytics_plugin}"
    const val firebase_firestore_ktx      = "com.google.firebase:firebase-firestore-ktx"
    const val firebase_messaging_ktx      = "com.google.firebase:firebase-messaging-ktx"
    const val firebase_perf_ktx           = "com.google.firebase:firebase-perf-ktx"
    const val firebase_perf_plugin        = "com.google.firebase:perf-plugin:${Versions.firebase_perf_plugin}"
    const val firebase_storage            = "com.google.firebase:firebase-storage"

    const val gms_google_services         = "com.google.gms:google-services:${Versions.gms_google_services}"
    const val gms_play_services           = "com.google.android.gms:play-services:${Versions.gms_play_services}"
    const val gms_services_auth           = "com.google.android.gms:play-services-auth:${Versions.gms_auth}"
    const val gms_services_drive          = "com.google.android.gms:play-services-drive:${Versions.gms_drive}"
    const val gms_services_wearable       = "com.google.android.gms:play-services-wearable:${Versions.gms_wearable}"
    const val gms_services_location       = "com.google.android.gms:play-services:${Versions.gms_location}"
    const val gson                        = "com.google.code.gson:gson:${Versions.gson}"
    const val material                    = "com.google.android.material:material:${Versions.material}"
    const val support_palette_v7          = "com.android.support:palette-v7:${Versions.support}"
    const val wearable_support            = "com.google.android.support:wearable:${Versions.wearable_support}"

    // Jetbrains
    const val kotlinx_coroutines          = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines}"
    const val kotlin_plugin               = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_stdlib               = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlin_test                 = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
    const val kotlin_test_junit           = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"

    // Microsoft
    const val azure_mobile                = "com.microsoft.azure:azure-mobile-services-android-sdk:${Versions.azure_mobile}"
    const val azure_storage               = "com.microsoft.azure.android:azure-storage-android:${Versions.azure_storage}"

    // SquareUp
    const val squareup_moshi              = "com.squareup.moshi:moshi:${Versions.squareup_moshi}"
    const val squareup_okhttp3            = "com.squareup.okhttp3:okhttp:${Versions.squareup_okhttp}"
    const val squareup_retrofit           = "com.squareup.retrofit2:retrofit:${Versions.squareup_retrofit}"
    const val squareup_retrofit_gson      = "com.squareup.retrofit2:converter-gson:${Versions.squareup_retrofit}"
    const val squareup_retrofit_moshi     = "com.squareup.retrofit2:converter-moshi:${Versions.squareup_retrofit}"
    
    // Others
    const val crahslytics                 = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"
    const val crahslytics_answers         = "com.crashlytics.sdk.android:answers:${Versions.crashlytics_answers}@aar"
    const val faster_xml                  = "com.fasterxml.jackson.dataformat:jackson-dataformat-csv:${Versions.dataformat_csv}"
    const val hamcrest                    = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
    const val junit                       = "junit:junit:${Versions.junit}"
    const val junit_jupiter_api           = "org.junit.jupiter:junit-jupiter-api:${Versions.junit_jupiter_api}"
    const val pebble_kit                  = "com.getpebble:pebblekit:${Versions.pebble_kit}"
}