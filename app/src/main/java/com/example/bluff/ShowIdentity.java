package com.example.bluff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bluff.Data.Player;

import java.util.ArrayList;

public class ShowIdentity extends AppCompatActivity {

    private ArrayList<Player> activePlayerList = new ArrayList<>();
    private TextView textView;
    private String identity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_identity);

        this.activePlayerList = (ArrayList<Player>)
                getIntent().getSerializableExtra("activePlayerList");

        this.identity = getIntent().getStringExtra("identity");

        this.textView = findViewById(R.id.textViewIdentity);

        String displayMessage = "Your identity is: ";
        this.identity = this.identity.toUpperCase();
        displayMessage = displayMessage + this.identity;

        if (!this.activePlayerList.get(0).isSpy()) {
            this.textView.setText(displayMessage);
        } else {
            this.textView.setText("Your identity is: SPY \n \n Bluff your way to victory!");
        }

        this.activePlayerList.remove(0);
    }

    public void nextPlayer(View view) {

        if (this.activePlayerList.size() > 0) {
            Intent intent = new Intent(this, AskRevealIdentity.class);
            intent.putExtra("activePlayerList", this.activePlayerList);
            intent.putExtra("identity", this.identity);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, RestartGame.class);
            startActivity(intent);
        }
    }
}
