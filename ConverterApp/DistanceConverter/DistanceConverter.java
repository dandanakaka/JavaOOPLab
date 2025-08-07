package DistanceConverter;

// This class contains all the methods for distance conversions.
public class DistanceConverter {
    private final double METER_TO_KM = 0.001;
    private final double MILE_TO_KM = 1.60934;

    public double metertokm(double meters) {
        return meters * METER_TO_KM;
    }

    public double kmtometer(double km) {
        return km / METER_TO_KM;
    }

    public double milestokm(double miles) {
        return miles * MILE_TO_KM;
    }

    public double kmtomiles(double km) {
        return km / MILE_TO_KM;
    }
}

