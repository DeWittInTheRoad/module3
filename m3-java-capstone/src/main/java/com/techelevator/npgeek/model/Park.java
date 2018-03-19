package com.techelevator.npgeek.model;

public class Park {
    String parkCode;
    String parkName;
    String state;
    int acreage;
    int elevationInFeet;
    double milesOfTrail;
    int numberOfCampsites;
    String climate;
    int yearFounded;
    int AnnualVisitorCount;
    String inspirationalQuote;
    String inspirationalQuoteSource;
    String parkDescription;
    int entryFee;
    int numberOfAnimalSpecies;

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getElevationInFeet() {
        return elevationInFeet;
    }

    public void setElevationInFeet(int elevationInFeet) {
        this.elevationInFeet = elevationInFeet;
    }

    public double getMilesOfTrail() {
        return milesOfTrail;
    }

    public void setMilesOfTrail(double milesOfTrail) {
        this.milesOfTrail = milesOfTrail;
    }

    public int getNumberOfCampsites() {
        return numberOfCampsites;
    }

    public void setNumberOfCampsites(int numberOfCampsites) {
        this.numberOfCampsites = numberOfCampsites;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public int getAnnualVisitorCount() {
        return AnnualVisitorCount;
    }

    public void setAnnualVisitorCount(int annualVisitorCount) {
        AnnualVisitorCount = annualVisitorCount;
    }

    public String getInspirationalQuote() {
        return inspirationalQuote;
    }

    public void setInspirationalQuote(String inspirationalQuote) {
        this.inspirationalQuote = inspirationalQuote;
    }

    public String getInspirationalQuoteSource() {
        return inspirationalQuoteSource;
    }

    public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
        this.inspirationalQuoteSource = inspirationalQuoteSource;
    }

    public String getParkDescription() {
        return parkDescription;
    }

    public void setParkDescription(String parkDescription) {
        this.parkDescription = parkDescription;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public int getNumberOfAnimalSpecies() {
        return numberOfAnimalSpecies;
    }

    public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
        this.numberOfAnimalSpecies = numberOfAnimalSpecies;
    }

    public boolean equals(Park that) {
        return this.getParkCode().equals(that.getParkCode());
    }

    @Override
    public String toString() {
        return parkName;
    }
}
