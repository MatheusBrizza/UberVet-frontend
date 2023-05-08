package br.com.fundatec.ubervet_frontend.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.ubervet_frontend.R
import br.com.fundatec.ubervet_frontend.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}