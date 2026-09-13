package smartfarm;

public class SmartFarm {
    private final String farmName;
    private final String cropType;
    private final double areaSizeHectares;
    private final Location location;

    private final double targetTemperature;
    private final double targetHumidity;
    private final boolean autoIrrigation;
    private final boolean autoLighting;
    private final boolean aiCropMonitoring;
    private final int sensorUpdateIntervalMinutes;

    private SmartFarm() {
    }
    public static class Builder {
        private String farmName;
        private String cropType;
        private double areaSizeHectares;
        private Location location;

        private double targetTemperature = 22.0;
        private double targetHumidity = 60.0;
        private boolean autoIrrigation = false;
        private boolean autoLighting = false;
        private boolean aiCropMonitoring = false;
        private int sensorUpdateIntervalMinutes = 30;
        public Builder(String farmName, String cropType, double areaSizeHectares, Location location) {
            this.farmName = farmName;
            this.cropType = cropType;
            this.areaSizeHectares = areaSizeHectares;
            this.location = location;
        }
        public Builder setTemperature(double temp) {
            this.targetTemperature = temp;
            return this;
        }
        public Builder setHumidity(double humidity) {
            this.targetHumidity = humidity;
            return this;
        }
        public Builder enableAutoIrrigation() {
            this.autoIrrigation = true;
            return this;
        }
        public Builder enableAutoLighting() {
            this.autoLighting = true;
            return this;
        }
        public Builder enableAiCropMonitoring() {
            this.aiCropMonitoring = true;
            return this;
        }
        public Builder setSensorInterval(int minutes) {
            this.sensorUpdateIntervalMinutes = minutes;
            return this;
        }
    }
}
