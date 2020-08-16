package com.lamzone.mareunion;

import com.lamzone.mareunion.di.DI;
import com.lamzone.mareunion.model.items.Meeting;
import com.lamzone.mareunion.model.items.PlaceItem;
import com.lamzone.mareunion.model.services.FakeApiMeeting;
import com.lamzone.mareunion.model.services.FakeApiPlace;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PlaceServiceTest {

    private FakeApiPlace mFakeApiPlace;
    private FakeApiMeeting fakeApiMeeting;

    private List<Meeting> mMeetingPlaceFiltered = new ArrayList<>();

    Meeting meetingOne = new Meeting(
            178598654,
            125,
            R.drawable.bleu,
            "Test réunion: Objet ",
            "- 8h30 -",
            "10h00",
            "Salle 1",
            "Jack@Email - Joel@Email - Jess@Email",
            "17/05/21",
            178598654);

    @Before
    public void setupMeeting() {
        mFakeApiPlace = DI.getNewInstancePlaceApi();
        fakeApiMeeting = DI.getNewInstanceApi();
    }

    /**
     * PlaceItem tests
     */
    @Test
    public void getPlaceWithSuccess() {
        assertEquals(mFakeApiPlace.getPlaceItem().size(), 10);
        assertTrue(mFakeApiPlace.getPlaceItem().get(1).getPlaceName().contains("2"));
    }

    @Test
    public void getPlaceWithNoSuccess(){
        PlaceItem expectedPlaceItem = mFakeApiPlace.getPlaceItem().get(0);
        assertNotNull(expectedPlaceItem);
        assertFalse(expectedPlaceItem.getPlaceName().contains("3"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getPlaceItemOutOfList() {
        PlaceItem expectedPlaceItem = mFakeApiPlace.getPlaceItem().get(mFakeApiPlace.getPlaceItem().size() + 1);
        assertTrue(mFakeApiPlace.getPlaceItem().contains(expectedPlaceItem));
    }

    /**
     * PlaceName tests
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getPlaceNameOutOfList() {
        String exceptedPlaceName = mFakeApiPlace.getPlaceNames().get(12);
        assertTrue(mFakeApiPlace.getPlaceNames().contains(exceptedPlaceName));
    }

    @Test
    public void getPlaceNameWithSuccess() {
        assertTrue(mFakeApiPlace.getPlaceNames().get(3).contains("4"));
        assertTrue(mFakeApiPlace.getPlaceNames().get(2).contains("3"));
    }

    @Test
    public void getPlaceNameWithNoSuccess() {
        assertFalse(mFakeApiPlace.getPlaceNames().get(6).contains("5"));
        assertFalse(mFakeApiPlace.getPlaceNames().get(4).contains("2"));
    }

    /**
     * filter PlaceName tests
     */
    @Test
    public void filterPlaceNameWithSuccess() {
        fakeApiMeeting.addNewMeeting(meetingOne);
        mMeetingPlaceFiltered = fakeApiMeeting.filteringOptions("Salle 1");
        assertTrue(mMeetingPlaceFiltered.contains(meetingOne));
    }

    @Test
    public void filterPlaceNameWithNoSuccess() {
        fakeApiMeeting.addNewMeeting(meetingOne);
        mMeetingPlaceFiltered = fakeApiMeeting.filteringOptions("Salle 3");
    }

}
