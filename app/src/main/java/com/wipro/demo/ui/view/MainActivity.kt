package com.wipro .demo.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.wipro.demo.R
import com.wipro.demo.data.model.UserResponse
import com.wipro.demo.data.network.RetrofitClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.textView)
        RetrofitClient.getRetrofitApi().getData("/search",getQueryMap()).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("TAG",t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val response= response.body()?.string()
                val data= response?.let { Json.decodeFromString<UserResponse>(serializer(), it) }
                    Toast.makeText(this@MainActivity,data?.items?.size.toString(),Toast.LENGTH_LONG).show()

            }

        })

    }
    private fun getQueryMap():HashMap<String,String>{
        val option=HashMap<String,String>()
        option["order"]="desc"
        option["sort"]="activity"
        option["intitle"]="perl"
        option["site"]="stackoverflow"
        return option
    }

}