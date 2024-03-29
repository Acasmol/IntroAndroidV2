package com.acasmol.introandroidv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ThirdActivity extends AppCompatActivity
{
    //Used for logging purposes
    private static final String TAG = "ThirdActivity";

    List<Item> itemList = DataProvider.listItems; //Gets the list of the items that  will be shown in the RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.e(TAG, "onCreate: Third Activity Creating");

        /**
         * Sort the collection depending of their ID
         */
       Collections.sort(itemList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getItemId().compareTo(o2.getItemId());
            }
        });

        RecyclerViewAdapter adapter = new RecyclerViewAdapter( itemList, this);
/*        adapter.setOnItemListener(new RecyclerViewAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(Item item)
            {
                Toast.makeText(ThirdActivity.this, "Elemento pulsado: " + item.getItemId() + " " + item.getItemTitle(), Toast.LENGTH_SHORT).show();
            }
        });*/
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewItem);
        recyclerView.setAdapter(adapter);
    }

    /**Follows
     * are the fall back methdos indicating the status of the activity
     */

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(TAG, "onStart: Third Activity Starting");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.e(TAG, "onStop: Third Activity Stopping");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.e(TAG, "onDestroy: Third Activity Destroying");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.e(TAG, "onPause: Third Activity Pause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.e(TAG, "onResume: Third Activity Resume");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.e(TAG, "onRestart: Third Activity Restarting");
    }
}