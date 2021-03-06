package com.example.yueyingwu.drucker_app;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    static String username="";

//    public void toMsgBox(View view){
//        Intent msgIntent  = new Intent(getApplicationContext(),MessageBoxActivity.class);
//        startActivity(msgIntent);
//    }
//    public void toPracticePage(View v){
//        Intent pracPageIntent = new Intent(getApplicationContext(),PracticeActivity.class);
//        startActivity(pracPageIntent);
//    }
//    public void toTraining(View v){
//        Intent trainPageIntent = new Intent(getApplicationContext(),TrainingActivity.class);
//        startActivity(trainPageIntent);
//    }
//    public void toDes(View v){
//        Intent DesPageIntent = new Intent(getApplicationContext(),DesicionActivity.class);
//        startActivity(DesPageIntent);
//    }
    public void toLogout(View v){
        Intent logoutIntent = new Intent(getApplicationContext(),loginActivity.class);
        startActivity(logoutIntent);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) { //do something
            Intent UserbackToLoginUI = new Intent(getApplicationContext(), loginActivity.class);
            UserActivity.this.startActivity(UserbackToLoginUI);
        }
//        } else if (keyCode == KeyEvent.KEYCODE_MENU) {//do something
//        } else if (keyCode == KeyEvent.KEYCODE_HOME) {//no return result
//        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final TextView etUsername = findViewById(R.id.etUsername);
        etUsername.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        etUsername.getPaint().setAntiAlias(true);
        final TextView etAge = findViewById(R.id.etAge);
        etAge.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        etAge.getPaint().setAntiAlias(true);
        final TextView welcomeMessage = findViewById(R.id.tvWelcomeMsg);
        // create variables for each button
        final ImageButton bMessageBox = findViewById(R.id.iBforum);
        final ImageButton bPracticeGuide = findViewById(R.id.iBUserGuide);
        final ImageButton bTaining = findViewById(R.id.iBTraining);
        final ImageButton bDecision = findViewById(R.id.iBDecicion);
        final Button bLogout = findViewById(R.id.bLogout);

        bMessageBox.setScaleType(ImageButton.ScaleType.FIT_XY);
        bMessageBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent(getApplicationContext(), MessageBoxActivity.class);
                startActivity(msgIntent);
            }
        });

        bPracticeGuide.setScaleType(ImageButton.ScaleType.FIT_XY);
        bPracticeGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent practIntent = new Intent(getApplicationContext(), PracticeActivity.class);
                startActivity(practIntent);
            }
        });

        bTaining.setScaleType(ImageButton.ScaleType.FIT_XY);
        bTaining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainPageIntent = new Intent(getApplicationContext(),TrainingActivity.class);
                startActivity(trainPageIntent);
            }
        });

        bDecision.setScaleType(ImageButton.ScaleType.FIT_XY);
        bDecision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DesPageIntent = new Intent(getApplicationContext(),DesicionActivity.class);
                startActivity(DesPageIntent);
            }
        });

	/*	bMessageBox.setOnClickListener(new View.onClickListener() {

			public void onClick(View v){
				Intent msgIntent  = new Intent(getApplicationContext(),MessageBoxActivity.class);
				startActivity(msgIntent);
 
			}		
		});
		
		bPracticeGuide.setOnClickListener(new View.onClickListener(){

			public void onClick(View v){
				Intent pracPageIntent = new Intent(getApplicationContext(),PracticeActivity.class);
				startActivity(pracPageIntent);
			}			
		});*/

        Intent intent=getIntent();
//        String name=intent.getStringExtra("name");
        username=intent.getStringExtra("username");
        //int age =intent.getIntExtra("age",20);

        String message="Welcome!";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etAge.setText("Manager");
        //etAge.setText(age+"");
//        etAge.setText("Property Manager");


    }
}
