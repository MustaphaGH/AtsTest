package com.example.mustapha.atstest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mustapha.atstest.R;
import com.example.mustapha.atstest.model.Product;
import com.example.mustapha.atstest.model.Review;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

/**
 * Created by mustapha on 12/12/17.
 */

public class ReviewListAdapter extends ArrayAdapter<Review> {


    public Context context;
    public  int resource;
    public List<Review> dataItems;

    ReviewListAdapter.ViewHolder holder;

    public ReviewListAdapter(Context context, int resource, List<Review> objects){



        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.dataItems = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);




        if (convertView == null) {
            convertView = li.inflate(resource, null);
            holder = new ReviewListAdapter.ViewHolder();

            holder.rating = (TextView)convertView.findViewById(R.id.ratingAmount);
            holder.content = (TextView)convertView.findViewById(R.id.reviewContent);



            convertView.setTag(holder);
        }
        else {
            holder = (ReviewListAdapter.ViewHolder) convertView.getTag();
        }


        holder.content.setText(dataItems.get(position).getReviewContent());
        holder.rating.setText(dataItems.get(position).getRatingAmount().toString());

        return convertView;

    }


    public static class ViewHolder{

        public TextView content,rating;


    }

    @Override
    public void clear() {
        super.clear();
    }








}
