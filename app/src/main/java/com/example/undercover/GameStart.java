package com.example.undercover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.undercover.Data.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameStart extends AppCompatActivity {

    private List<Player> activePlayerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        List<String> activePlayerNames = getIntent().getStringArrayListExtra("key");

        if (!(activePlayerNames == null)) {
            for (String name : activePlayerNames) {
                this.activePlayerList.add(new Player(name));
            }
        }

        Random randomGenerator = new Random();
        int randomInt1 = randomGenerator.nextInt(this.activePlayerList.size());

        if (getIntent().getBooleanExtra("isTwoSpies", false)) {

            int randomInt2 = randomGenerator.nextInt(this.activePlayerList.size());

            while (randomInt1 == randomInt2) {
                randomInt2 = randomGenerator.nextInt(this.activePlayerList.size());
            }

            this.activePlayerList.get(randomInt2).setSpy();
        }

        this.activePlayerList.get(randomInt1).setSpy();
    }

    public List<Player> getActivePlayerList() {
        return activePlayerList;
    }
}
