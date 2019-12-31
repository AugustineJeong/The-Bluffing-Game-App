package com.example.bluff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bluff.Data.Assignment;
import com.example.bluff.Data.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameStart extends AppCompatActivity {

    private ArrayList<Player> activePlayerList = new ArrayList<>();
    private TextView textView;
    private String identity;

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

        Assignment assignment = new Assignment();
        List jobsList = assignment.getJobsList();

        int randomJobInt = randomGenerator.nextInt(jobsList.size());
        this.identity = (String) jobsList.get(randomJobInt);

        textView = findViewById(R.id.textView2);
        textView.setText(this.activePlayerList.get(0).getName());
    }

    public List<Player> getActivePlayerList() {
        return activePlayerList;
    }

    public void revealIdentity(View view) {
        Intent intent = new Intent(this, ShowIdentity.class);

        intent.putExtra("identity", this.identity);
        intent.putExtra("activePlayerList", this.activePlayerList);

        startActivity(intent);
    }
}
