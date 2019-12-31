package com.example.undercover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.undercover.Data.ActivePlayers;
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
        Player playerOne = new Player(player1.getText().toString());
        Player playerTwo = new Player(player2.getText().toString());
        Player playerThree = new Player(player3.getText().toString());
        Player playerFour = new Player(player4.getText().toString());
        Player playerFive = new Player(player5.getText().toString());
        Player playerSix = new Player(player6.getText().toString());
        Player playerSeven = new Player(player7.getText().toString());

        ArrayList activePlayerList = new ArrayList();

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

        ActivePlayers activePlayers = new ActivePlayers();
        activePlayers.setActivePlayerList(activePlayerList);

        Intent intent = new Intent(this, setNumberOfSpies.class);
        if (activePlayerList.size() >= 4) {
            startActivity(intent);
        }
    }
}
