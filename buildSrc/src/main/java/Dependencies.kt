object Versions {
    const val gradle_tools            = "3.4.0-alpha05"  // https://mvnrepository.com/artifact/com.android.tools.build/gradle

    // Android Arch                   
    const val arch_navigation         = "1.0.0-alpha07"  // https://mvnrepository.com/artifact/android.arch.navigation

    // Android Support                
    const val support                 = "28.0.0"         // https://mvnrepository.com/artifact/com.android.support
    const val support_constraint      = "2.0.0-alpha2"   // https://mvnrepository.com/artifact/com.android.support.constraint
    const val support_multidex        = "1.0.3"          // https://mvnrepository.com/artifact/com.android.support/multidex
    const val support_test            = "1.0.2"          // https://mvnrepository.com/artifact/com.android.support.test
    const val support_test_espresso   = "3.0.2-alpha1"   // https://mvnrepository.com/artifact/com.android.support.test.espresso

    // AndroidX                       
    const val x_appcompat             = "1.0.0"          // https://mvnrepository.com/artifact/androidx.appcompat
    const val x_constraintlayout      = "2.0.0-alpha2"   // https://mvnrepository.com/artifact/androidx.constraintlayout
    const val x_core_ktx              = "1.0.1"          // https://mvnrepository.com/artifact/androidx.core/core-ktx
    const val x_legacy                = "1.0.0"          // https://mvnrepository.com/artifact/androidx.legacy
    const val x_lifecycle             = "2.0.0"          // https://mvnrepository.com/artifact/androidx.lifecycle
    const val x_percentlayout         = "1.0.0"          // https://mvnrepository.com/artifact/androidx.percentlayout
    const val x_preference            = "1.1.0-alpha01"  // https://mvnrepository.com/artifact/androidx.preference
    const val x_recyclerview          = "1.0.0"          // https://mvnrepository.com/artifact/androidx.recyclerview
    const val x_room                  = "2.1.0-alpha02"  // https://mvnrepository.com/artifact/androidx.room
    const val x_test                  = "1.1.0"          // https://mvnrepository.com/artifact/androidx.test
    const val x_test_espresso         = "3.1.0"          // https://mvnrepository.com/artifact/androidx.test.espresso

    // Google                         
    const val gms_play_services       = "12.0.0"         // https://mvnrepository.com/artifact/com.google.android.gms/play-services
    const val gms_auth                = "16.0.1"         // https://mvnrepository.com/artifact/com.google.android.gms/play-services-auth
    const val gms_drive               = "16.0.0"         // https://mvnrepository.com/artifact/com.google.android.gms/play-services-drive
    const val gms_wearable            = "16.0.1"         // https://mvnrepository.com/artifact/com.google.android.gms/play-services-wearable
    const val gson                    = "2.8.5"          // https://mvnrepository.com/artifact/com.google.code.gson
    const val material                = "1.1.0-alpha01"  // https://mvnrepository.com/artifact/com.google.android.material
    const val wearable                = "2.4.0"          // https://mvnrepository.com/artifact/com.google.android.support/wearable

    // Jetbrains                      
    const val jetbrains_annotations   = "16.0.3"         // https://mvnrepository.com/artifact/org.jetbrains/annotations-java5
    const val kotlin                  = "1.3.10"         // https://mvnrepository.com/artifact/org.jetbrains.kotlin

    // Microsoft                      
    const val azure_mobile            = "2.0.3"          // https://mvnrepository.com/artifact/com.microsoft.azure/azure-mobile-services-android-sdk
    const val azure_storage           = "2.0.0"          // https://mvnrepository.com/artifact/com.microsoft.azure.android/azure-storage-android

    // SquareUp
    const val squareup_okhttp         = "3.12.0"         // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    const val squareup_retrofit       = "2.5.0"          // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit

    // Others                         
    const val crashlytics             = "2.9.6"          // https://mvnrepository.com/artifact/com.crashlytics.sdk.android/crashlytics
    const val crashlytics_answers     = "1.4.4"          // https://mvnrepository.com/artifact/com.crashlytics.sdk.android/answers
    const val dataformat_csv          = "2.9.7"          // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-csv
    const val hamcrest                = "1.3"            // https://mvnrepository.com/artifact/org.hamcrest/hamcrest-library
    const val junit                   = "4.12"           // https://mvnrepository.com/artifact/junit/junit
    const val junit_jupiter_api       = "5.3.2"          // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    const val pebble_kit              = "4.0.1"          // https://mvnrepository.com/artifact/com.getpebble/pebblekit
}

object Libs {
    // Check Gradle version on: https://services.gradle.org/distributions/

    // Gradle build tools
    const val gradle_build_tools      = "com.android.tools.build:gradle:${Versions.gradle_tools}"
    const val junit_runner            = "android.support.test.runner.AndroidJUnitRunner"

    // Android
    const val navigation_fragment     = "android.arch.navigation:navigation-fragment:${Versions.arch_navigation}"
    const val navigation_ui           = "android.arch.navigation:navigation-ui:${Versions.arch_navigation}"

