package com.example.kiyon.boostcourse.Adapter.Contract;

import com.example.kiyon.boostcourse.model.MovieData;

import java.util.ArrayList;

public interface MainVHAdapterContract {
    interface View {
        void notifyAdapter();
    }
    interface Model {
        void addItem(ArrayList<MovieData> movieDataArrayList);

    }
}
