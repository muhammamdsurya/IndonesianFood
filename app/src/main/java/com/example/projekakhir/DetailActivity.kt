package com.example.projekakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.projekakhir.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setTitle("Detail Makanan")
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dataMakanan = intent.getParcelableExtra<Makanan>("key_makanan")


            binding.namaMakanan.text = dataMakanan?.name
            binding.detailDescription.text = dataMakanan?.description
            binding.resepMakanan.text = dataMakanan?.resep
            Glide.with(this)
                .load(dataMakanan?.photo)
                .into(binding.detailPhoto)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share_button -> {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = binding.detailDescription.text
                val shareSubject = binding.namaMakanan.text
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
                startActivity(Intent.createChooser(sharingIntent, "Share using"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}