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
import javax.inject.Inject

class OverwhelmingRepository @Inject constructor () {

    val dbReference = Firebase.database("https://overwhelming-42f25-default-rtdb.europe-west1.firebasedatabase.app/").getReference("overwhelming")
    var number = 0

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getOverwhelming() = callbackFlow {

        dbReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<Int>()
                //Log.d(TAG, "Value is: $value")
                if (value == null) {
                    //offer(-1)
                    number = 0
                    trySend(number)
                }
                else {
                    //offer(value)
                    number = value
                    trySend(number)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException())
                //offer(-1)
                number = 0
                trySend(number)
            }
        })

        awaitClose {
        }
    }

    fun increaseWithTen() {
        number += 10
        dbReference.setValue(number)
    }

    fun decreaseFood() {
        if (number > 0)
        {
            number -= 1
            dbReference.setValue(number)
        }
    }

}