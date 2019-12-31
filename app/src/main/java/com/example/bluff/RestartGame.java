package com.example.bluff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestartGame extends AppCompatActivity {

    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart_game);

        restartButton = findViewById(R.id.buttonRestart);
    }

    public void restartGame(View view) {
        Intent intent = new Intent(this, GameSettings.class);
        startActivity(intent);
    }
}
