package com.rosh.travelapp.maps

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.rosh.travelapp.R
import com.rosh.travelapp.databinding.ActivityMapsBinding
import com.rosh.travelapp.models.MyLatLng.destination_latitude
import com.rosh.travelapp.models.MyLatLng.destination_longitude
import com.rosh.travelapp.models.MyLatLng.origin_latitude
import com.rosh.travelapp.models.MyLatLng.origin_longitude

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    val PERMISSION_REQUEST_ACCESS_FINE_LOCATION = 1001

    companion object{
        private const val LOCATION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
    }


    private lateinit var marker: Marker
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
       mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)
        setUpMap(googleMap)


    }
    private lateinit var marker1: Marker
    @SuppressLint("SuspiciousIndentation", "SetTextI18n")
    private fun setUpMap(googleMap: GoogleMap) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_REQUEST_CODE)
            return
        }
        mMap.isMyLocationEnabled = true
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) {location ->

            if (location!=null){
                lastLocation = location
                val currentLatLong = LatLng(location.latitude, location.longitude)
                destination_latitude = location.latitude
                destination_longitude = location.longitude

                val lat_orta_arif = (destination_latitude+ origin_latitude)/2
                val lng_orta_arif = (destination_longitude+ origin_longitude)/2


                    placeMarkerOnMap(currentLatLong)
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition(LatLng(lat_orta_arif,lng_orta_arif),15f,0f,0f)))
                val results = FloatArray(1)
                Location.distanceBetween(origin_latitude, origin_longitude, destination_latitude, destination_longitude,
                    results)
                binding.distanceButton.visibility =View.VISIBLE
                val distanceInMeters = results[0]
                val distance = distanceInMeters/1000
                binding.txtDistance.text = "sizdan $distance km uzoqlikda "
                val latLng2 = LatLng(41.31680, 69.24887)
                marker1 = mMap.addMarker(MarkerOptions().position(currentLatLong))!!
                marker1 = mMap.addMarker(MarkerOptions().position(latLng2))!!
                val options = PolylineOptions()
                    .add(currentLatLong, latLng2)
                    .width(5f)
                    .color(Color.RED)
                googleMap.addPolyline(options)

            }


        }
    }

    private fun placeMarkerOnMap(currentLatLong: LatLng) {
        val markerOptions = MarkerOptions().position(currentLatLong)
        markerOptions.title("$currentLatLong")
        mMap.addMarker(markerOptions)
    }

    override fun onMarkerClick(p0: Marker) = false

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_ACCESS_FINE_LOCATION -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission has been granted
                    // TODO: Get the user's location
                } else {
                    // Permission has been denied
                    // TODO: Handle permission denied
                }
                return
            }
            else -> {
                // Ignore all other requests.
            }
        }
    }

}