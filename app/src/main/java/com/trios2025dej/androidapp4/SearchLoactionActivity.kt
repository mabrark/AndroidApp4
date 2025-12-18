package com.trios2025dej.androidapp4

import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SearchLocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_location)

        val edtSearch = findViewById<EditText>(R.id.edtSearch)
        val btnFind = findViewById<Button>(R.id.btnFindLocation)
        val txtResult = findViewById<TextView>(R.id.txtSearchResult)

        btnFind.setOnClickListener {
            val locationName = edtSearch.text.toString()

            if (locationName.isNotEmpty()) {
                val geocoder = Geocoder(this, Locale.getDefault())
                val addressList = geocoder.getFromLocationName(locationName, 1)

                if (!addressList.isNullOrEmpty()) {
                    val address = addressList[0]
                    txtResult.text = "Latitude: ${address.latitude}\nLongitude: ${address.longitude}"
                } else {
                    txtResult.text = "Location not found."
                }
            }
        }
    }
}
