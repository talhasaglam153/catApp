package com.tcoding.catsapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcoding.catsapp.R
import com.tcoding.catsapp.databinding.ActivityMainBinding
import com.tcoding.catsapp.model.Cat
import com.tcoding.catsapp.model.CatInfo
import com.tcoding.catsapp.view.adapter.CatAdapter
import com.tcoding.catsapp.viewmodel.CatViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var catAdapter: CatAdapter
    lateinit var list: Cat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = Cat()
        initRecyclerView()
        initViewModel()
    }

    fun initViewModel() {
        var viewModel = ViewModelProvider(this).get(CatViewModel::class.java)

        viewModel.getLiveDataList().observe(this, Observer {
            catAdapter.updateList(it)
            list = it
        })
        viewModel.callAPI()
    }

    fun initRecyclerView() {
        binding.rv.layoutManager = LinearLayoutManager(this)
        catAdapter = CatAdapter(::itemClick)

        binding.rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        binding.rv.adapter = catAdapter
    }


    fun itemClick(position: Int) {
       /* var phone = Phone(ArrayList(), false)

        myList.observe(this, Observer {
            phone = it
        })

        val intent = Intent(this, PhoneDetailActivity::class.java)
        intent.putExtra("phone",phone)
        intent.putExtra("position", position)
        cameraRl.launch(intent)
*/

        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("obj",list[position].wikipedia_url)
        webViewLauncher.launch(intent)

    }

    var webViewLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        if(it.resultCode == RESULT_OK) {

        }


    }

}