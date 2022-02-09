package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
            //Player representatoin: 0-X       1-O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//State meanings: 0 - O ,1-X , 2- null
    int[][] winPosition = {{0,1,2}, {3,4,5}, {6,7,8},
                           {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};
     public void playerTap(View view){
         ImageView img = (ImageView) view;
         int tappedImage = Integer.parseInt(img.getTag().toString());
         if(!gameActive){
             reset(view);

         }
         if(gameState[tappedImage] == 2 ) {
             gameState[tappedImage] = activePlayer;
             img.setTranslationY( -1000f );
             if (activePlayer == 0) {
                 img.setImageResource( R.drawable.crossss );
                 activePlayer = 1;
                  TextView status = findViewById(R.id.textView2);
                 status.setText( "O's turn Tap to PLAY");
             } else {
                 img.setImageResource( R.drawable.clipart4408148 );
                 activePlayer =0;
                 TextView status = findViewById( R.id.textView2);
                 status.setText( "X's turn Tap to PLAY");
             }
             img.animate().translationYBy( 1000f ).setDuration( 300 );
         }
         for(int[] winPosition: winPosition){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]] && gameState[winPosition[0]]!=2){
                //condition ensures that someone has won the game
                String winnerStr;
                gameActive = false;
                if(gameState[winPosition[0]] == 0){
                    winnerStr = "X won!!";
                }else{
                    winnerStr = "O won!!";
                }
                //updating the status bar to show the winner name
                TextView status = findViewById( R.id.textView2);
                status.setText(winnerStr);
            }
         }
       }

    private void reset(View view) {
        TextView status = findViewById( R.id.textView2);
        status.setText( "Tap To Reset");
         gameActive = true;
         activePlayer = 0;
         for(int i = 0; i<gameState.length; i++){
             gameState[i] = 2;
         }
        ((ImageView)findViewById( R.id.imageView0 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView1 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView2 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView3 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView4 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView5 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView6 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView7 )).setImageResource( 0 );
        ((ImageView)findViewById( R.id.imageView8 )).setImageResource( 0 );


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
}