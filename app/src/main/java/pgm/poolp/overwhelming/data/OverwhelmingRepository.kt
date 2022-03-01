package pgm.poolp.overwhelming.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class OverwhelmingRepository {

    val dbReference = Firebase.database("https://overwhelming-42f25-default-rtdb.europe-west1.firebasedatabase.app/").getReference("overwhelming")
    //databaseReference = db.getReference("overwhelming")

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getOverwhelming() = callbackFlow<Int>{

        dbReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<Int>()
                //Log.d(TAG, "Value is: $value")
                if (value == null) {
                    //offer(-1)
                    trySend(0)
                }
                else {
                    //offer(value)
                    trySend(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException())
                //offer(-1)
                trySend(0)
            }
        })

        awaitClose {
        }
    }
}