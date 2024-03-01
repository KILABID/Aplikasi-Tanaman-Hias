package com.latihanpbo.ujiandicoding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class DescrpitionActivity : AppCompatActivity() {
    private lateinit var imgTanaman: ImageView
    private lateinit var namaTanaman: TextView
    private lateinit var familiTanaman: TextView
    private lateinit var ordoTanaman: TextView
    private lateinit var descTanaman: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descrpition)

        imgTanaman = findViewById(R.id.img_desc_tanaman)
        namaTanaman = findViewById(R.id.tv_desc_tanaman)
        familiTanaman = findViewById(R.id.tv_desc_famili)
        ordoTanaman = findViewById(R.id.tv_desc_ordo)
        descTanaman = findViewById(R.id.tv_desc)
        val dataFamili = resources.getStringArray(R.array.data_famili)
        val dataOrdo = resources.getStringArray(R.array.data_ordo)
        val dataName = resources.getStringArray(R.array.data_nama_tanaman)

        val receivedList: ArrayList<Tanaman>? = intent.getParcelableArrayListExtra("data")


        if (!receivedList.isNullOrEmpty()){
            val item = receivedList[0]
            val name = item.name
            val desc = item.description
            val img = item.photo

            imgTanaman.setImageResource(img)
            namaTanaman.text = name
            descTanaman.text = desc

            if (name == dataName[2]){
                familiTanaman.text = dataFamili[1]
                ordoTanaman.text = dataOrdo[1]
            } else if (name == dataName[6]){
                familiTanaman.text = dataFamili[2]
                ordoTanaman.text = dataOrdo[2]
            } else if (name == dataName[9]){
                familiTanaman.text = dataFamili[3]
                ordoTanaman.text = dataOrdo[3]
            } else {
                familiTanaman.text = dataFamili[0]
                ordoTanaman.text = dataOrdo[0]
            }

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val actionShare: View = findViewById(R.id.action_share)
        actionShare.setOnClickListener { view ->
            val intent = Intent()
            intent.setAction(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, namaTanaman.text)
            intent.setType("text/plain")
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}