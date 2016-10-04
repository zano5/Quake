package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ProJava on 8/25/2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private int resources;
    private ArrayList<Earthquake> earthquakes;
    private LayoutInflater inflater;

    public EarthquakeAdapter(Context context, int resource, List<Earthquake> objects) {
        super(context, resource, objects);

        earthquakes = (ArrayList<Earthquake>) objects;
        this.resources = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PlaceHolder holder;
        View view = null;

        if(convertView == null)
        {
            holder = new PlaceHolder();
            view = inflater.inflate(this.resources,parent,false);
            holder.tvCity = (TextView) view.findViewById(R.id.tvCity);
            holder.tvDate = (TextView) view.findViewById(R.id.tvDate);
            holder.tvMag = (TextView)  view.findViewById(R.id.tvMagnitude);
            holder.tvTime = (TextView) view.findViewById(R.id.tvTime);
            holder.tvLocation = (TextView) view.findViewById(R.id.tvLocation);

            view.setTag(holder);

        }else
        {

            view = convertView;
            holder = (PlaceHolder) view.getTag();
        }

        Earthquake quake = earthquakes.get(position);

        holder.tvMag.setText("" +quake.getMag());


        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
       // String dateToDisplay = dateFormat.format(quake.getDate());
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
//        String timeToDisplay = timeFormat.format(quake.getTime());


        holder.tvDate.setText(quake.getDate());

        if(quake.getCity().contains("of"))
        {
            String[] token = quake.getCity().split("of");
            for(int x =0; x<token.length; x++)
            {
                holder.tvLocation.setText(token[0] +" of");
                holder.tvCity.setText(token[1]);
            }
        }else{
            holder.tvCity.setText(quake.getCity());
        }







        holder.tvTime.setText(quake.getTime());

        GradientDrawable magnitudeCircle = (GradientDrawable) holder.tvMag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
       int magnitudeColor = getMagnitudeColor(quake.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return view;
    }

    private int getMagnitudeColor(double mag) {

       int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);

        int magnitudeFloor = (int) Math.floor(mag);

        switch (magnitudeFloor)
        {
            case 0 :

            case 1:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);

                break;

            case 2:


                 magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude2);

                break;

            case 3:

                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;

            case 4:

                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;

            case 5:

                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;

            case 6:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude6);

                break;

            case 7:
                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;

            case 8:

                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;

            case 9:

                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude9);

                break;

            default:

                magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            break;


        }


        return  magnitude1Color;
    }

    private class PlaceHolder
    {

        private TextView tvMag, tvCity,tvDate,tvTime,tvLocation;

    }
}
