package com.example.kiyon.boostcourse.Presenter;

import com.example.kiyon.boostcourse.Adapter.Contract.ReviewListRVAdapterContract;
import com.example.kiyon.boostcourse.Contract.TotalReviewContract;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public class TotalReviewPresenter implements TotalReviewContract.Presenter {

    private TotalReviewContract.View view;
    private ReviewListRVAdapterContract.Model adapterModel;
    private ReviewListRVAdapterContract.View adapterView;

    @Override
    public void attachView(TotalReviewContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setReviewAdapterMode(ReviewListRVAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setReviewAdapterView(ReviewListRVAdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void loadReviewDataList(ArrayList<ReviewData> reviewDataArrayList) {
        adapterModel.addItems(reviewDataArrayList);
        adapterView.notifyAdapter();
    }
}
