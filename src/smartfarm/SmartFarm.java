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

    private SmartFarm(Builder builder) {
        this.farmName = builder.farmName;
        this.cropType = builder.cropType;
        this.areaSizeHectares = builder.areaSizeHectares;
        this.location = builder.location;
        this.targetTemperature = builder.targetTemperature;
        this.targetHumidity = builder.targetHumidity;
        this.autoIrrigation = builder.autoIrrigation;
        this.autoLighting = builder.autoLighting;
        this.aiCropMonitoring = builder.aiCropMonitoring;
        this.sensorUpdateIntervalMinutes = builder.sensorUpdateIntervalMinutes;
    }
    // getters
    public String getFarmName() { return farmName; }
    public String getCropType() { return cropType; }
    public double getAreaSizeHectares() { return areaSizeHectares; }
    public Location getLocation() { return location; }
    public double getTargetTemperature() { return targetTemperature; }
    public double getTargetHumidity() { return targetHumidity; }
    public boolean isAutoIrrigation() { return autoIrrigation; }
    public boolean isAutoLighting() { return autoLighting; }
    public boolean isAiCropMonitoring() { return aiCropMonitoring; }
    public int getSensorUpdateIntervalMinutes() { return sensorUpdateIntervalMinutes; }

    @Override
    public String toString() {
        return "SmartFarm{" +
                "name='" + farmName + '\'' +
                ", crop='" + cropType + '\'' +
                ", area=" + areaSizeHectares + " ha" +
                ", location=" + location +
                ", temp=" + targetTemperature + "°C" +
                ", humidity=" + targetHumidity + "%" +
                ", autoIrrigation=" + autoIrrigation +
                ", autoLighting=" + autoLighting +
                ", aiMonitoring=" + aiCropMonitoring +
                ", updateInterval=" + sensorUpdateIntervalMinutes + "m" +
                '}';
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
        //method chaining
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
        //Presets
        public Builder applyBasicEcoPreset() {
            this.autoIrrigation = true;
            this.autoLighting = false;
            this.aiCropMonitoring = false;
            this.sensorUpdateIntervalMinutes = 60;
            return this;
        }
        public Builder applyHighTechPreset() {
            this.autoIrrigation = true;
            this.autoLighting = true;
            this.aiCropMonitoring = true;
            this.sensorUpdateIntervalMinutes = 5;
            return this;
        }
        public Builder applyTropicalClimatePreset() {
            this.targetTemperature = 28.0;
            this.targetHumidity = 85.0;
            this.autoIrrigation = true;
            return this;
        }

        private void validate() {
            if (farmName == null || farmName.isBlank()) {
                throw new IllegalArgumentException("Farm name cannot be null");
            }
            if (areaSizeHectares <= 0) {
                throw new IllegalArgumentException("Area Size must be greater than 0");
            }
            if (sensorUpdateIntervalMinutes < 1 || sensorUpdateIntervalMinutes > 1440) {
                throw new IllegalArgumentException("Sensor update interval must be between 1 and 1440 minutes");
            }
            if (aiCropMonitoring && sensorUpdateIntervalMinutes > 15) {
                throw new IllegalStateException("AI Crop Monitoring requires a sensor update interval of 15 minutes or less");
            }
            if (targetHumidity > 80.0 && !autoIrrigation) {
                throw new IllegalStateException("High humidity (>80%) configurations require Auto-Irrigation to be enabled");
            }
        }
        public SmartFarm build() {
            validate();
            return new SmartFarm(this);
        }
    }
}
