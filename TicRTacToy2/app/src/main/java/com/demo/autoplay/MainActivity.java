package com.demo.autoplay;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buClick(View view) {
        //View is used to indentify which button is clicked.
        //if view is bu1 button 1 is clicked
        //if  view is bu7 button 7 is clicked
        Button buSelected =(Button) view;

        int CellId = 0;
        switch ((buSelected.getId())){
            case R.id.bu1:
                CellId = 1;
                break;
            case R.id.bu2:
                CellId = 2;
                break;
            case R.id.bu3:
                CellId = 3;
                break;
            case R.id.bu4:
                CellId = 4;
                break;
            case R.id.bu5:
                CellId = 5;
                break;
            case R.id.bu6:
                CellId = 6;
                break;
            case R.id.bu7:
                CellId = 7;
                break;
            case R.id.bu8:
                CellId = 8;
                break;
            case R.id.bu9:
                CellId = 9;
                break;
        }

        PlayGame(CellId,buSelected);

    }
    int ActivePlayer = 1; // 1- player 1 , 2- player 2
    ArrayList<Integer> Player1 = new ArrayList<Integer>();// hold player 1 data
    void PlayGame(int CellId, Button buSelected) {


        Log.d("Player:", String.valueOf(CellId));
//        Log.d("Button:",button.getText().toString()); this foe the debugging
        // actual game logic
        if (ActivePlayer == 1) {
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            Player1.add(CellId);
            Autoplay();
//            ActivePlayer = 2;
        }
        //we are using this so that once button is selected it cannot be selected again
        buSelected.setEnabled(false);
        CheckWinner();
    }

    //this function is used to check who is the winner from array list

    void CheckWinner() {
        int Winner = -1;
        //row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            Winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            Winner = 2;
        }
        //row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            Winner = 1;
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            Winner = 2;
        }
        //row 7
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            Winner = 1;
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            Winner = 2;
        }
        //column = 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            Winner = 1;
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            Winner = 2;
        }
        // col 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            Winner = 1;
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            Winner = 2;
        }
        //col 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            Winner = 1;
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            Winner = 2;
        }
        //Showing the winner
        if (Winner != -1) {
            // we have a winner
            if (Winner == 1) {
                Toast.makeText(this, "Player 1  is winner", Toast.LENGTH_LONG).show();
            }
            if (Winner == 2) {
                Toast.makeText(this, "Player 2  is winner", Toast.LENGTH_LONG).show();
            }
        }
    }

    void Autoplay(){
        ArrayList<Integer>EmptyCells = new ArrayList<Integer>();// all unselected cells
        //Find empty cells
        for (int cellId=1;cellId<10;cellId++){
            if(!(Player1.contains(cellId))){
                EmptyCells.add(cellId);
            }
        }
        // here computer will select random number from the unselected cells
        Random r = new Random();
        int RandIndex = r.nextInt(EmptyCells.size() - 0)+ 0;//if size 3  , select (0,1,2)
        //add the cells to the arry list
        int CellId = EmptyCells.get(RandIndex);
        Button buSelected;
        switch (CellId){
            case 1:
                buSelected = (Button) findViewById(R.id.bu1);
                break;
            case 2:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 3:
                buSelected = (Button) findViewById(R.id.bu3);
                break;
            case 4:
                buSelected = (Button) findViewById(R.id.bu4);
                break;
            case 5:
                buSelected = (Button) findViewById(R.id.bu5);
                break;
            case 6:
                buSelected = (Button) findViewById(R.id.bu6);
                break;
            case 7:
                buSelected = (Button) findViewById(R.id.bu7);
                break;
            case 8:
                buSelected = (Button) findViewById(R.id.bu8);
                break;
            case 9:
                buSelected = (Button) findViewById(R.id.bu9);
                break;
            default:
                buSelected = (Button) findViewById(R.id.bu1);
        }
        PlayGame(CellId,buSelected);

    }
}