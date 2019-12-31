package com.example.undercover;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class setNumberOfSpies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_number);

        List activePlayerList = getIntent().getStringArrayListExtra("activePlayerList");
    }
}
