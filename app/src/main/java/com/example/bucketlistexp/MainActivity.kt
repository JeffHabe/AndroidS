package com.example.bucketlistexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    val bucketList = mutableListOf("Go skiing", "Go diving", "Horse riding")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickBtn.setOnClickListener { pickBtnOnClick() }
        addBtn.setOnClickListener { addBtnOnClick() }

    }

    private fun addBtnOnClick() {
        var newWish = wishEdt.text.toString()
        bucketList.add(newWish)
        println("addbtn:$bucketList")

    }

    private fun pickBtnOnClick() {
        val random = (Math.random() * bucketList.count()).toInt()

        println(bucketList.isNullOrEmpty())
        if (bucketList.isNotEmpty()) {
            toDoTxt.text = bucketList[random]
            bucketList.removeAt(random)
            println("pickBtn:$bucketList")
        } else {
            toDoTxt.text = getString(R.string.noMorePlan)
        }
    }
}

