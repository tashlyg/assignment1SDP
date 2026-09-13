package smartfarm;

public class Location {
    private final String sector;
    private final int greenhouseNumber;

    public Location(String sector, int greenhouseNumber) {
        this.sector = sector;
        this.greenhouseNumber = greenhouseNumber;
    }
    public String getSector() {
        return sector;
    }
    public int getGreenhouseNumber() {
        return greenhouseNumber;
    }
    @Override
    public String toString() {
        return "Sector=" + sector + ", Greenhouse=" + greenhouseNumber;
    }
}
