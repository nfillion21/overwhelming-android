package pgm.poolp.overwhelming.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

data class UserPreferences(
    val showVillains: Int
)

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
    val userPreferencesFlow: Flow<UserPreferences> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences.", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            mapUserPreferences(preferences)
        }

    suspend fun decreaseFoodOccurrences() {
        dataStore.edit { preferences ->

            val occurrences = preferences[PreferencesKeys.FOOD_OCCURENCES] ?: 0
            if (occurrences > 0)
            {
                preferences[PreferencesKeys.FOOD_OCCURENCES] = occurrences - 1
            }
        }
    }

    suspend fun increaseFoodOccurrencesWithTen() {
        dataStore.edit { preferences ->

            val occurrences = preferences[PreferencesKeys.FOOD_OCCURENCES] ?: 0
            if (occurrences > 0)
            {
                preferences[PreferencesKeys.FOOD_OCCURENCES] = occurrences + 10
            }
        }
    }

    suspend fun fetchInitialPreferences() =
        mapUserPreferences(dataStore.data.first().toPreferences())

    private fun mapUserPreferences(preferences: Preferences): UserPreferences {
        val foodOccurrences = preferences[PreferencesKeys.FOOD_OCCURENCES] ?: 0
        return UserPreferences(foodOccurrences)
    }
}