    const val constraint_layout       = "com.android.support.constraint:constraint-layout:${Versions.support_constraint}"
    const val support_appcompat_v7    = "com.android.support:appcompat-v7:${Versions.support}"
    const val support_annotations     = "com.android.support:support-annotations:${Versions.support}"
    const val support_cardview_v7     = "com.android.support.cardview-v7:${Versions.support}"
    const val support_compat          = "com.android.support:support-compat:${Versions.support}"
    const val support_design          = "com.android.support:design:${Versions.support}"
    const val support_espresso        = "com.android.support.test.espresso:espresso-core:${Versions.support_test_espresso}"
    const val support_multidex        = "com.android.support:multidex:${Versions.support_multidex}"
    const val support_palette_v7      = "com.android.support:palette-v7:${Versions.support}"
    const val support_preference_v7   = "com.android.support:preference-v7:${Versions.support}"
    const val support_preference_v14  = "com.android.support:preference-v14:${Versions.support}"
    const val support_recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.support}"
    const val support_test_rules      = "com.android.support.test:rules:${Versions.support_test}"
    const val support_test_runner     = "com.android.support.test:runner:${Versions.support_test}"
    const val support_v4              = "com.android.support:support-v4:${Versions.support}"
    const val support_wear            = "com.android.support:wear:${Versions.support}"

    // AndroidX
    const val x_appcompat             = "androidx.appcompat:appcompat:${Versions.x_appcompat}"
    const val x_cardview              = "androidx.cardview:cardview:${Versions.x_appcompat}"
    const val x_core_ktx              = "androidx.core:core-ktx:${Versions.x_core_ktx}"
    const val x_constraint_layout     = "androidx.constraintlayout:constraintlayout:${Versions.x_constraintlayout}"
    const val x_espresso              = "androidx.test.support_espresso:support_espresso-core:${Versions.x_test_espresso}"
    const val x_legacy_support_v4     = "androidx.legacy:legacy-support-v4:${Versions.x_legacy}"
    const val x_lifecycle_extensions  = "androidx.lifecycle:lifecycle-extensions:${Versions.x_lifecycle}"
    const val x_preference            = "androidx.preference:preference:${Versions.x_preference}"
    const val x_percent_layout        = "androidx.percentlayout:percentlayout:${Versions.x_percentlayout}"
    const val x_recyclerview          = "androidx.recyclerview:recyclerview:${Versions.x_recyclerview}"
    const val x_room_runtime          = "androidx.room:room-runtime:${Versions.x_room}"
    const val x_test_rules            = "androidx.test:rules:${Versions.x_test}"
    const val x_test_runner           = "androidx.test:runner:${Versions.x_test}"

    // Google
    const val play_services           = "com.google.android.gms:play-services:${Versions.gms_play_services}"
    const val play_services_auth      = "com.google.android.gms:play-services-auth:${Versions.gms_auth}"
    const val play_services_drive     = "com.google.android.gms:play-services-drive:${Versions.gms_drive}"
    const val play_services_wearable  = "com.google.android.gms:play-services-wearable:${Versions.gms_wearable}"
    const val material                = "com.google.android.material:material:${Versions.material}"
    const val support_wearable        = "com.google.android.support:wearable:${Versions.wearable}"
    const val wearable                = "com.google.android.wearable:wearable:${Versions.wearable}"
    const val gson                    = "com.google.code.gson:gson:${Versions.gson}"

    // Jetbrains                      
    const val jetbrains_annotations   = "org.jetbrains:annotations-java5:${Versions.jetbrains_annotations}"
    const val kotlin_stdlib           = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlin_plugin           = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    // Microsoft
    const val azure_mobile            = "com.microsoft.azure:azure-mobile-services-android-sdk:${Versions.azure_mobile}"
    const val azure_storage           = "com.microsoft.azure.android:azure-storage-android:${Versions.azure_storage}"

    // SquareUp
    const val squareup_okhttp3        = "com.squareup.okhttp3:okhttp:${Versions.squareup_okhttp}"
    const val squareup_retrofit       = "com.squareup.okhttp3:retrofit2:retrofit:${Versions.squareup_retrofit}"
    const val squareup_retrofit_gson  = "com.squareup.okhttp3:retrofit2:converter-gson:${Versions.squareup_retrofit}"
    
    // Others
    const val crahslytics             = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}@aar"
    const val crahslytics_answers     = "com.crashlytics.sdk.android:answers:${Versions.crashlytics_answers}@aar"
    const val faster_xml              = "com.fasterxml.jackson.dataformat:jackson-dataformat-csv:${Versions.dataformat_csv}"
    const val hamcrest                = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
    const val junit                   = "junit:junit:${Versions.junit}"
    const val junit_jupiter_api       = "org.junit.jupiter:junit-jupiter-api:${Versions.junit_jupiter_api}"
    const val pebble_kit              = "com.getpebble:pebblekit:${Versions.pebble_kit}"
}

// Check Gradle version on: https://services.gradle.org/distributions/
// distributionUrl=https\://services.gradle.org/distributions/gradle-5.0-all.zip
