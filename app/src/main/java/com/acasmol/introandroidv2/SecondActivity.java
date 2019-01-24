package com.acasmol.introandroidv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity
{
    private Intent goBackIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final EditText textView2 = (EditText)findViewById(R.id.textView2);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(textView2.getText().toString() != null
                    && !textView2.getText().toString().isEmpty())
                {
                    goBackIntent = new Intent();
                    goBackIntent.putExtra("Name", textView2.getText().toString());
                    setResult(RESULT_OK, goBackIntent);
                    finish();
                }
                else
                {
                    Toast.makeText(SecondActivity.this,"Name is null or empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
