package com.londonappbrewery.magiceightball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int oldRandomNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.askButton);
        final ImageView eightBallPicture = findViewById(R.id.eightBallPicture);
        final int[] ballArray = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };

        final Random randomNumber = new Random();

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answerNumber = randomNumber.nextInt(5);
                while (oldRandomNumber == answerNumber) {
                    answerNumber = randomNumber.nextInt(5);
                    Log.d("myMessage", "Same number, re-rolling.");
                }
                oldRandomNumber = answerNumber;

                eightBallPicture.setImageResource(ballArray[answerNumber]);

                Log.d("myMessage", "Applied drawable " + ballArray[answerNumber]);
            }
        });

    }
}
