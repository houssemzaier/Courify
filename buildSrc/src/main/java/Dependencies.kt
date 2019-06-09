object Versions {
    //global
    val android_studio = "3.4.1"
    val navigation_safe_args_gradle_plugin_version = "1.0.0"

    //navigation
    val navigation_component = "2.0.0"

    //apk
    val basePackageName = "com.bravedroid.hooked"
    val version_code = 1
    val version_name = "1.0"
    val compile_sdk = 28
    val min_sdk = 14
    val target_sdk = 28

    //global build.gradle
    val android_gradle_plugin = "3.3.0"

    //platforms
    val kotlin_version = "1.3.31"
    val java8 = "1.8"

    //androidx
    val support_lib = "$compile_sdk.0.0"
    val constraint_layout = "1.1.3"
    val lifecycle_version = "1.1.1"
    //UI
    val glide = "4.8.0"

    //tools
    val jetbrains_annotations = "16.0.3"
    val gson = "2.8.5"
    val retrofit = "2.5.0"
    val rxjava = "2.1.9"

    //tests
    val junit = "4.12"
    val android_test_runner = "1.2.0"
    val espresso_core = "3.2.0"
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    //log
    val timber = "4.7.1"
}

object Dependencies {
    //build.gradle global
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"

    //platform
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"

    //architecture component
//    val android_arch_lifecycle = "android.arch.lifecycle:extensions:${Versions.lifecycle_version}"
    //val android_arch_lifecycle_viewmodel = "android.arch.lifecycle:viewmodel:${Versions.lifecycle_version}"
    // val android_arch_lifecycle_livedata = "android.arch.lifecycle:livedata:${Versions.lifecycle_version}"
//    val android_arch_lifecycle_runtime = "android.arch.lifecycle:runtime:${Versions.lifecycle_version}"
    val android_arch_lifecycle_common_java8 = "android.arch.lifecycle:common-java8:${Versions.lifecycle_version}"
    val android_arch_lifecycle_reactivestreams = "android.arch.lifecycle:reactivestreams:${Versions.lifecycle_version}"
    val android_arch_lifecycle_core_testing = "android.arch.core:core-testing:${Versions.lifecycle_version}"

    //androidX
    val appcompat = "androidx.appcompat:appcompat:1.0.0"
    val core_ktx = "androidx.core:core-ktx:1.0.0"
    val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val android_arch_lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:2.0.0-rc01"
    val android_arch_lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:2.0.0-rc01"
    val android_arch_lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata:2.0.0-rc01"
    val android_arch_lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel:2.0.0-rc01"

    //UI
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val app_compat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    val design = "com.android.support:design:${Versions.support_lib}"
    val support_v4 = "com.android.support:support-v4:${Versions.support_lib}"
    val recyclerview_v7 = "com.android.support:recyclerview-v7:${Versions.support_lib}"

    //tools
    val jetbrains_annotations = "org.jetbrains:annotations:${Versions.jetbrains_annotations}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    val retrofit_rxjava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"

    //JVM tests
    val junit = "junit:junit:${Versions.junit}"

    //Instrumental tests
    val android_test_runner = "androidx.test:runner:1.0.0"
    val android_test_espresso_core = "androidx.test.espresso:espresso-core:3.1.1"

    val com_android_support_test_runner = "com.android.support.test:runner:${Versions.android_test_runner}"
    val espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso_core}"

    //log
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}
