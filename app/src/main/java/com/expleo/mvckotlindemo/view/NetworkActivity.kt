package com.expleo.androidkotlintutorial

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.expleo.mvckotlindemo.R
import com.expleo.mvckotlindemo.controller.NetworkController
import com.expleo.mvckotlindemo.util.CustomCallback


class NetworkActivity : AppCompatActivity() {

    lateinit var txtMsg : TextView
    lateinit var btnNext : Button


    lateinit var controller : NetworkController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        txtMsg = findViewById(R.id.txtMsg)
        btnNext = findViewById(R.id.btnNext)

        controller = NetworkController()

        btnNext.setOnClickListener {
            println("Button Clicked")

            controller.getResponse(object : CustomCallback{

                override fun onSuccessResponse(title: String) {

                    println("Success")
                    txtMsg.text = title
                }

                override fun onFailureResponse() {

                    println("Failed")
                }
            })

        }
    }

}