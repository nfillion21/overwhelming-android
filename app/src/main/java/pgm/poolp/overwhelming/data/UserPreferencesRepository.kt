package pgm.poolp.overwhelming.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import pgm.poolp.overwhelming.data.UserPreferencesRepository.PreferencesKeys.FOOD_OCCURENCES
import java.io.IOException
import javax.inject.Inject

/**
 * Class that handles saving and retrieving user preferences
 */
class UserPreferencesRepository @Inject constructor(private val dataStore: DataStore<Preferences>) {

    private val TAG: String = "UserPreferencesRepo"

    private object PreferencesKeys {
        val FOOD_OCCURENCES = intPreferencesKey("food_occurrences")
    }

    /**
     * Get the user preferences flow.
     */
    val foodOccurrencesFlow: Flow<Int> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences.", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            // No type safety.
            preferences[FOOD_OCCURENCES] ?: 0
        }

    suspend fun decreaseFoodOccurrences() {

        while(true) {
            dataStore.edit { preferences ->
                val occurrences = preferences[FOOD_OCCURENCES] ?: 0
                if (occurrences > 0)
                {
                    preferences[FOOD_OCCURENCES] = occurrences - 1
                }
                delay(500) // Suspends the coroutine for some time
            }
        }
    }

    suspend fun increaseFoodOccurrencesWithTen() {
        dataStore.edit { preferences ->
            val occurrences = preferences[FOOD_OCCURENCES] ?: 0
            preferences[FOOD_OCCURENCES] = occurrences + 10
        }
    }
}
