package com.example.newssmkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudfirebase.retrofit.DataService
import com.example.crudfirebase.retrofit.RetrofitClient
import com.example.newssmkcoding.Adapter.NewsAdapter
import com.example.newssmkcoding.Response.ResponseNews
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecycleView()

    }

    private fun setRecycleView() {
        val service = RetrofitClient().apiRequest().create(DataService::class.java)
        service.getNews().enqueue(object : Callback<ResponseNews> {
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                if (response.isSuccessful) {
                    if (response.body()!!.status == "true") {
                        val listData = response.body()!!.data

                        recycle_news.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = NewsAdapter(this@MainActivity, listData)
                            recycle_news.adapter = adapter
                        }
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "${response.body()!!.message}",
                            Toast.LENGTH_LONG
                        )
                    }
                } else {
                    Toast.makeText(this@MainActivity, "${response.message()}", Toast.LENGTH_LONG)
                }

            }

        })

    }
}