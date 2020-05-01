package com.example.bluff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bluff.Data.Assignment;
import com.example.bluff.Data.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

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



        /// 5 options for spy
        ArrayList<String> fiveOptions = new ArrayList<>();

        Assignment assignment = new Assignment();
        int jobListSize = assignment.getJobsList().size();

        Random randomGenerator = new Random();

        ArrayList<String> fiveOptionsIndex = new ArrayList<>();

        fiveOptions.add(this.identity);

        //todo changed this to 3 temporarily

        while (fiveOptions.size() < 5) {
            int randomInt = randomGenerator.nextInt(jobListSize);

            if (!fiveOptionsIndex.contains(randomInt + "")) {
                fiveOptionsIndex.add(randomInt + "");

                String jobName = (String) assignment.getJobsList().get(randomInt);

                if (jobName.equalsIgnoreCase(this.identity)) {
                    fiveOptions.remove(randomInt + "");
                } else {
                    fiveOptions.add(jobName);

                }
            }
        }

        Collections.shuffle(fiveOptions);

        String displayTextForSpy = "You are a SPY \n \n" + "Hints:\n" +
                fiveOptions.get(0).toUpperCase() + ", " + fiveOptions.get(1).toUpperCase()
                + ", " + fiveOptions.get(2).toUpperCase() + ", " + fiveOptions.get(3).toUpperCase()
                + ", or " + fiveOptions.get(4).toUpperCase();
        ///


        if (!this.activePlayerList.get(0).isSpy()) {
            this.textView.setText(displayMessage);
        } else {
            this.textView.setText(displayTextForSpy);
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


//package com.example.bluff;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import com.example.bluff.Data.Player;
//
//import java.util.ArrayList;
//
//public class ShowIdentity extends AppCompatActivity {
//
//    private ArrayList<Player> activePlayerList = new ArrayList<>();
//    private TextView textView;
//    private String identity;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_show_identity);
//
//        this.activePlayerList = (ArrayList<Player>)
//                getIntent().getSerializableExtra("activePlayerList");
//
//        this.identity = getIntent().getStringExtra("identity");
//
//        this.textView = findViewById(R.id.textViewIdentity);
//
//        String displayMessage = "Your identity is: ";
//        this.identity = this.identity.toUpperCase();
//        displayMessage = displayMessage + this.identity;
//
//        if (!this.activePlayerList.get(0).isSpy()) {
//            this.textView.setText(displayMessage);
//        } else {
//            this.textView.setText("Your identity is: SPY \n \n Bluff your way to victory!");
//        }
//
//        this.activePlayerList.remove(0);
//    }
//
//    public void nextPlayer(View view) {
//
//        if (this.activePlayerList.size() > 0) {
//            Intent intent = new Intent(this, AskRevealIdentity.class);
//            intent.putExtra("activePlayerList", this.activePlayerList);
//            intent.putExtra("identity", this.identity);
//            startActivity(intent);
//        } else {
//            Intent intent = new Intent(this, RestartGame.class);
//            startActivity(intent);
//        }
//    }
//}
