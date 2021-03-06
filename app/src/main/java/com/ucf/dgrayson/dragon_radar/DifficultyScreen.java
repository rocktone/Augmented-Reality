package com.ucf.dgrayson.dragon_radar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

/**
 * Created by jorge_000 on 11/24/2015.
 */
public class DifficultyScreen extends Activity implements View.OnClickListener{

    AlertDialog.Builder alert;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficultylayout);

        alert  = new AlertDialog.Builder(this);

        mp = MediaPlayer.create(this, R.raw.dragonball_radar);

        // Set onclick listeners for buttons
        findViewById(R.id.easybutton).setOnClickListener(this);
        findViewById(R.id.mediumbutton).setOnClickListener(this);
        findViewById(R.id.hardbutton).setOnClickListener(this);
    }


    // Move to previous activity
    public void back(View view) {
        mp.start();
        setResult(RESULT_OK);
        finish();
    }

    // On click function
    @Override
    public void onClick(View v) {
        // play button sound
        mp.start();

        // Get the string containing the difficulty
        String diff = DataHolder.getData();

        // Change difficulty to the difficulty selected
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

        // Send string back to data holder object
        DataHolder.setData(diff);
    }
}
