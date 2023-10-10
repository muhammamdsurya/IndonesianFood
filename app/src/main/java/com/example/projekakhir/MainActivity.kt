package com.example.projekakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projekakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Makanan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Makanan Indonesia")

        binding.rvMakanan.setHasFixedSize(true)

        list.addAll(listMakanan)
        showRecyclerList()
    }

    private val listMakanan: ArrayList<Makanan> get(){
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataResep = resources.getStringArray(R.array.resep_makanan)
        val listMakanan = ArrayList<Makanan>()
        for (i in dataName.indices) {
            val makanan = Makanan(dataName[i], dataDescription[i], dataPhoto[i],dataResep[i])
            listMakanan.add(makanan)
        }
        return listMakanan
    }
    private  fun showRecyclerList() {
        binding.rvMakanan.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        binding.rvMakanan.adapter = listFoodAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}