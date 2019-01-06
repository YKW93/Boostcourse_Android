package com.example.kiyon.boostcourse;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
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
