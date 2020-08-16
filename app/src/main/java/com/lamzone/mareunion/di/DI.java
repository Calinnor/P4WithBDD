package com.lamzone.mareunion.di;

import com.lamzone.mareunion.database.dao.MeetingDao;
import com.lamzone.mareunion.model.services.FakeApiMeeting;
import com.lamzone.mareunion.model.services.FakeApiPlace;
import com.lamzone.mareunion.model.services.FakeMeetingService;
import com.lamzone.mareunion.model.services.FakePlaceService;
import com.lamzone.mareunion.model.services.LocalApiMeeting;
import com.lamzone.mareunion.model.services.LocalMeetingService;

/**
 * create instance of LocalMeetingService using ApiService service
 */
public class DI {

    /**
     * implement FakeApi
     */
   // private static FakeApiMeeting mMeetingApi = new FakeMeetingService();
    private static FakeApiPlace mFakeApiPlace = new FakePlaceService();

    private static MeetingDao meetingDao;
    private static LocalApiMeeting localApiMeeting = new LocalMeetingService(meetingDao);

    /**
     * @return an instance of FakeApi. Usable in app to collect values
     */
//    public static FakeApiMeeting getMeetingApi() {
//        return mMeetingApi;
//    }
    public static LocalApiMeeting getLocalApiMeeting() {return localApiMeeting;}

    public static FakeApiPlace getApiPlace() {
        return mFakeApiPlace;
    }

    /**
     * @return a new instance of DummyMeetingService. Usable with tests
     */
    public static FakeApiMeeting getNewInstanceApi() {
        return new FakeMeetingService();
    }

    public static FakeApiPlace getNewInstancePlaceApi() {
        return new FakePlaceService();
    }
}
