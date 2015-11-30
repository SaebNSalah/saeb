package com.example.al_zeer_saeb.xogame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

    boolean turn = true; // true = X & false = O
    int turn_count = 0;
    Button[] bArray = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;
    Button ttt ,ag;
    int cc=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttt = (Button) findViewById(R.id.tt1) ;
        ag = (Button) findViewById(R.id.again) ;
        a1 = (Button) findViewById(R.id.A1);
        b1 = (Button) findViewById(R.id.B1);
        c1 = (Button) findViewById(R.id.C1);
        a2 = (Button) findViewById(R.id.A2);
        b2 = (Button) findViewById(R.id.B2);
        c2 = (Button) findViewById(R.id.C2);
        a3 = (Button) findViewById(R.id.A3);
        b3 = (Button) findViewById(R.id.B3);
        c3 = (Button) findViewById(R.id.C3);
        bArray = new Button[]{a1, a2, a3, b1, b2, b3, c1, c2, c3 ,ag};

        for (Button b : bArray)
            b.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        buttonClicked(v);
    }

    private void buttonClicked(View v) {
        Button b = (Button) v;
        if (b.getText() == "Play again")
        {
            a1.setText("");
            a2.setText("");
            a3.setText("");
            b1.setText("");
            b2.setText("");
            b3.setText("");
            c1.setText("");
            c2.setText("");
            c3.setText("");
            a1.setClickable(true);
            a2.setClickable(true);
            a3.setClickable(true);
            b1.setClickable(true);
            b2.setClickable(true);
            b3.setClickable(true);
            c1.setClickable(true);
            c2.setClickable(true);
            c3.setClickable(true);
            a1.setBackgroundColor(Color.RED);
            a2.setBackgroundColor(Color.RED);
            a3.setBackgroundColor(Color.RED);
            b1.setBackgroundColor(Color.RED);
            b2.setBackgroundColor(Color.RED);
            b3.setBackgroundColor(Color.RED);
            c1.setBackgroundColor(Color.RED);
            c2.setBackgroundColor(Color.RED);
            c3.setBackgroundColor(Color.RED);
            turn = true;
        }else
        if (turn) {
// X's turn
            b.setText("X");

        } else {
// O's turn
            b.setText("O");
        }
        turn_count++;
        b.setClickable(false);
        b.setBackgroundColor(Color.GRAY);
        turn = !turn;

        checkForWinner();
    }

    private void checkForWinner() {


        boolean there_is_a_winner = false;

// horizontal:
        if ((a1.getText() == a2.getText() && a2.getText() == a3.getText()
                && !a1.isClickable() )|| (b1.getText() == b2.getText() && b2.getText() == b3.getText()
                && !b1.isClickable() )|| (c1.getText() == c2.getText() && c2.getText() == c3.getText()
                && !c1.isClickable()))

            there_is_a_winner = true;
// vertical:
        else if ((a1.getText() == b1.getText() && b1.getText() == c1.getText()
                && !a1.isClickable())||(a2.getText() == b2.getText() && b2.getText() == c2.getText()
                && !b2.isClickable())||(a3.getText() == b3.getText() && b3.getText() == c3.getText()
                && !c3.isClickable()))
            there_is_a_winner = true;


// diagonal:
        else if ((a1.getText() == b2.getText() && b2.getText() == c3.getText()
                && !c3.isClickable()) ||(a3.getText() == b2.getText() && b2.getText() == c1.getText()
                && !b2.isClickable()))
            there_is_a_winner = true;


        if (there_is_a_winner) {
            if (!turn)
            {   message("X wins"); cc=cc+1;}
            else
            {   message("O wins"); cc=cc-1;}
            ttt.setText(cc);


        } else if (turn_count == 9 &&there_is_a_winner==false )
            message("NO Winner!");

    }

    private void message(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }
}
