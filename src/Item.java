public class Item {
    double weight;
    double volume;

    public Item(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }

    public double getDensity() {
        return weight/volume;
    }
    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", volume=" + volume +
                '}';
    }
}
