package com.example.kiyon.boostcourse.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.kiyon.boostcourse.Adapter.ReviewListRVAdapter;
import com.example.kiyon.boostcourse.Contract.TotalReviewContract;
import com.example.kiyon.boostcourse.Presenter.TotalReviewPresenter;
import com.example.kiyon.boostcourse.R;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

import static com.example.kiyon.boostcourse.View.ReviewActivity.REVIEW_DATA;

public class TotalReviewActivity extends AppCompatActivity implements TotalReviewContract.View {

    private RecyclerView recyclerView;
    private ReviewListRVAdapter mainReviewListRVAdapter;
    private TotalReviewPresenter presenter;

    public static Intent newIntent(Context context, ArrayList<ReviewData> reviewDataArrayList) {
        Intent intent = new Intent(context, TotalReviewActivity.class);
        intent.putExtra(REVIEW_DATA, reviewDataArrayList);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_review);

        presenter = new TotalReviewPresenter();
        presenter.attachView(this);
        InitView();
    }

    private void InitView() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("한줄평 목록");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_white);

        Intent intent = getIntent();
        ArrayList<ReviewData> reviewDataArrayList = (ArrayList<ReviewData>) intent.getSerializableExtra(REVIEW_DATA);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainReviewListRVAdapter = new ReviewListRVAdapter(this);
        recyclerView.setAdapter(mainReviewListRVAdapter);
        presenter.setReviewAdapterMode(mainReviewListRVAdapter);
        presenter.setReviewAdapterView(mainReviewListRVAdapter);

        presenter.loadReviewDataList(reviewDataArrayList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
