package com.example.kiyon.boostcourse.Presenter;

import com.example.kiyon.boostcourse.Contract.ReviewContract;
import com.example.kiyon.boostcourse.model.ReviewData;

public class ReviewPresenter implements ReviewContract.Presenter {

    private ReviewContract.View view;

    @Override
    public void attachView(ReviewContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public ReviewData saveReviewData(double star, String review) {
        ReviewData reviewData = new ReviewData();
        reviewData.review = review;
        reviewData.star = star;

        return reviewData;
    }
}
