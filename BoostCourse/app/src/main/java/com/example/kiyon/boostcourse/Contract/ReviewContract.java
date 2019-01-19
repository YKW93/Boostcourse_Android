package com.example.kiyon.boostcourse.Contract;

import com.example.kiyon.boostcourse.model.ReviewData;

public interface ReviewContract {

    interface View {

    }

    interface Presenter {
        void attachView(View view);
        void detachView();
        ReviewData saveReviewData(double star, String review);
    }
}
