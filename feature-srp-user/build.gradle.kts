plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.aradsheybak.feature_srp_user"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation("androidx.compose.ui:ui:${libs.versions.compose.get()}")
    implementation("androidx.compose.material:material:${libs.versions.compose.get()}")
    implementation("androidx.compose.ui:ui-tooling-preview:${libs.versions.compose.get()}")
    debugImplementation("androidx.compose.ui:ui-tooling:${libs.versions.compose.get()}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${libs.versions.lifecycle.get()}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:${libs.versions.lifecycle.get()}")

    implementation(libs.hilt.android)
    ksp("com.google.dagger:hilt-compiler:${libs.versions.hilt.get()}")

    // Retrofit + Moshi
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi.converter)

    // OkHttp (Core + Logging)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // Moshi core
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    ksp(libs.moshi.kotlin.codegen)

}
