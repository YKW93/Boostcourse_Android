package com.example.kiyon.boostcourse.Presenter;

import com.example.kiyon.boostcourse.Adapter.Contract.MainVHAdapterContract;
import com.example.kiyon.boostcourse.Contract.MainContract;
import com.example.kiyon.boostcourse.R;
import com.example.kiyon.boostcourse.model.MovieData;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private ArrayList<MovieData> movieDataArrayList;
    private MainVHAdapterContract.View adapterView;
    private MainVHAdapterContract.Model adapterModel;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
        movieDataArrayList = new ArrayList<>();
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setMovieDataList() {
        MovieData movieData1 = new MovieData();
        movieData1.image = R.drawable.image1;
        movieData1.name = "1. 군도";
        movieDataArrayList.add(movieData1);
        MovieData movieData2 = new MovieData();
        movieData2.image = R.drawable.image2;
        movieData2.name = "2. 공조";
        movieDataArrayList.add(movieData2);
        MovieData movieData3 = new MovieData();
        movieData3.image = R.drawable.image3;
        movieData3.name = "3. 더킹";
        movieDataArrayList.add(movieData3);
        MovieData movieData4 = new MovieData();
        movieData4.image = R.drawable.image4;
        movieData4.name = "4. 레지던트이블";
        movieDataArrayList.add(movieData4);
        MovieData movieData5 = new MovieData();
        movieData5.image = R.drawable.image5;
        movieData5.name = "5. 럭키";
        movieDataArrayList.add(movieData5);
        MovieData movieData6 = new MovieData();
        movieData6.image = R.drawable.image6;
        movieData6.name = "6. 아수라";
        movieDataArrayList.add(movieData6);

        adapterModel.addItem(movieDataArrayList);
        adapterView.notifyAdapter();
    }

    @Override
    public void setMainAdapterModel(MainVHAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setMainAdapterView(MainVHAdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }
}
