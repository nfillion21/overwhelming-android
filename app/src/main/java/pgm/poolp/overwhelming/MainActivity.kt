package pgm.poolp.overwhelming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
    private lateinit var databaseReference: DatabaseReference
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //database = Firebase.database.reference

        setContent {
            foodViewModel = hiltViewModel()
            foodViewModel.decreaseFoodOccurrences()

            OverwhelmingTheme {
                Scaffold(
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
                            onClick = { increaseByTen() })
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
        foodViewModel.increaseFoodOccurrencesWithTen()

        //val db = Firebase.database("https://overwhelming-42f25-default-rtdb.europe-west1.firebasedatabase.app/")
        //val myRef = database.getReference("overwhelming")
        databaseReference.setValue(2)

        //database.child("overwhelming").setValue(1)


        // Read from the database
        /*
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
         */



        /*
        val db = Firebase.firestore
        // Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
        */

        /*
        val user = hashMapOf(
            "first" to "Alan",
            "middle" to "Mathison",
            "last" to "Turing",
            "born" to 1912
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                //Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                //Log.w(TAG, "Error adding document", e)
            }
         */

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