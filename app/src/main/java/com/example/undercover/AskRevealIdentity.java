package com.example.undercover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.undercover.Data.Player;

import java.util.ArrayList;

public class AskRevealIdentity extends AppCompatActivity {

    private ArrayList<Player> activePlayerList = new ArrayList<>();
    private TextView textView;
    private String identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_reveal_identity);

        this.activePlayerList = (ArrayList<Player>)
                getIntent().getSerializableExtra("activePlayerList");

        this.identity = getIntent().getStringExtra("identity");

        this.textView = findViewById(R.id.textViewAsk);

        this.textView.setText(this.activePlayerList.get(0).getName());
    }

    public void showIdentity(View view) {
        Intent intent = new Intent(this, ShowIdentity.class);
        intent.putExtra("activePlayerList", this.activePlayerList);
        intent.putExtra("identity", this.identity);
        startActivity(intent);
    }
}
