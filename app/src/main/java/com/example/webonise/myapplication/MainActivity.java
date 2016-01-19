package com.example.webonise.myapplication;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeFlingAdapterView view = (SwipeFlingAdapterView) findViewById(R.id.frame);

        final TypedArray typedArray = getResources().obtainTypedArray(R.array.images);
        final ArrayList<Integer> images = new ArrayList<>();
        for (int i = 0; i < typedArray.length(); i++) {
            images.add(typedArray.getResourceId(i, -1));
        }

        final SwipeFlingAdapter adapter = new SwipeFlingAdapter(this, images);

        view.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                images.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {
                Log.d("@@", "" + v);
            }
        });
        view.setAdapter(adapter);
    }
}
