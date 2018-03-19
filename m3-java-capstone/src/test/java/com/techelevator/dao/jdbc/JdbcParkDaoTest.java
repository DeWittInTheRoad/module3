package com.techelevator.dao.jdbc;

import com.techelevator.npgeek.dao.WeatherDao;
import com.techelevator.npgeek.dao.jdbc.JdbcParkDao;
import com.techelevator.npgeek.dao.jdbc.JdbcWeatherDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;
import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcParkDaoTest {

    private static SingleConnectionDataSource dataSource;
    private JdbcWeatherDao parkDao;
    private JdbcParkDao dao;


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        dataSource.destroy();
    }

    @Before
    public void setUp() throws Exception {
        dao = new JdbcParkDao(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        dataSource.getConnection().rollback();
    }

    @Test
    public void testGetAvailableParks() {

        Park testPark = dao.getParkByParkCode("CVNP");
        Park secondPark = dao.getAllParks().get(0);

        assertEquals(testPark.getParkName(), secondPark.getParkName());
        assertEquals("Ohio", dao.getParkByParkCode("CVNP").getState());
        assertEquals("Woodland", dao.getAllParks().get(0).getClimate());
        assertEquals(696, secondPark.getElevationInFeet());

    }



//        List<Weather> weatherList = WeatherDao.getWeatherByParkCode("CVNP");
//
//       CVNP assertEquals("Blackwoods", dao.getAvailableCampgrounds(testPark).get(0).getName());
//        assertEquals("Seawall", dao.getAvailableCampgrounds(testPark).get(1).getName());
//        assertEquals("Schoodic Woods", dao.getAvailableCampgrounds(testPark).get(2).getName());
//        assertEquals("01", dao.getAvailableCampgrounds(testPark).get(0).getOpeningDate());
//        assertEquals("05", dao.getAvailableCampgrounds(testPark).get(1).getOpeningDate());
//        assertEquals("05", dao.getAvailableCampgrounds(testPark).get(2).getOpeningDate());
//        assertEquals("12", dao.getAvailableCampgrounds(testPark).get(0).getClosingDate());
//        assertEquals("09", dao.getAvailableCampgrounds(testPark).get(1).getClosingDate());
//        assertEquals("10", dao.getAvailableCampgrounds(testPark).get(2).getClosingDate());
//        assertEquals(new BigDecimal("35.0"), dao.getAvailableCampgrounds(testPark).get(0).getDailyFee());
//        assertEquals(new BigDecimal("30.0"), dao.getAvailableCampgrounds(testPark).get(1).getDailyFee());
//        assertEquals(new BigDecimal("30.0"), dao.getAvailableCampgrounds(testPark).get(2).getDailyFee());


}
