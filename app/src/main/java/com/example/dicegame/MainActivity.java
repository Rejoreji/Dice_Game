package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM= new Random();
    private Button high,low;
    private ImageView image1, image2;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        high =(Button)findViewById(R.id.high);
        low =(Button)findViewById(R.id.low);
        image1=(ImageView) findViewById(R.id.image1);
        image2=(ImageView) findViewById(R.id.image2);
        text=(TextView) findViewById(R.id.result);

        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();
                int res1 = getResources().getIdentifier("dice"+value1,"drawable","com.example.dicegame");
                int res2 = getResources().getIdentifier("dice"+value2,"drawable","com.example.dicegame");
                image1.setImageResource(res1);
                image2.setImageResource(res2);

                if (value1>value2){
                    text.setText("USER WIN!");
                }

                else if (value1==value2){
                    text.setText("IT'S A TIE");
                }

                else {
                    text.setText("COMPUTER WIN!");
                }

            }
        });

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();
                int res1 = getResources().getIdentifier("dice"+value1,"drawable","com.example.dicegame");
                int res2 = getResources().getIdentifier("dice"+value2,"drawable","com.example.dicegame");
                image1.setImageResource(res1);
                image2.setImageResource(res2);

                if (value1<value2){
                    text.setText("USER WIN!");
                }

                else if (value1==value2){
                    text.setText("IT'S A TIE");
                }

                else {
                    text.setText("COMPUTER WIN!");
                }

            }
        });
    }
    public  static int randomDiceValue(){
        return RANDOM.nextInt(6)+1;
    }
}