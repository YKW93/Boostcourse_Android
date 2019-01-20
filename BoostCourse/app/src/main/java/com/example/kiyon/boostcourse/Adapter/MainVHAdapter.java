package com.example.kiyon.boostcourse.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiyon.boostcourse.Adapter.Contract.MainVHAdapterContract;
import com.example.kiyon.boostcourse.R;
import com.example.kiyon.boostcourse.View.DetailActivity;
import com.example.kiyon.boostcourse.model.MovieData;

import java.util.ArrayList;

public class MainVHAdapter extends PagerAdapter implements MainVHAdapterContract.Model, MainVHAdapterContract.View {

    private ArrayList<MovieData> movieDataArrayList;
    private Context mContext;

    public MainVHAdapter(Context context) {
        this.mContext = context;
        movieDataArrayList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movieDataArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_viewpager_movie, container, false);

        ImageView movie_image = view.findViewById(R.id.movie_imageIV);
        TextView movie_title = view.findViewById(R.id.movie_nameTV);
        Button detail_btn = view.findViewById(R.id.detailBtn);

        movie_image.setImageResource(movieDataArrayList.get(position).image);
        movie_title.setText(movieDataArrayList.get(position).name);

        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                mContext.startActivity(intent);
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItem(ArrayList<MovieData> movieDataArrayList) {
        this.movieDataArrayList.clear();
        this.movieDataArrayList.addAll(movieDataArrayList);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
