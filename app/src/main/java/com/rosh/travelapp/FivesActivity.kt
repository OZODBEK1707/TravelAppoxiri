package com.rosh.travelapp

import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.gms.maps.model.LatLng
import com.rosh.travelapp.databinding.ActivityFivesBinding
import com.rosh.travelapp.maps.MapsActivity

class FivesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFivesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFivesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        val fromBottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom)

        binding.downArrow.animation = fromBottom
        binding.thirdScrollView.animation = fromBottom

        binding.downArrow.setOnClickListener {
            val intent = Intent(this@FivesActivity, FourthActivity::class.java)

            startActivity(intent)
        }
        binding.roadmapButton.setOnClickListener {
            val intent = Intent(this@FivesActivity, MapsActivity::class.java)
            intent.putExtra("registon", LatLng(39.65476, 66.97573))
            startActivity(intent)
        }
    }
}