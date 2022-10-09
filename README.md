# Overwhelming
<https://play.google.com/store/apps/details?id=pgm.poolp.overwhelming>

A Jetpack compose app using food icons in Firebase Realtime Database.

Libraries and components used
--------------
* [Realtime Database][0] - Store and sync our icon's number in a cloud.
* [Kotlin flows][1] - Using [callbackflow][2] to listen to Realtime Database and return Flow type.
* [ViewModel][3] - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
* [Material Icons][4] - Using icons-extended library to get food icons.


[0]: https://firebase.google.com/docs/database?hl=en
[1]: https://developer.android.com/kotlin/flow
[2]: https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/callback-flow.html
[3]: https://developer.android.com/topic/libraries/architecture/viewmodel
[4]: https://developer.android.com/reference/kotlin/androidx/compose/material/icons/Icons
