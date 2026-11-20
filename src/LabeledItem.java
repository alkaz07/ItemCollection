public class LabeledItem extends Item{
    String label;

    public LabeledItem(String label, double weight, double volume) {
        super(weight, volume);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LabeledItem{" +
                "label='" + label + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                '}';
    }
}
