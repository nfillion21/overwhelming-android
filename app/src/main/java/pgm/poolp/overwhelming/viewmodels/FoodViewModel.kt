package pgm.poolp.overwhelming.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pgm.poolp.overwhelming.data.FoodRepository
import pgm.poolp.overwhelming.data.UserPreferencesRepository
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject internal constructor(
    private val foodRepository: FoodRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    fun loadFoods() {
        viewModelScope.launch {
            foodRepository.foods

            //val latestNewsWithAuthors = getLatestNewsWithAuthors()
            //_uiState.value = LatestNewsUiState.Success(latestNewsWithAuthors)
        }
    }

    fun decreaseFoodOccurrences() {
        viewModelScope.launch {
            userPreferencesRepository.decreaseFoodOccurrences()
        }
    }

    fun increaseFoodOccurrencesWithTen() {
        viewModelScope.launch {
            userPreferencesRepository.decreaseFoodOccurrences()
        }
    }
}