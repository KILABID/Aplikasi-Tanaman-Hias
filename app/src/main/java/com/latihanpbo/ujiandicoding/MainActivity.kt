package com.latihanpbo.ujiandicoding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTanaman: RecyclerView
    private val list = ArrayList<Tanaman>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTanaman = findViewById(R.id.rv_tanaman)
        rvTanaman.setHasFixedSize(true)

        list.addAll(getListTanaman())
        showRecyclerList()
    }

    private fun getListTanaman(): ArrayList<Tanaman> {
        val dataName = resources.getStringArray(R.array.data_nama_tanaman)
        val dataDescription = resources.getStringArray(R.array.data_desc_tanaman)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTanaman = ArrayList<Tanaman>()
        for (i in dataName.indices) {
            val tanaman = Tanaman(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listTanaman.add(tanaman)
        }
        return listTanaman
    }

    private fun showRecyclerList(){
        rvTanaman.layoutManager = LinearLayoutManager(this)
        val listTanamanAdapater = ListTanamanAdapter(list) { clickedTanaman ->
            val intentToDescription = Intent(this@MainActivity, DescrpitionActivity::class.java)
            val clickedTanamanList = arrayListOf(clickedTanaman)
            intentToDescription.putParcelableArrayListExtra("data", clickedTanamanList)
            startActivity(intentToDescription)
        }
        rvTanaman.adapter = listTanamanAdapater

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvTanaman.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvTanaman.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_button -> {
                val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}