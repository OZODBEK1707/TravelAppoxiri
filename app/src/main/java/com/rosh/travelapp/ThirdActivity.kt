package com.rosh.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.rosh.travelapp.databinding.ActivityThirdBinding
import com.rosh.travelapp.maps.MapsActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
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
            val intent = Intent(this@ThirdActivity, SecondActivity::class.java)

            startActivity(intent)

        }
        binding.roadmapButton.setOnClickListener {

            val intent = Intent(this@ThirdActivity, MapsActivity::class.java)
            startActivity(intent)
        }

    }
}