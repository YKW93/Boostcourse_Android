package com.example.kiyon.boostcourse.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.kiyon.boostcourse.Adapter.Contract.MainReviewListRVAdapterContract;
import com.example.kiyon.boostcourse.R;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public class MainReviewListRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements MainReviewListRVAdapterContract.Model, MainReviewListRVAdapterContract.View {

    private ArrayList<ReviewData> reviewData;
    private Context mContext;

    public MainReviewListRVAdapter(Context context) {
        mContext = context;
        reviewData = new ArrayList<>();
    }

    private class MainReviewListVH extends RecyclerView.ViewHolder {

        private RatingBar ratingBar;
        private TextView reviewTV;

        public MainReviewListVH(View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.ratingbar);
            reviewTV = itemView.findViewById(R.id.reviewTV);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainReviewListVH(LayoutInflater.from(mContext).inflate(R.layout.item_reivew, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MainReviewListVH viewholder = (MainReviewListVH) holder;
        viewholder.ratingBar.setRating((float) reviewData.get(position).star);
        viewholder.reviewTV.setText(reviewData.get(position).review);
    }

    @Override
    public int getItemCount() {
        return reviewData.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(ArrayList<ReviewData> items) {
        this.reviewData.clear();
        this.reviewData.addAll(items);
    }

}
