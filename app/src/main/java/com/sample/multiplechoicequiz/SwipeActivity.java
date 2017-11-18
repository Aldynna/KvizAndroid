package com.sample.multiplechoicequiz;

/**
 * Created by Sabina on 23.4.2017.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sabina on 21.4.2017.
 */

public class SwipeActivity extends PagerAdapter {

    public int [] image_resources = {
            R.drawable.slika1,
            R.drawable.slika2,
            R.drawable.slika3,
            R.drawable.slika4
    };

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SwipeActivity(Context c) { mContext = c; }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem (ViewGroup container, int position) {
        mLayoutInflater  = (LayoutInflater) mContext.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
        View item_view = mLayoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView = (TextView) item_view.findViewById(R.id.image_count);
        imageView.setImageResource (image_resources[position]);
        textView.setText("Image " + position);
        container.addView(item_view);

        return item_view;

    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }

}
