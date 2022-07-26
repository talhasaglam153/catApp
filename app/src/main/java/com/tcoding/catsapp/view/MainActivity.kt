package com.tcoding.catsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tcoding.catsapp.R
import com.tcoding.catsapp.databinding.ActivityMainBinding
import com.tcoding.catsapp.viewmodel.CatViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
    }

    fun initViewModel() {
        var viewModel = ViewModelProvider(this).get(CatViewModel::class.java)

        viewModel.getLiveDataList().observe(this, Observer {
            Toast.makeText(this, "${it.description}", Toast.LENGTH_SHORT).show()
        })

        viewModel.callAPI()
    }

}