package com.example.kiyon.boostcourse.Presenter;

import android.util.Log;

import com.example.kiyon.boostcourse.Contract.MainContract;
import com.example.kiyon.boostcourse.model.CountData;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View view;
    private CountData countData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
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

}
