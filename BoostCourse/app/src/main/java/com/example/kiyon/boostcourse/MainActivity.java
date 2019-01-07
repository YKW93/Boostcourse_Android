package com.example.kiyon.boostcourse;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.kiyon.boostcourse.Contract.MainContract;
import com.example.kiyon.boostcourse.Presenter.MainPresenter;
import com.example.kiyon.boostcourse.databinding.ActivityMainBinding;
import com.example.kiyon.boostcourse.model.CountData;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ActivityMainBinding binding;
    private MainContract.Presenter presenter;
    private Boolean isChecked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        presenter = new MainPresenter();
        presenter.attachView(this);

        InitView();
        addReivewLayout();
    }

    private void InitView() {

        binding.toolbar.setTitle("씨네마천국");
        binding.toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(binding.toolbar);

        CountData countData = new CountData(16, 20);

        binding.upCount.setText(String.valueOf(countData.upCount));
        binding.downCount.setText(String.valueOf(countData.downCount));

        presenter.setCountData(countData);

        binding.upIBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                presenter.upCount(b);
            }
        });

        binding.downIBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                presenter.downCount(b);
            }
        });

        binding.allViewBtn.setOnClickListener(onClickListener);
        binding.createReivewLayout.setOnClickListener(onClickListener);

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.allView_Btn :
                    Toast.makeText(MainActivity.this, "전체 보기 클릭" , Toast.LENGTH_LONG).show();
                    break;
                case R.id.createReivew_layout :
                    Toast.makeText(MainActivity.this, "작성 하기 클릭" , Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    private void addReivewLayout() {

            View view = LayoutInflater.from(this).inflate(R.layout.item_reivew, null);
            View view1 = LayoutInflater.from(this).inflate(R.layout.item_reivew, null);
            binding.containerLayout.addView(view);
            binding.containerLayout.addView(view1);

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
            binding.upIBtn.setChecked(true);
            binding.downIBtn.setChecked(false);
        } else {
            binding.upIBtn.setChecked(false);
            binding.downIBtn.setChecked(true);
        }
    }

    @Override
    public void setUpDownCountView(CountData countData) {
        binding.upCount.setText(String.valueOf(countData.upCount));
        binding.downCount.setText(String.valueOf(countData.downCount));
    }

    @Override
    public boolean getViewType(int type) {
        // type : 1 좋아요 상태 & type : 2 싫어요 상태
        if (type == 1) {
            return binding.upIBtn.isChecked();
        } else {
            return binding.downIBtn.isChecked();
        }
    }
}
