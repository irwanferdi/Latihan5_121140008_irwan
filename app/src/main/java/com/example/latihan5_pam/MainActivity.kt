package com.example.latihan5_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.latihan5_pam.ui.theme.Latihan5_pamTheme
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Latihan5_pamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        // Membuat objek Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Ganti dengan base URL yang sesuai
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Menggunakan objek Retrofit untuk membuat instance layanan
        val service = retrofit.create(MyService::class.java)

        // Sekarang Anda dapat menggunakan service untuk melakukan panggilan API
        // Contoh:
        // val call = service.getMyData()
        // call.enqueue(object : Callback<MyData> {
        //     override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
        //         if (response.isSuccessful) {
        //             val myData = response.body()
        //             // Lakukan sesuatu dengan data yang diterima
        //         }
        //     }
        //
        //     override fun onFailure(call: Call<MyData>, t: Throwable) {
        //         // Handle kegagalan panggilan
        //     }
        // })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Latihan5_pamTheme {
        Greeting("Android")
    }
}
