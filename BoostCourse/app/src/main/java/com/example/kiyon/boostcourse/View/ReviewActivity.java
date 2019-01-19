package com.example.kiyon.boostcourse.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.kiyon.boostcourse.Contract.ReviewContract;
import com.example.kiyon.boostcourse.Presenter.ReviewPresenter;
import com.example.kiyon.boostcourse.R;
import com.example.kiyon.boostcourse.model.ReviewData;

public class ReviewActivity extends AppCompatActivity implements ReviewContract.View {

    public static final String REVIEW_DATA = "REVIEW_DATA";
    private ReviewPresenter presenter;
    private RatingBar ratingBar;
    private EditText reviewEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        InitView();
    }

    private void InitView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("한줄평 작성");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        presenter = new ReviewPresenter();
        presenter.attachView(ReviewActivity.this);

        Button ok_Btn = findViewById(R.id.saveBtn);
        Button cancel_Btn = findViewById(R.id.cancelBtn);

        ok_Btn.setOnClickListener(onClickListener);
        cancel_Btn.setOnClickListener(onClickListener);

        ratingBar = findViewById(R.id.ratingbar);
        reviewEdit = findViewById(R.id.reviewEdit);


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.saveBtn :
                    if (reviewEdit.getText().toString().isEmpty()) {
                        Toast.makeText(ReviewActivity.this, "후기를 입력해주세요.", Toast.LENGTH_LONG).show();
                    } else {
                        ReviewData reviewData = presenter.saveReviewData(ratingBar.getRating(), reviewEdit.getText().toString());

                        Intent intent = new Intent();
                        intent.putExtra("REVIEW_DATA", reviewData);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    break;
                case R.id.cancelBtn :
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
