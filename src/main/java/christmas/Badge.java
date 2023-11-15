package christmas;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String name;
    private final int threshold;

    Badge(String name, int threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public int getThreshold() {
        return threshold;
    }
}
