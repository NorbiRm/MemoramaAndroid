package com.example.games.memorama

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import android.widget.ImageView
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama.*

class MemoramaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)
        val rv = recyclerView1
        rv.setHasFixedSize(true)
        var grid=GridLayoutManager(this,0)
        rv.layoutManager = grid

        val chips = ArrayList<Chip>()
        for(i in 0..12){
            //
        }
    }
}
