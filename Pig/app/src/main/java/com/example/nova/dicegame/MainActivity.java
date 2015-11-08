package com.example.nova.dicegame;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
        Button b_roll;
        Button b_hold;
        Button b_reset;
        TextView t_score1, t_score2, t_player1, t_player2, t_scoreloc;
        int global_score1, global_score2,local_score=0, playerFlag=1, number;
        ImageView dice;
        Random r = new Random();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);

            b_roll = (Button) findViewById(R.id.rollbutton);
            b_reset = (Button) findViewById(R.id.resetbutton);
            b_hold = (Button) findViewById(R.id.holdbutton);

            t_player1 = (TextView) findViewById(R.id.p1);
            t_player2 = (TextView) findViewById(R.id.p2);
            t_score1 = (TextView) findViewById(R.id.p1score);
            t_score2 = (TextView) findViewById(R.id.p2score);
            t_scoreloc = (TextView) findViewById(R.id.scoreloc);

            dice = (ImageView) findViewById(R.id.diceImage);
            t_player1.setTextColor(Color.GREEN);
            t_player2.setTextColor(Color.RED);

            b_roll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    number = r.nextInt(6) + 1;
                    switch(number){
                        case 1:
                            dice.setImageResource(R.drawable.onered);
                            break;
                        case 2:
                            dice.setImageResource(R.drawable.two);
                            break;
                        case 3:
                            dice.setImageResource(R.drawable.three);
                            break;
                        case 4:
                            dice.setImageResource(R.drawable.four);
                            break;
                        case 5:
                            dice.setImageResource(R.drawable.five);
                            break;
                        case 6:
                            dice.setImageResource(R.drawable.six);
                            break;

                    }
                    if(playerFlag==1){
                        if(number==1)
                        {
                            playerFlag=2;
                            local_score=0;
                            t_scoreloc.setText(String.valueOf(local_score));
                            t_player2.setTextColor(Color.GREEN);
                            t_player1.setTextColor(Color.RED);

                        }
                        else{
                            local_score+=number;
                            t_scoreloc.setText(String.valueOf(local_score));
                        }

                    }
                    else{
                        if(number==1)
                        {
                            playerFlag=1;
                            local_score=0;
                            t_scoreloc.setText(String.valueOf(local_score));
                            t_player1.setTextColor(Color.GREEN);
                            t_player2.setTextColor(Color.RED);

                        }
                        else{
                            local_score+=number;
                            t_scoreloc.setText(String.valueOf(local_score));
                        }
                    }
                }
            });

            b_hold.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(playerFlag==1){
                        global_score1+=local_score;
                        if(global_score1>=100){
                            playerFlag=3;
                            //global_score1=0;
                            //global_score2=0;
                            //local_score=0;
                            dice.setImageResource(R.drawable.p1);
//                            t_score1.setText(String.valueOf(global_score1));
//                            t_score2.setText(String.valueOf(global_score2));
                            t_scoreloc.setText("press RESET for New Game");
                            t_player1.setTextColor(Color.GREEN);
                            t_score1.setText("100");
                            t_player1.setText("WINNER");
                            t_player2.setText("LOSER");
                            t_player2.setTextColor(Color.RED);
                        }
                        else {
                            playerFlag = 2;
                            t_player2.setTextColor(Color.GREEN);
                            t_player1.setTextColor(Color.RED);
                            local_score = 0;
                            t_score1.setText(String.valueOf(global_score1));
                            t_scoreloc.setText(String.valueOf(local_score));
                        }


                    }
                    else{
                        global_score2+=local_score;
                        if(global_score2>=100){
                            playerFlag=3;
                            //global_score1=0;
                            //global_score2=0;
                            //local_score=0;
                            dice.setImageResource(R.drawable.p2);
//                            t_score1.setText(String.valueOf(global_score1));
//                            t_score2.setText(String.valueOf(global_score2));
                            t_scoreloc.setText("press RESET for New Game");
                            t_player2.setTextColor(Color.GREEN);
                            t_score2.setText("100");
                            t_player2.setText("WINNER");
                            t_player1.setText("LOSER");
                            t_player1.setTextColor(Color.RED);
                        }
                        else {
                            playerFlag = 1;
                            t_player1.setTextColor(Color.GREEN);
                            t_player2.setTextColor(Color.RED);
                            local_score = 0;
                            t_score2.setText(String.valueOf(global_score2));
                            t_scoreloc.setText(String.valueOf(local_score));
                        }
                    }

                }
            });

            b_reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerFlag=1;
                    global_score1=0;
                    global_score2=0;
                    local_score=0;
                    dice.setImageResource(R.drawable.pig);
                    t_score1.setText(String.valueOf(global_score1));
                    t_score2.setText(String.valueOf(global_score2));
                    t_player1.setText("Player 1");
                    t_player2.setText("Player 2");
                    t_scoreloc.setText(String.valueOf(local_score));
                    t_player1.setTextColor(Color.GREEN);
                    t_player2.setTextColor(Color.RED);
                }
            });


        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            //mediaPlayer.stop();
        }
    }

