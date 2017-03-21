package com.yust.ariel.recycleviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yust.ariel.recycleviewtest.WebApi.WebApiDailyForecast;
import com.yust.ariel.recycleviewtest.WebApi.WebApiWeather;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ariel Yust on 05-Mar-17.
 */

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<WebApiWeather> mForecast;
    // Store the context for easy access
    private Context mContext;

    public void setForecast(@NonNull List<WebApiWeather> forecast){
        mForecast = forecast;
        notifyDataSetChanged();
    }

    // Pass in the contact array into the constructor
    public ForecastAdapter(@NonNull Context context) {
        mForecast = new ArrayList<>();
    }

    public ForecastAdapter(@NonNull Context context, List<WebApiWeather> forecast) {
        mForecast = forecast;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_forecast, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get the data model based on position
        WebApiWeather weather = mForecast.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        Date d = new Date();
        d.setTime(weather.getDt());
        textView.setText(d.toString());

        Button button = holder.messageButton;
        button.setText("Rain: " + weather.getRain());
    }

    @Override
    public int getItemCount() {
        return mForecast.size();
    }

    /**
     * Provide a direct reference to each of the views within a data item
     * Used to cache the views within the item layout for fast access
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /*
         * Your holder should contain a member variable
         * for any view that will be set as you render a row
         */
        public TextView nameTextView;
        public Button messageButton;

        /**
         * We also create a constructor that accepts the entire item row
         * and does the view lookups to find each subview
         *
         * @param itemView
         */
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.date_time);
            messageButton = (Button) itemView.findViewById(R.id.btn_action);
        }
    }
}
