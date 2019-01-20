package com.example.kiyon.boostcourse.Adapter.Contract;

import com.example.kiyon.boostcourse.model.ReviewData;

import java.util.ArrayList;

public interface ReviewListRVAdapterContract {
    interface View {
        void notifyAdapter();
    }
    interface Model {
        void addItems(ArrayList<ReviewData> items);
    }
}
