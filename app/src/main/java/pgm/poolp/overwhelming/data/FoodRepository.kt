package pgm.poolp.overwhelming.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalPizza
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FoodRepository {

    @Immutable // Tell Compose runtime that this object will not change so it can perform optimizations
    data class Food(
        val id: Long,
        val icon: ImageVector
    )

    val foods = listOf(
        Food (
            id = 1,
            icon = Icons.Outlined.LocalPizza),
        Food (
            id = 1,
            icon = Icons.Outlined.LocalPizza)
    )
}
