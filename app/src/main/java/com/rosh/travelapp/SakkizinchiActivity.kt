package com.rosh.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.rosh.travelapp.databinding.ActivitySakkizinchiBinding

class SakkizinchiActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySakkizinchiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySakkizinchiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        binding.thirdBackArrow.setOnClickListener {
            val intent = Intent(this@SakkizinchiActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val animFromButton = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom)
        val animFromLeft = AnimationUtils.loadAnimation(this, R.anim.anim_from_left)
        val animFromRight = AnimationUtils.loadAnimation(this, R.anim.anim_from_right)


        binding.thirdBackArrow.animation = animFromLeft
        binding.secondTitle.animation = animFromRight
        binding.secondSubtitle.animation = animFromRight
        binding.secondRatingBar.animation = animFromLeft
        binding.secondratingNumber.animation = animFromRight
        binding.thirdBackArrow.animation = animFromButton
        binding.moreDetails.animation = animFromButton


        binding.thirdArrowUp.setOnClickListener {
            val intent = Intent(this@SakkizinchiActivity, ToqqizinchiActivity::class.java)
            startActivity(intent)
        }
    }
}