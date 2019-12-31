package com.example.undercover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.undercover.Data.Player;

import java.util.ArrayList;

public class GameSettings extends AppCompatActivity {

    private EditText player1;
    private EditText player2;
    private EditText player3;
    private EditText player4;
    private EditText player5;
    private EditText player6;
    private EditText player7;

    private Switch switch4;
    private Switch switch5;
    private Switch switch6;
    private Switch switch7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        player3 = findViewById(R.id.player3);
        player4 = findViewById(R.id.player4);
        player5 = findViewById(R.id.player5);
        player6 = findViewById(R.id.player6);
        player7 = findViewById(R.id.player7);

        switch4 = findViewById(R.id.switch4);
        switch5 = findViewById(R.id.switch5);
        switch6 = findViewById(R.id.switch6);
        switch7 = findViewById(R.id.switch7);
    }

    public void setTime(View view) {
        String playerOne = player1.getText().toString();
        String playerTwo = player2.getText().toString();
        String playerThree = player3.getText().toString();
        String playerFour = player4.getText().toString();
        String playerFive = player5.getText().toString();
        String playerSix = player6.getText().toString();
        String playerSeven = player7.getText().toString();


        ArrayList<String> activePlayerList = new ArrayList<>();

        activePlayerList.add(playerOne);
        activePlayerList.add(playerTwo);
        activePlayerList.add(playerThree);

        if (switch4.isChecked()) {
            activePlayerList.add(playerFour);
        }
        if (switch5.isChecked()) {
            activePlayerList.add(playerFive);
        }
        if (switch6.isChecked()) {
            activePlayerList.add(playerSix);
        }
        if (switch7.isChecked()) {
            activePlayerList.add(playerSeven);
        }

        Intent intent = new Intent(this, setNumberOfSpies.class);
        intent.putStringArrayListExtra("key", activePlayerList);
        if (activePlayerList.size() >= 4) {
            startActivity(intent);
        } else {
            intent = new Intent(this, GameStart.class);
            intent.putStringArrayListExtra("key", activePlayerList);
            intent.putExtra("isTwoSpies", false);
            startActivity(intent);
        }
    }
}
