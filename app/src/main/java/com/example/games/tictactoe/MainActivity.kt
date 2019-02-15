package com.example.games.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.games.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var player = 1
    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    var score1:Int=0
    var score2:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buttons = listOf(button,button2,button3,button4,button5,button6,button7,button8,button9,buttonRestart);
        buttonRestart.isEnabled=false
    }

    fun select(view: View) {
        val selectedButton = view as Button
        var  buttonCode = 0
        when (selectedButton.id){
            R.id.button -> buttonCode=1
            R.id.button2 -> buttonCode=2
            R.id.button3 -> buttonCode=3
            R.id.button4 -> buttonCode=4
            R.id.button5 -> buttonCode=5
            R.id.button6 -> buttonCode=6
            R.id.button7 -> buttonCode=7
            R.id.button8 -> buttonCode=8
            R.id.button9 -> buttonCode=9
        }
        if(andTheWinnerIs()==0){
            gameOn(buttonCode,selectedButton)
            cpuPlayer()
            when(andTheWinnerIs()){
                1-> {
                    score1++

                }
                2-> {
                    score2++

                }
            }
            if(andTheWinnerIs()!=0){
                buttonRestart.isEnabled = true
                Toast.makeText(
                    this,
                    "The winner is Player ${andTheWinnerIs()} and the score is $score1 to $score2",
                    Toast.LENGTH_LONG
                ).show()
            }
        }else{
            //NOTHING!
        }

    }

    fun gameOn(buttonCode:Int, selectedButton:Button){
        if(andTheWinnerIs()==0) {
            if (player == 1) {
                selectedButton.text = "X"
                selectedButton.setBackgroundResource(R.color.blue)
                p1.add(buttonCode)
                player = 2
            } else if (player == 2) {
                selectedButton.text = "O"
                selectedButton.setBackgroundResource(R.color.green)
                p2.add(buttonCode)
                player = 1
            }
            selectedButton.isEnabled = false
        }
    }
    fun cpuPlayer(){
        var button: Button? = null
        var buttonCode = (1..9).random()

        var new = false
        while(!new && p1.size!=5){
            buttonCode = (1..9).random()
            for(p in p1){
                new = !(p==buttonCode)
            }
        }

        when(buttonCode){
            1 -> {
                button = findViewById(R.id.button) as Button
            }
            2 -> {
                button = findViewById(R.id.button2) as Button
            }
            3 -> {
                button = findViewById(R.id.button3) as Button
            }
            4 -> {
                button = findViewById(R.id.button4) as Button
            }
            5 -> {
                button = findViewById(R.id.button5) as Button
            }
            6 -> {
                button = findViewById(R.id.button6) as Button
            }
            7 -> {
                button = findViewById(R.id.button7) as Button
            }
            8 -> {
                button = findViewById(R.id.button8) as Button
            }
            9 -> {
                button = findViewById(R.id.button9) as Button
            }
        }

        if (button != null && p1.size!=5) {
            if(button.isEnabled){
                gameOn(buttonCode,button)
            } else {
                cpuPlayer()
            }
        }
    }

    fun restart(view:View){
        var buttons = listOf(button,button2,button3,button4,button5,button6,button7,button8,button9)
        player = 1
        for(i in 0..(buttons.size-1)){
            buttons[i].setBackgroundResource(R.color.white)
            buttons[i].text=""
            buttons[i].isEnabled=true
        }
        p1.clear()
        p2.clear()
    }

    fun andTheWinnerIs():Int{
        var win:Int= 0
        for (i in 0..5){
            if (p1.contains(i+1) && p1.contains(i+2) && p1.contains(i+3) ) win = 1
            if (p2.contains(i+1) && p2.contains(i+2) && p2.contains(i+3) )win = 2
            if (p1.contains(i+1) && p1.contains(i+4) && p1.contains(i+7)) win = 1
            if (p2.contains(i+1) && p2.contains(i+4) && p2.contains(i+7)) win = 2
        }
        if (p1.contains(1) && p1.contains(5) && p1.contains(9)) win = 1
        if (p2.contains(1) && p2.contains(5) && p2.contains(9)) win = 2
        if (p1.contains(3) && p1.contains(5) && p1.contains(7)) win = 1
        if (p2.contains(3) && p2.contains(5) && p2.contains(7)) win = 2
        //if (p1.contains(1)&& p1.contains(2) && p1.contains(3)) win =  1
        //if (p2.contains(1)&& p2.contains(2) && p2.contains(3)) win =  2
        System.out.println("win: "+win)
        return win
    }


}
