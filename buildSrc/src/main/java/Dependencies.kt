/**
 * To define dependencies
 */
object Dependencies {

    // Core Android
    val coreAndroidX by lazy {"androidx.core:core-ktx:${Versions.coreAndroidX}"}

    // Compose
    val uiCompose by lazy { "androidx.compose.ui:ui:${Versions.composeVersion}" }
    val materialCompose by lazy { "androidx.compose.material:material:${Versions.composeVersion}" }
    val uiToolingPreviewCompose by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}" }
    val uiTestJUnit4Compose by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}" }
    val uiToolingCompose by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeVersion}" }
    val runtimeLiveData by lazy { "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"}

    val iconsExtended by lazy {"androidx.compose.material:material-icons-extended:${Versions.composeVersion}"}

    val lifecycleRuntime by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleAndroidX}"}
    val lifecycleLivedata by lazy {"androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleAndroidX}"}
    val lifecycleViewModel by lazy {"androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleAndroidX}"}
    val lifecycleViewModelCompose by lazy {"androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleAndroidX}"}

    // Activity Compose
    val activityCompose by lazy {"androidx.activity:activity-compose:${Versions.activityCompose}"}

    // Tests
    val junit by lazy {"junit:junit:${Versions.junit}"}
    val junitAndroidX by lazy {"androidx.test.ext:junit:1.1.3:${Versions.junitAndroidX}"}
    val expressoAndroidX by lazy {"androidx.test.espresso:espresso-core:${Versions.expressoAndroidX}"}

    // Hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }

    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationComposeVersion}"}

    // Room
    val roomRuntine by lazy {"androidx.room:room-runtime:${Versions.roomVersion}"}
    val roomKtx by lazy {"androidx.room:room-ktx:${Versions.roomVersion}"}
    val roomCompiler by lazy {"androidx.room:room-compiler:${Versions.roomVersion}"}

    val accompanistInsets by lazy {"com.google.accompanist:accompanist-insets:${Versions.accompanistVersion}"}

    val coilCompose by lazy {"io.coil-kt:coil-compose:${Versions.coilVersion}"}

    val appCompat by lazy {"androidx.appcompat:appcompat:${Versions.appCompat}"}

    val datastorePreferences by lazy {"androidx.datastore:datastore-preferences:${Versions.datastoreVersion}"}

    val firebasePlatform by lazy {"com.google.firebase:firebase-bom:${Versions.firebaseVersion}"}
    val firebaseAnalytics by lazy {"com.google.firebase:firebase-analytics-ktx"}
    val firebaseDatabase by lazy {"com.google.firebase:firebase-database-ktx"}

    //val firebaseDatabase by lazy {"com.google.firebase:firebase-database:${Versions.firebaseDatabaseVersion}"}
}
