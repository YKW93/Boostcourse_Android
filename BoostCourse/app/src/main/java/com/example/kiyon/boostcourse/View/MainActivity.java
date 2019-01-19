package com.example.kiyon.boostcourse.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kiyon.boostcourse.Adapter.MainReviewListRVAdapter;
import com.example.kiyon.boostcourse.Contract.MainContract;
import com.example.kiyon.boostcourse.Presenter.MainPresenter;
import com.example.kiyon.boostcourse.R;
import com.example.kiyon.boostcourse.model.CountData;
import com.example.kiyon.boostcourse.model.ReviewData;

import static com.example.kiyon.boostcourse.View.ReviewActivity.REVIEW_DATA;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    public static final int REVIEW_CREATE = 1;

    private MainContract.Presenter presenter;

    private TextView up_count;
    private TextView down_count;
    private CheckBox up_Ibtn;
    private CheckBox down_Ibtn;

    private RecyclerView recyclerView;
    private MainReviewListRVAdapter mainReviewListRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.attachView(this);

        InitView();
    }

    private void InitView() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("씨네마천국");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainReviewListRVAdapter = new MainReviewListRVAdapter(this);
        recyclerView.setAdapter(mainReviewListRVAdapter);
        presenter.setMainAdapterModel(mainReviewListRVAdapter);
        presenter.setMainAdapterView(mainReviewListRVAdapter);

        CountData countData = new CountData(16, 20);

        up_count = findViewById(R.id.up_count);
        up_count.setText(String.valueOf(countData.upCount));

        down_count = findViewById(R.id.down_count);
        down_count.setText(String.valueOf(countData.downCount));

        presenter.setCountData(countData);

        up_Ibtn = findViewById(R.id.up_IBtn);
        up_Ibtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                presenter.upCount(b);
            }
        });

        down_Ibtn = findViewById(R.id.down_IBtn);
        down_Ibtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                presenter.downCount(b);
            }
        });


        LinearLayout createReviewLayout = findViewById(R.id.createReivew_layout);
        createReviewLayout.setOnClickListener(onClickListener);

        Button allView_btn = findViewById(R.id.allView_Btn);
        allView_btn.setOnClickListener(onClickListener);


    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.allView_Btn :
                    Intent intent = new Intent(MainActivity.this, TotalReviewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.createReivew_layout :
                    Intent intent1 = new Intent(MainActivity.this, ReviewActivity.class);
                    startActivityForResult(intent1, REVIEW_CREATE);
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REVIEW_CREATE) {
            if (resultCode == RESULT_OK) {
                ReviewData reviewData = (ReviewData) data.getSerializableExtra(REVIEW_DATA);
                presenter.loadReviewData(reviewData);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


    @Override
    public void changeUpDownView(int type) {
        // type : 1  좋아요 클릭 상태 & type : 2 싫어요 클릭 상태
        if (type == 1) {
            up_Ibtn.setChecked(true);
            down_Ibtn.setChecked(false);
        } else {
            up_Ibtn.setChecked(false);
            down_Ibtn.setChecked(true);
        }
    }

    @Override
    public void setUpDownCountView(CountData countData) {
        up_count.setText(String.valueOf(countData.upCount));
        down_count.setText(String.valueOf(countData.downCount));
    }

    @Override
    public boolean getViewType(int type) {
        // type : 1 좋아요 상태 & type : 2 싫어요 상태
        if (type == 1) {
            return up_Ibtn.isChecked();
        } else {
            return down_Ibtn.isChecked();
        }
    }
}
