package com.example.undercover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;

public class setNumberOfSpies extends AppCompatActivity {

    private Switch twoSpiesSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_number);
    }

    public void startGame(View view) {
        ArrayList<String> activePlayerList = getIntent().getStringArrayListExtra("key");

        twoSpiesSwitch = findViewById(R.id.twoSpiesSwitch);

        boolean isTwoSpies = false;


        if (twoSpiesSwitch.isChecked()) {
            isTwoSpies = true;
        }

        Intent intent = new Intent(this, GameStart.class);

        intent.putStringArrayListExtra("key", activePlayerList);
        intent.putExtra("isTwoSpies", isTwoSpies);

        startActivity(intent);
    }
}
