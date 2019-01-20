package com.example.kiyon.boostcourse.Contract;

import com.example.kiyon.boostcourse.Adapter.Contract.ReviewListRVAdapterContract;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public interface TotalReviewContract {

    interface View {}
    interface Presenter {
        void attachView(View view);
        void detachView();
        void setReviewAdapterMode(ReviewListRVAdapterContract.Model adapterModel);
        void setReviewAdapterView(ReviewListRVAdapterContract.View adapterView);
        void loadReviewDataList(ArrayList<ReviewData> reviewDataArrayList);
    }
}
