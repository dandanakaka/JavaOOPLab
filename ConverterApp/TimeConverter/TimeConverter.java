package TimeConverter;

// This class contains all the methods for time conversions.
public class TimeConverter {
    public int hourstominutes(int hours) {
        return hours * 60;
    }

    public double minutestohours(int minutes) {
        return (double) minutes / 60;
    }

    public int hourstoseconds(int hours) {
        return hours * 3600;
    }

    public double secondstohours(int seconds) {
        return (double) seconds / 3600;
    }
}

