package com.example.kiyon.boostcourse.Contract;

import com.example.kiyon.boostcourse.Adapter.Contract.ReviewListRVAdapterContract;
import com.example.kiyon.boostcourse.model.CountData;
import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public interface DetailContract {

    interface View {
        void changeUpDownView(int type);
        void setUpDownCountView(CountData countView);
        boolean getViewType(int type);
    }

    interface Presenter {
        void attachView(View view);
        void detachView();
        void setCountData(CountData countData);
        void upCount(boolean isClicked);
        void downCount(boolean isClicked);
        void loadReviewData(ReviewData reviewData);
        ArrayList<ReviewData> getReviewDataList();
        void setReviewAdapterModel(ReviewListRVAdapterContract.Model adapterModel);
        void setReviewAdapterView(ReviewListRVAdapterContract.View adapterView);

    }
}
