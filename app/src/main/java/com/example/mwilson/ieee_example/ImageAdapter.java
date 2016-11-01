package com.example.mwilson.ieee_example;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mwilson on 10/21/16.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return mThumbIds[position];
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(220, 220));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(1, 40, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public void switchViews(int oldPosition, int newPosition) {
        mThumbIds[newPosition] = mThumbIds[oldPosition];
        mThumbIds[oldPosition] = 0;
    }

    public void shufflePuzzle() {

        List<Integer> itemsToShuffle = new ArrayList<>();
        for (int i = 0; i < mThumbIds.length; i++) {
            itemsToShuffle.add(mThumbIds[i]);
        }

        Collections.shuffle(itemsToShuffle);

        for (int i = 0; i < itemsToShuffle.size(); i++) {
            mThumbIds[i] = itemsToShuffle.get(i);
        }
    }

    public boolean isWin() {
        if (mThumbIds[0] == R.drawable.block1 &&
                mThumbIds[1] == R.drawable.block2 && mThumbIds[2] == R.drawable.block3 &&
                mThumbIds[3] == R.drawable.block4 && mThumbIds[4] == R.drawable.block5 &&
                mThumbIds[5] == R.drawable.block6 && mThumbIds[6] == R.drawable.block7 &&
                mThumbIds[7] == R.drawable.block8 && mThumbIds[8] == R.drawable.block9 &&
                mThumbIds[9] == R.drawable.block10 && mThumbIds[10] == R.drawable.block11 &&
                mThumbIds[11] == R.drawable.block12 && mThumbIds[12] == R.drawable.block13 &&
                mThumbIds[13] == R.drawable.block14 && mThumbIds[14] == R.drawable.block15 &&
                mThumbIds[15] == 0) {
            return true;
        }
        return false;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.block1, R.drawable.block2,
            R.drawable.block3, R.drawable.block4,
            R.drawable.block5, R.drawable.block6,
            R.drawable.block7, R.drawable.block8,
            R.drawable.block9, R.drawable.block10,
            R.drawable.block11, R.drawable.block12,
            R.drawable.block13, R.drawable.block14,
            R.drawable.block15, 0
    };

}
