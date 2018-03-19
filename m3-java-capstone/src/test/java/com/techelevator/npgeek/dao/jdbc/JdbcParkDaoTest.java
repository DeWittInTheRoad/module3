package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.DAOIntegrationTest;
import org.junit.Test;

import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.dao.jdbc.JdbcParkDao;
import com.techelevator.npgeek.dao.jdbc.JdbcWeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;
import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import static org.junit.Assert.assertEquals;

public class JdbcParkDaoTest extends DAOIntegrationTest{
    private static SingleConnectionDataSource dataSource;
    private JdbcParkDao dao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);

    }

    @Before
    public void setUp() throws Exception {
        dao = new JdbcParkDao(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        dataSource.getConnection().rollback();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        dataSource.destroy();
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