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
    private val userPreferencesRepository: UserPreferencesRepository,
    private val overwhelmingRepository: OverwhelmingRepository
) : ViewModel() {

    /*
    init {
        val db = Firebase.database("https://overwhelming-42f25-default-rtdb.europe-west1.firebasedatabase.app/")
        databaseReference = db.getReference("overwhelming")
    }
    */

    fun getOverwhelming() = overwhelmingRepository.getOverwhelming()

    fun decreaseFoodOccurrences() {
        viewModelScope.launch {
            userPreferencesRepository.decreaseFoodOccurrences()
        }
    }

    fun increaseFoodOccurrencesWithTen() {
        viewModelScope.launch {
            userPreferencesRepository.increaseFoodOccurrencesWithTen()
        }
    }

    val foodOccurrences:Flow<Int> = userPreferencesRepository.foodOccurrencesFlow
}