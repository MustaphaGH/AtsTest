package com.example.mustapha.atstest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mustapha.atstest.R;
import com.example.mustapha.atstest.model.Product;
import com.example.mustapha.atstest.ui.ProductDetail;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.nio.file.attribute.PosixFileAttributes;
import java.util.List;

/**
 * Created by mustapha on 12/12/17.
 */

public class ProductListAdapter extends ArrayAdapter<Product> {


    public Context context;
    public  int resource;
    public List<Product> dataItems;

    ViewHolder holder;

    public ProductListAdapter(Context context, int resource, List<Product> objects){



        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.dataItems = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);




        if (convertView == null) {
            convertView = li.inflate(resource, null);
            holder = new ViewHolder();

            holder.productName = (TextView)convertView.findViewById(R.id.productName);
            holder.productImage = (CircularImageView)convertView.findViewById(R.id.productImageCiruclar);
            holder.basePrice = (TextView)convertView.findViewById(R.id.productPrice);

            holder.category = (TextView)convertView.findViewById(R.id.productCategory);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.productName.setText(dataItems.get(position).getProductName());
        holder.basePrice.setText(dataItems.get(position).getBasePrice());
        holder.category.setText(dataItems.get(position).getCategory());

        Glide.with(context).load(dataItems.get(position).getImageUrl()).into(holder.productImage);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductDetail.startProductDetailActivity(context,dataItems.get(position));
            }
        });

        return convertView;

    }


    public static class ViewHolder{

        public TextView productName,basePrice,category;
        public CircularImageView productImage;


    }

    @Override
    public void clear() {
        super.clear();
    }








}
