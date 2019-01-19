package com.example.mario.myapplication

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val bundle = intent.extras
        val msg = bundle!!.getString("user_message")
        txtUserMessage.text = msg
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}