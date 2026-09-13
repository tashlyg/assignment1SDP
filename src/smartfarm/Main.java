package smartfarm;

public class Main {
    static void main() {
        System.out.println("1. Smart Farm Configuration");
        SmartFarm highTechFarm = new SmartFarm.Builder(
                "Greenotech Alpha",
                "Tomatoes",
                12.5,
                new Location("North", 67)
        ).applyHighTechPreset().setTemperature(24.5).build();

        System.out.println(highTechFarm);
        System.out.println("\n2. Custom Tropical Farm Configuration");
        SmartFarm tropicalFarm = new SmartFarm.Builder(
                "Tropico Greenhouse",
                "Cucumbers",
                5.0,
                new Location("South", 12)
        ).applyTropicalClimatePreset().enableAutoIrrigation().setSensorInterval(10).build();
        System.out.println(tropicalFarm);
    }
}
