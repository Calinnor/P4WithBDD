package com.lamzone.mareunion.model.services;

import com.lamzone.mareunion.model.items.PlaceItem;

import java.util.List;

public class FakePlaceService implements FakeApiPlace {
    private List<PlaceItem> mPlaceItems = PlaceGenerator.generatePlace();
    private List<String> mPlaceNames = PlaceGenerator.generatePlaceNames();

    @Override
    public List<PlaceItem> getPlaceItem() {
        return mPlaceItems;
    }

    @Override
    public List<String> getPlaceNames() {
        return mPlaceNames;
    }


}
