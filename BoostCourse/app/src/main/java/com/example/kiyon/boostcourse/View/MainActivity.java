package com.example.kiyon.boostcourse.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.kiyon.boostcourse.Adapter.MainVHAdapter;
import com.example.kiyon.boostcourse.Contract.MainContract;
import com.example.kiyon.boostcourse.Presenter.MainPresenter;
import com.example.kiyon.boostcourse.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter();
        presenter.attachView(MainActivity.this);

        InitView();
    }

    private void InitView() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("영화 목록");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setClipToPadding(false); //자식들 패당값 무시 (양쪽 미리보기 위한 선언)
        viewPager.setPadding(80, 0, 80, 0); // 뷰 양쪽 패딩값을 줌으로써 미리보기 가능
        MainVHAdapter mainVHAdapter = new MainVHAdapter(this);
        presenter.setMainAdapterModel(mainVHAdapter);
        presenter.setMainAdapterView(mainVHAdapter);
        viewPager.setAdapter(mainVHAdapter);

        presenter.setMovieDataList(); // 어뎁터에 데이터 셋팅

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
