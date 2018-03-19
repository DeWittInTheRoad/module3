package com.techelevator.npgeek.dao.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class JdbcSurveyDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllSurveys() {
    }

    @Test
    public void save() {
    }
}


//    @Test
//    public void testGetAvailableSites(){
//        LocalDate arrivalDate = LocalDate.of(2018, 05, 05);
//        LocalDate departureDate = LocalDate.of(2018, 05, 12);
//        Park testPark = parkDAO.getAllAvailableParks().get(0);
//        Campground testCamp = campDAO.getAvailableCampgrounds(testPark).get(0);
//
//
//        assertEquals(1, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).getSiteId().longValue());
//        assertEquals(2, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).getSiteId().longValue());
//        assertEquals(3, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(2).getSiteId().longValue());
//        assertEquals(4, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(3).getSiteId().longValue());
//
//        assertEquals(1, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).getCampgroundId().longValue());
//        assertEquals(1, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).getCampgroundId().longValue());
//        assertEquals(1, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(2).getCampgroundId().longValue());
//        assertEquals(1, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(3).getCampgroundId().longValue());
//
//        assertEquals(1, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).getSiteNumber().longValue());
//        assertEquals(2, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).getSiteNumber().longValue());
//
//
//        assertEquals(6, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).getMaxOccupancy().longValue());
//        assertEquals(6, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).getMaxOccupancy().longValue());
//        assertEquals(6, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(2).getMaxOccupancy().longValue());
//        assertEquals(6, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(3).getMaxOccupancy().longValue());
//
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).isAccessible());
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).isAccessible());
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(2).isAccessible());
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(3).isAccessible());
//
//        assertEquals(0, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).getMaxRvLength().longValue());
//        assertEquals(0, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).getMaxRvLength().longValue());
//
//
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(0).isUtilities());
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(1).isUtilities());
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(2).isUtilities());
//        assertEquals(false, dao.getAvailableSites(testCamp, arrivalDate, departureDate).get(3).isUtilities());


//    @Test
//    public void testGetReservations() {
//        String nameInput;
//        Site siteChoice = new Site();
//        Long id = new Long(1);
//        siteChoice.setSiteId(id);
//        Reservation test;
//        test = reservationDAO.getReservations(siteChoice).get(0);
//
//        assertEquals(1, reservationDAO.getReservations(siteChoice).get(0).getSiteId().longValue());
//        assertEquals(1, reservationDAO.getReservations(siteChoice).get(0).getReservationId().longValue());
//        assertEquals("Smith Family Reservation", reservationDAO.getReservations(siteChoice).get(0).getName());
//    }
//
//    @Test
//    public void testBookReservation() {
//        String nameInput = "Steve";
//        LocalDate arrival = LocalDate.of(2017, 1, 1);
//        LocalDate departure = LocalDate.of(2017, 1, 2);
//        Site siteChoice = new Site();
//        Long id = new Long(1);
//        siteChoice.setSiteId(id);
//        reservationDAO.bookReservation(siteChoice, arrival, departure, nameInput);
//        assertEquals(1, reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).getSiteId().longValue());
//        assertEquals(arrival, reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).getFromDate());
//        assertEquals(departure, reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).getToDate());
//        assertEquals("Steve", reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).toString());
//
//    }}

//    @Test
//    public void testGetBookedReservation() {
//        String nameInput = "Steve";
//        LocalDate arrival = LocalDate.of(2017, 1, 1);
//        LocalDate departure = LocalDate.of(2017, 1, 2);
//        Site siteChoice = new Site();
//        Long id = new Long(1);
//        siteChoice.setSiteId(id);
//        reservationDAO.bookReservation(siteChoice, arrival, departure, nameInput);
//        assertEquals(1, reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).getSiteId().longValue());
//        assertEquals(arrival, reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).getFromDate());
//        assertEquals(departure, reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).getToDate());
//        assertEquals("Steve", reservationDAO.getBookedReservation(siteChoice, arrival, departure, nameInput).toString());
//    }
//}