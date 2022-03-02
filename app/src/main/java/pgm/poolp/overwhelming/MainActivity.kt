package pgm.poolp.overwhelming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import pgm.poolp.overwhelming.screens.HomeScreen
import pgm.poolp.overwhelming.ui.theme.OverwhelmingTheme
import pgm.poolp.overwhelming.viewmodels.FoodViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var foodViewModel: FoodViewModel
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            foodViewModel = hiltViewModel()

            OverwhelmingTheme {
                Scaffold(
                    Modifier.clickable { foodViewModel.decreaseSharedFoodOccurrences() },
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    floatingActionButton = {

                        val imageVector: ImageVector = when ((0..8).random()) {
                            0 -> Icons.Rounded.LocalPizza
                            1 -> Icons.Rounded.Cake
                            2 -> Icons.Rounded.LunchDining
                            3 -> Icons.Rounded.Coffee
                            4 -> Icons.Rounded.BakeryDining
                            5 -> Icons.Rounded.Icecream
                            6 -> Icons.Rounded.BreakfastDining
                            7 -> Icons.Rounded.EmojiFoodBeverage
                            8 -> Icons.Rounded.RamenDining
                            else -> {Icons.Rounded.Coffee}
                        }

                        ExtendedFloatingActionButton(
                            text = { Text(text = "Overwhelming food") },
                            icon = { Icon(imageVector,"") },
                            onClick = { increaseByTen() }
                        )
                    },
                    topBar = {
                        HomeTopAppBar(elevation = 0.dp)
                    }
                ) { innerPaddingModifier ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPaddingModifier),
                        viewModel = foodViewModel)
                }
            }
        }
    }

    private fun increaseByTen() {
        foodViewModel.increaseSharedFoodOccurrencesWithTen()
    }
}

/**
 * TopAppBar for the Home screen
 */
@Composable
private fun HomeTopAppBar(
    elevation: Dp
) {
    val title = stringResource(id = R.string.app_name)
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = elevation,
        title = {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.LocalPizza),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.Cake),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.LunchDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.Coffee),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.RamenDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.BakeryDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.Icecream),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.BreakfastDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.EmojiFoodBeverage),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
            }
        }
    )
}