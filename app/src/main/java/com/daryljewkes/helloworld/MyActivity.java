package com.daryljewkes.helloworld;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity {

    //private Button myButton;
    //private Integer clickCount = 0;
    //private TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        txtOutput = (TextView) findViewById(R.id.dynamicText);

        //final TextView firstTextView = (TextView) findViewById(R.id.textView);
//        Button myButton = (Button) findViewById(R.id.clickButton);
//
//        myButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                firstTextView.setText("You clicked Me!");
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_about) {
            DialogFragment myFragment = new MyDialogFragment();
            myFragment.show(getFragmentManager(), "theDialog");
            return true;
        } else if (id == R.id.action_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMyButtonClick(View view) {

//        Intent getNameScreenIntent = new Intent(this, SecondScreen.class);

        final int result = 1;
//        getNameScreenIntent.putExtra("callingActivity", "MainActivity");


        Human bob = new Human(6.25, 185, "Bob");
        Intent sendBob = new Intent(this, SecondScreen.class);

        sendBob.putExtra("humanBob", bob);

        startActivityForResult(sendBob, result);
        //startActivityForResult(getNameScreenIntent, result); //expect data to come back
        //startActivity(getNameScreenIntent); //send data one way


        //older tutorial stuff

//
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView usersNameMessage = (TextView) findViewById(R.id.dynamicText);

        String nameSentBack = data.getStringExtra("UsersName");
        usersNameMessage.append(" " + nameSentBack);
    }
}
