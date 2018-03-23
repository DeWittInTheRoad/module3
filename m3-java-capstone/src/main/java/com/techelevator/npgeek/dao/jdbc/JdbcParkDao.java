package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.model.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcParkDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getAllParks() {
        List<Park> allParks = new ArrayList<>();
        String sqlSelectAllParks = "SELECT * FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
        while (results.next()) {
            allParks.add(mapRowToParks(results));
        }
        return allParks;
    }

    @Override
    public Park getParkByParkCode(String parkCode) {
        Park park = null;
        String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkCode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, parkCode);
        if (results.next()) {
            park = mapRowToParks(results);
        }
        return park;
    }

    private Park mapRowToParks(SqlRowSet row) {
        Park park = new Park();
        park.setParkCode(row.getString("parkCode"));
        park.setParkName(row.getString("parkName"));
        park.setState(row.getString("state"));
        park.setAcreage(row.getInt("acreage"));
        park.setElevationInFeet(row.getInt("elevationInFeet"));
        park.setMilesOfTrail(row.getDouble("milesOfTrail"));
        park.setNumberOfCampsites(row.getInt("numberOfCampsites"));
        park.setClimate(row.getString("climate"));
        park.setYearFounded(row.getInt("yearFounded"));
        park.setAnnualVisitorCount(row.getInt("annualVisitorCount"));
        park.setInspirationalQuote(row.getString("inspirationalQuote"));
        park.setInspirationalQuoteSource(row.getString("inspirationalQuoteSource"));
        park.setParkDescription(row.getString("parkDescription"));
        park.setEntryFee(row.getInt("entryFee"));
        park.setNumberOfAnimalSpecies(row.getInt("numberOfAnimalSpecies"));
        return park;
    }


}
