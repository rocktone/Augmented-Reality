package com.example.dgrayson.maps_test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.dgrayson.maps_test.R;

/**
 * Created by jorge_000 on 11/24/2015.
 */
public class DifficultyScreen extends Activity implements View.OnClickListener{

    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficultylayout);

        alert  = new AlertDialog.Builder(this);


        findViewById(R.id.easybutton).setOnClickListener(this);
        findViewById(R.id.mediumbutton).setOnClickListener(this);
        findViewById(R.id.hardbutton).setOnClickListener(this);
        //findViewById(R.id.backbutton).setOnClickListener(this);
    }

    public void back(View view) {
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onClick(View v) {
        String diff = DataHolder.getData();

        if(v.getId() == R.id.easybutton){
            diff = "easy";
            alert.setMessage("Difficulty set to Easy.");
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }
        else if(v.getId() == R.id.mediumbutton){
            diff = "medium";
            alert.setMessage("Difficulty set to Medium.");
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }
        else if(v.getId() == R.id.hardbutton){
            diff = "hard";
            alert.setMessage("Difficulty set to Hard.");
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }

        DataHolder.setData(diff);
    }
}
