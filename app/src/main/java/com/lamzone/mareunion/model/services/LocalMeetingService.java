package com.lamzone.mareunion.model.services;

import androidx.lifecycle.LiveData;

import com.lamzone.mareunion.database.dao.MeetingDao;
import com.lamzone.mareunion.model.items.Meeting;

import java.util.ArrayList;
import java.util.List;

public class LocalMeetingService implements LocalApiMeeting{

    private List<Meeting> mMeetings = new ArrayList<>();
    private final MeetingDao meetingDao;

    public LocalMeetingService(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    @Override
    public List<Meeting> getMeeting() {
        return mMeetings;
    }

    @Override
    public void createDataMeeting(Meeting meeting) {
        meetingDao.insertMeeting(meeting);
    }

    @Override
    public LiveData<List<Meeting>> getMeetingsForOnePlaceItem(long placeItemId) {
        return this.meetingDao.getMeetings(placeItemId);
    }

    @Override
    public void updateDataMeeting(Meeting meeting) {
        meetingDao.updateMeeting(meeting);
    }

    @Override
    public void deleteMeeting(long meetingId) {
        meetingDao.deleteMeeting(meetingId);
    }

    @Override
    public List<Meeting> filteringOptions(String filteredOption) {
        List<Meeting> mMeetingFiltered = new ArrayList<>();
        for (Meeting meeting : mMeetings) {
            if (meeting.getMeetingDate().equals(filteredOption) || meeting.getMeetingPlaceName().equals(filteredOption))
                mMeetingFiltered.add(meeting);
        }
        return mMeetingFiltered;
    }
}
