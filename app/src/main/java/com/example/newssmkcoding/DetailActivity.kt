package com.example.newssmkcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.newssmkcoding.Utils.Constans
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvJudul.setText(intent.getStringExtra("title"))
        tvDeskripsi.setText(intent.getStringExtra("description"))
        tvPublishedAt.setText(intent.getStringExtra("publishedAt"))

        btn_back.setOnClickListener {
            val goBack = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(goBack)
            finish()
        }

        Glide.with(this)
            .load(Constans.IMAGE_URL + intent.getStringExtra("imgItem"))
            .placeholder(R.drawable.user)
            .error(R.drawable.user)
            .into(imgItem)
    }
}