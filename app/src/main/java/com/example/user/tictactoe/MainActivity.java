package com.example.user.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public int x = 0;
    public int[] visit = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    public int[][] win = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridLayout glayout = (GridLayout) findViewById(R.id.gridLayout);
                LinearLayout layout = (LinearLayout)findViewById(R.id.yourlayout);
                x=0;
                layout.setVisibility(View.INVISIBLE);
                for(int i=0;i<visit.length;i++){
                    visit[i]=2;
                }
                for(int i=0;i<glayout.getChildCount();i++){
                    ((ImageView) glayout.getChildAt(i)).setImageResource(0);
                }
            }
        });

    }

    public void blabla(View view) {

        ImageView counter = (ImageView) view;
        int pos = Integer.parseInt(counter.getTag().toString());
        if (visit[pos] == 2) {
            if (x == 0) {
                counter.setTranslationY(-1000f);
                counter.setImageResource(R.drawable.circle);
                counter.animate().translationYBy(1000f).setDuration(300);
                visit[pos] = x;
                x = 1;

            } else if (x == 1) {

                counter.setTranslationY(-1000f);
                counter.setImageResource(R.drawable.cross);
                counter.animate().translationYBy(1000f).setDuration(300);
                visit[pos] = x;
                x = 0;
            }
        }
        for (int[] winpos : win) {
            if (visit[winpos[0]] == visit[winpos[1]] && visit[winpos[1]] == visit[winpos[2]] && visit[winpos[1]] != 2) {
                TextView text = (TextView) findViewById(R.id.textView);
                LinearLayout layout = (LinearLayout) findViewById(R.id.yourlayout);
                layout.setVisibility(View.VISIBLE);
                if (visit[winpos[0]] == 0) {
                    Toast.makeText(getApplicationContext(), "circle", Toast.LENGTH_SHORT).show();
                    text.setText("Circle Won!");
                } else if (visit[winpos[0]] == 1) {
                    Toast.makeText(getApplicationContext(), "cross", Toast.LENGTH_SHORT).show();
                    text.setText("Cross Won!");

                }
            }
        }
    }
}
