package com.acasmol.introandroidv2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * This class is an Adapter for the Recycler View of the Third Activity com.acasmol.introandroidv2.ThirdActivity
 * We can said that this is the driver for the RecyclerView
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>
{
    List<Item> listItems;
    private Context context; //The context represents the current app
    private OnItemClickListener listener;

    public RecyclerViewAdapter(List<Item> listItems, Context context)
    {
        this.listItems = listItems;
        this.context = context;
    }

    /**
     * Creates the View that will show each element of the
     * RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //An inflater is an object that could create a Layout from the code
        LayoutInflater inflater = LayoutInflater.from(context);
        //Instantiates the View object that will represent the holder, which will be each one of the elements of the list
        //The View will take the layout of item_layout
        View itemView = inflater.inflate(R.layout.item_layout, parent, false);

        final CustomViewHolder viewHolder = new CustomViewHolder(itemView);

 /*       itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position = viewHolder.getAdapterPosition();
                if(listener != null)
                {
                    listener.onItemClick(listItems.get(position));
                }
            }
        });*/

        return viewHolder;
    }

    /**
     * Takes an object of com.acasmol.introandroidv2.Item and get the info from it to show its information
     * @param holder The view that will show the com.acasmol.introandroidv2.Item  object info
     * @param position The postion of the list
     */
    @Override //Takes the data object and display its values
    public void onBindViewHolder(RecyclerViewAdapter.CustomViewHolder holder, int position)
    {
        Item item = listItems.get(position);
        holder.itemNumber.setText(item.getItemId().toString());
        holder.itemTitle.setText(item.getItemTitle());
        holder.itemDescription.setText(item.getItemDescription());
    }
    @Override
    public int getItemCount()
    {
        return listItems.size();
    }


    /**
     * This class represents each one of the elements of the RecyclerView
     *
     */
    public static class CustomViewHolder extends RecyclerView.ViewHolder
    {
        private TextView itemNumber = null;
        private TextView itemTitle = null;
        private TextView  itemDescription = null;

        public CustomViewHolder(View itemView)
        {
            super(itemView);
            itemNumber = (TextView)itemView.findViewById(R.id.itemId);
            itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
            itemDescription = (TextView)itemView.findViewById(R.id.itemDescriotion);
        }
    }

    public interface OnItemClickListener
    {
        public void onItemClick(Item item);
    }

    public void setOnItemListener(OnItemClickListener _listener)
    {
        listener = _listener;
    }
}
