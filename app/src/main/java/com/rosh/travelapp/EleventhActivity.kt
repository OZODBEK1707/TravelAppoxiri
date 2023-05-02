package com.rosh.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.rosh.travelapp.databinding.ActivityEleventhBinding
import com.rosh.travelapp.maps.MapsActivity

class EleventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEleventhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEleventhBinding.inflate(layoutInflater)
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
            val intent = Intent(this@EleventhActivity, TenthActivity::class.java)

            startActivity(intent)

        }
        binding.roadmapButton.setOnClickListener {
            val intent = Intent(this@EleventhActivity, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}