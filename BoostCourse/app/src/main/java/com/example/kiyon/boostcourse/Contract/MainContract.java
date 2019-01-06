package com.example.kiyon.boostcourse.Contract;

import com.example.kiyon.boostcourse.model.CountData;

public interface MainContract {

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

    }
}
