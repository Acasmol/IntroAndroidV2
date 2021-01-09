package com.acasmol.introandroidv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the main activity
 * Should be registered in the AndroidManifest.xml file and have the
 * tags "action" and "category"
 */
public class MainActivity extends AppCompatActivity
{
    //An Intent object that uses to drive the Android App thought activities
    public Intent objIntent;
    //This integer will be use to identify the Second Activity
    private static final int SECOND_ACTIVITY_CODE = 0001;
    private static final int THIRD_ACTIVITY_CODE = 0002;
    //Used for logging purposes
    private static final String TAG = "MainActivty";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abstracts the Button from the Layout (R.id) to an object Button
        Button button1 = (Button)findViewById(R.id.button);
        //Register the "OnClickViewListener()"
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Usually you can put "this" as the first parameter
                //but since we are in a inner class, we need to refer
                //explicitly to the Activity owner (the context)
                Toast.makeText(MainActivity.this,"Button 1 pressed", Toast.LENGTH_SHORT).show();
            }
        });

        //Also, the TextView can be abtract from the Layout to a TextView object
        final TextView textView1 = (TextView)findViewById(R.id.textView);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*The R class, doesn't retrieve the values that it keeps.
                 * Retrieve hexadecimal numbers that are tied to the value,
                 * and internally, Android interprets to the value */
                if(textView1.getText().equals(getResources().getString(R.string.textView)))
//                if(textView1.getText().equals("Hello World!!"))
                {
                    textView1.setText(R.string.button2Pressed);
                }
                else
                {
                    textView1.setText(R.string.textView);
                }
            }
        });

        //Function of Button 4 (Since IntroAndroidV2)
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                objIntent = new Intent(MainActivity.this,SecondActivity.class);
                //Should be passed the object intent and the identifies for the activity
                startActivityForResult(objIntent,SECOND_ACTIVITY_CODE);
            }
        });

        //Function of Button 5 (Since IntroAndroidV2)
        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                objIntent = new Intent(MainActivity.this,ThirdActivity.class);
                //Should be passed the object intent and the identifies for the activity
                //In this case we dont pase any activity code because we don want any retrieved data
                startActivity(objIntent);
            }
        });
    }

    /**
     * Fall back method that will be excecuted always when a child activity returns to
     * its parent activity
     * @param requestCode The identifier of the activity that is back from
     * @param resultCode The result code set up by the child activity
     * @param data The Intent object is a K-V collection of objects that could be returned by the child activity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SECOND_ACTIVITY_CODE)
        {
            if(resultCode == RESULT_OK)
            {
//                data.getData().getQueryParameter("Name");
                String name = data.getStringExtra("Name");
                Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
            }
        }
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
