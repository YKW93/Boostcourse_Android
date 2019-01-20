package com.example.kiyon.boostcourse.Contract;

import com.example.kiyon.boostcourse.Adapter.Contract.MainVHAdapterContract;

public interface MainContract {
    interface View {

    }

    interface Presenter {
        void attachView(View view);
        void detachView();
        void setMovieDataList();
        void setMainAdapterModel(MainVHAdapterContract.Model adapterModel);
        void setMainAdapterView(MainVHAdapterContract.View adapterView);
    }
}
