package com.example.yueyingwu.drucker_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DesicionActivity extends AppCompatActivity {


    //    public void toQuestionMark(View v) {
//        Intent questionMarkIntent = new Intent(getApplicationContext(), TrainLightActivity.class);
//        startActivity(questionMarkIntent);
//    }
//    public void toBulbInput(View v) {
//        Intent bulbInputIntent = new Intent(getApplicationContext(), BulbInputActivity.class);
//        startActivity(bulbInputIntent);
//    }
//
//    public void toPlumbingInput(View v) {
//        Intent plumbingInputIntent = new Intent(getApplicationContext(), PlumbingInputActivity.class);
//        startActivity(plumbingInputIntent);
//    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { //do something
            Intent DesicionbackToUserUI = new Intent(getApplicationContext(), UserActivity.class);
            DesicionbackToUserUI.putExtra("username",UserActivity.username);
            DesicionActivity.this.startActivity(DesicionbackToUserUI);
        }
//        } else if (keyCode == KeyEvent.KEYCODE_MENU) {//do something
//        } else if (keyCode == KeyEvent.KEYCODE_HOME) {//no return result
//        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desicion);
        final TextView tvLight = findViewById(R.id.tVLightBUlb);
        final TextView tvPlumb = findViewById(R.id.tVPlumbing);
        final ImageButton iBLight = findViewById(R.id.iBBulb);
        final ImageButton iBPlumb = findViewById(R.id.iBPlumb);

        iBLight.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bulbInputIntent = new Intent(getApplicationContext(), BulbInputActivity.class);
                startActivity(bulbInputIntent);
            }
        });
        iBPlumb.setScaleType(ImageButton.ScaleType.FIT_XY);
        iBPlumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plumbingInputIntent = new Intent(getApplicationContext(), PlumbingInputActivity.class);
                startActivity(plumbingInputIntent);
            }
        });

//        final Button bQuestionMark = findViewById(R.id.bQuestionMark);
//        final Button bBulb = findViewById(R.id.bBulb);
//        final Button bPlumbing = findViewById(R.id.bPlumbing);
    }
}
