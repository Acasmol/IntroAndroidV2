package com.acasmol.introandroidv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button);

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
//              if(textView1.getText().equals(R.string.textView))
                if(textView1.getText().equals("Hello World!!"))
                {
                    textView1.setText(R.string.button2Pressed);
                }
                else
                {
                    textView1.setText(R.string.textView);
                }
            }
        });

    }
}
