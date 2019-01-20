package com.example.kiyon.boostcourse.Presenter;

import com.example.kiyon.boostcourse.Contract.DetailContract;
import com.example.kiyon.boostcourse.Adapter.Contract.ReviewListRVAdapterContract;
import com.example.kiyon.boostcourse.model.CountData;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public class DetailPresenter implements DetailContract.Presenter{

    private DetailContract.View view;
    private CountData countData;
    private ArrayList<ReviewData> reviewDataArrayList;
    private ReviewListRVAdapterContract.Model adapterModel;
    private ReviewListRVAdapterContract.View adapterView;

    @Override
    public void attachView(DetailContract.View view) {
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
    public ArrayList<ReviewData> getReviewDataList() {
        return reviewDataArrayList;
    }

    @Override
    public void setReviewAdapterModel(ReviewListRVAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setReviewAdapterView(ReviewListRVAdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }

}
