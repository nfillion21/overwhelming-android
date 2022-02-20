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
import pgm.poolp.overwhelming.ui.home.HomeScreen
import pgm.poolp.overwhelming.ui.theme.OverwhelmingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OverwhelmingTheme {
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
                */
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
        title = {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.LocalPizza),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.Cake),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.LunchDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.Coffee),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.RamenDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.BakeryDining),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.Icecream),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.RiceBowl),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
                Icon(
                    painter = rememberVectorPainter(Icons.TwoTone.EmojiFoodBeverage),
                    contentDescription = title,
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                )
            }
        },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = elevation
    )
}