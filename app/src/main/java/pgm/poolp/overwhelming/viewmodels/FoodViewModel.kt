package pgm.poolp.overwhelming.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pgm.poolp.overwhelming.data.UserPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject internal constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

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