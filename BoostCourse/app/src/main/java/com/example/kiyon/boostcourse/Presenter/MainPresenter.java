package com.example.kiyon.boostcourse.Presenter;

import com.example.kiyon.boostcourse.Contract.MainContract;
import com.example.kiyon.boostcourse.Adapter.Contract.MainReviewListRVAdapterContract;
import com.example.kiyon.boostcourse.model.CountData;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;
    private CountData countData;
    private ArrayList<ReviewData> reviewDataArrayList;
    private MainReviewListRVAdapterContract.Model adapterModel;
    private MainReviewListRVAdapterContract.View adapterView;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
        reviewDataArrayList = new ArrayList<>();
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setCountData(CountData countData) {
        this.countData = countData;
    }


    @Override
    public void upCount(boolean isClicked) {
        if (isClicked) {
            countData.upCount++;
            if (view.getViewType(2)) {
                view.changeUpDownView(1);
            }
        } else {
            countData.upCount--;
        }

        view.setUpDownCountView(countData);
    }

    @Override
    public void downCount(boolean isClicked) {
        if (isClicked) {
            countData.downCount++;
            if (view.getViewType(1)) {
                view.changeUpDownView(2);
            }
        } else {
            countData.downCount--;
        }

        view.setUpDownCountView(countData);
    }

    @Override
    public void loadReviewData(ReviewData reviewData) {
        reviewDataArrayList.add(reviewData);
        adapterModel.addItems(reviewDataArrayList);
        adapterView.notifyAdapter();
    }

    @Override
    public void setMainAdapterModel(MainReviewListRVAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setMainAdapterView(MainReviewListRVAdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }

}
