package pgm.poolp.overwhelming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalPizza
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.sharp.LocalPizza
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import pgm.poolp.overwhelming.ui.home.HomeScreen
import pgm.poolp.overwhelming.ui.theme.OverwhelmingTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OverwhelmingTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    topBar = {
                        HomeTopAppBar(elevation = 0.dp)
                    }
                ) { innerPaddingModifier ->
                    HomeScreen(modifier = Modifier.padding(innerPaddingModifier))
                }
            }
        }
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
                    painter = rememberVectorPainter(Icons.Outlined.RiceBowl),
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