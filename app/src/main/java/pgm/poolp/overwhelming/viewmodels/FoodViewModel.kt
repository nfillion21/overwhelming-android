package pgm.poolp.overwhelming.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import pgm.poolp.overwhelming.data.OverwhelmingRepository
import pgm.poolp.overwhelming.data.UserPreferencesRepository
import javax.inject.Inject

@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class FoodViewModel @Inject internal constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    /*
    init {
        val db = Firebase.database("https://overwhelming-42f25-default-rtdb.europe-west1.firebasedatabase.app/")
        databaseReference = db.getReference("overwhelming")
    }
    */

    val overwhelmingRepository = OverwhelmingRepository()

    fun getOverwhelming() :Flow<Int> {
        return overwhelmingRepository.getOverwhelming()
    }

    fun increaseSharedFoodOccurrencesWithTen() {
        overwhelmingRepository.increaseWithTen()
    }

    fun decreaseSharedFoodOccurrences() {
        viewModelScope.launch {
            overwhelmingRepository.decreaseFood()
        }
    }

    fun increaseFoodOccurrencesWithTen() {
        viewModelScope.launch {
            userPreferencesRepository.increaseFoodOccurrencesWithTen()
        }
    }

    fun decreaseFoodOccurrences() {
        viewModelScope.launch {
            userPreferencesRepository.decreaseFoodOccurrences()
        }
    }

    val foodOccurrences:Flow<Int> = userPreferencesRepository.foodOccurrencesFlow
}