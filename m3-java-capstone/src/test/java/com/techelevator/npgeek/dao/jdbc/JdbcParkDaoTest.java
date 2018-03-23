package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.npgeek.model.Park;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import static org.junit.Assert.assertEquals;

public class JdbcParkDaoTest extends DAOIntegrationTest{
    private static SingleConnectionDataSource dataSource;
    private JdbcParkDao dao;


    @Before
    public void setUp() throws Exception {
        dao = new JdbcParkDao(getDataSource());
    }


    @Test
    public void getAllParks() {

        Park testPark = dao.getParkByParkCode("CVNP");
        Park secondPark = dao.getAllParks().get(0);

        assertEquals(testPark.getParkName(), secondPark.getParkName());
        assertEquals("Ohio", dao.getParkByParkCode("CVNP").getState());
        assertEquals("Woodland", dao.getAllParks().get(0).getClimate());
        assertEquals(696, secondPark.getElevationInFeet());
    }

    @Test
    public void getParkByParkCode() {
        assertEquals("Grand Teton National Park", dao.getParkByParkCode("GTNP").getParkName());
    }
}