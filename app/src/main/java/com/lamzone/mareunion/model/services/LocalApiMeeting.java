package com.lamzone.mareunion.model.services;

import androidx.lifecycle.LiveData;

import com.lamzone.mareunion.model.items.Meeting;

import java.util.List;

public interface LocalApiMeeting {//replace fakeapimeeting with dao data
    List<Meeting> getMeeting();

    void createDataMeeting(Meeting meeting);

    LiveData<List<Meeting>> getMeetingsForOnePlaceItem(long placeItemId);

    void updateDataMeeting(Meeting meeting);

    void deleteMeeting(long meetingId);

    List<Meeting> filteringOptions(String filteredOption);

}
