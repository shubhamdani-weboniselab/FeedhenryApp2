package com.example.webonise.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


public class SwipeFlingAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> typedArray;
    private ImageView imageLiked;
    private ImageView imageDisLiked;


    public SwipeFlingAdapter(Context context, ArrayList<Integer> typedArray) {
        this.context = context;
        this.typedArray = typedArray;
    }

    @Override
    public int getCount() {
        return typedArray.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageLiked = (ImageView) convertView.findViewById(R.id.imgLiked);
            imageDisLiked = (ImageView) convertView.findViewById(R.id.imgDisLiked);
            imageView.setImageDrawable(context.getResources().getDrawable(typedArray.get(position)));
        }
        return convertView;
    }


}
