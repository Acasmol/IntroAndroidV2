package com.acasmol.introandroidv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The second activity, also should be registered in the AndroidManifest.xml file, but in this case
 * special or extra tags are not required
 */
public class SecondActivity extends AppCompatActivity
{
    private Intent goBackIntent;
    //Used for logging purposes
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.e(TAG, "onCreate: Activity Creating");

        final EditText textView2 = (EditText)findViewById(R.id.textView2);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Verifying that the user has written something
                if(textView2.getText().toString() != null
                    && !textView2.getText().toString().isEmpty())
                {
                    goBackIntent = new Intent();
                    //Set param into the Intent object, in this case, the text of the TextView object
                    goBackIntent.putExtra("Name", textView2.getText().toString());
                    setResult(RESULT_OK, goBackIntent);
                    //Finish this activity
                    finish();
                }
                else
                {
                    Toast.makeText(SecondActivity.this,"Name is null or empty", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /**Follows
     * are the fall back methdos indicating the status of the activity
     */

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(TAG, "onStart: Activity Starting");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.e(TAG, "onStop: Activty Stopping");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.e(TAG, "onDestroy: Activity Destroying");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.e(TAG, "onPause: Activity Pause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.e(TAG, "onResume: Activity Resume");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.e(TAG, "onRestart: Activity Restarting");
    }
}
