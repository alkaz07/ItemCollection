import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static void main() {
        example4();
    }

    private static void example1() {
        //Хочу сделать много(5 шт) предметов
        List<Item> items= new ArrayList<>();
        items.add(new Item(1, 10));
        items.add(new Item(2, 20));
        items.add(new Item(2, 2));
        items.add(new LabeledItem("Шарик", 0.5, 10));
        items.add(new LabeledItem("Кубик", 0.2, 20));
        System.out.println("items = " + items);
        // как осортировать элементы списка по объему?
//        items.sort();
        Infant inf = new Infant("Васенька", 5);
        items.sort(inf);    //передаем функции sort ссылку на объект, относящийся к классу,
                            //который умеет сравнивать предметы 
                            // (внутри класса есть функция compare, которая как-то сравнивает Item a и Item b)
        System.out.println("items = " + items);
    }

    private static void example2() {
        //Хочу сделать много(5 шт) предметов
        List<Item> items= new ArrayList<>();
        items.add(new Item(1, 10));
        items.add(new Item(2, 20));
        items.add(new Item(2, 2));
        items.add(new LabeledItem("Шарик", 0.5, 10));
        items.add(new LabeledItem("Кубик", 0.2, 20));
        System.out.println("items = " + items);
        // как осортировать элементы списка по весу?
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                System.out.println("Производится сравнение "+a+" и "+b+" по весу и получаем "+Double.compare(a.weight, b.weight));
                return Double.compare(a.weight, b.weight);
            }
        });
        System.out.println("items = " + items);
        //а по плотности?
        items.sort((a, b) -> {            
            return Double.compare(a.getDensity(), b.getDensity());
        });
        System.out.println("--------------------------------");
        System.out.println("items = " + items);
    }

    private static void example3() {
        //Хочу сделать много(5 шт) предметов
        List<Item> items= new ArrayList<>();
        items.add(new Item(1, 10));
        items.add(new Item(2, 20));
        items.add(new Item(2, 2));
        items.add(new LabeledItem("Шарик", 0.5, 10));
        items.add(new LabeledItem("Кубик", 0.2, 20));
        System.out.println("items = " + items);
        // как осортировать элементы списка по весу?
        items.sort(Comparator.comparingDouble(a -> a.weight));
        System.out.println("items = " + items);
        //а по плотности в обратном порядке?
        items.sort(Comparator.comparingDouble(Item::getDensity).reversed());
        System.out.println("--------------------------------");
        System.out.println("items = " + items);

        items.sort(Comparator.comparingDouble(Item::getDensity)
                             .reversed()
                             .thenComparingDouble(Item::getWeight)
                             );
        System.out.println("--------------------------------");
        System.out.println("items = " + items);

    }

    private static void example4() {
        //Хочу сделать много(5 шт) предметов
        List<Item> items= new ArrayList<>();
        items.add(new Item(1, 10));
        items.add(new Item(2, 20));
        items.add(new Item(2, 2));
        items.add(new LabeledItem("Шарик", 0.5, 10));
        items.add(new LabeledItem("Кубик", 0.2, 20));
        System.out.println("items = " + items);
        // как осортировать элементы списка по ярлыку?
        items.sort((a, b)->{
            //Не всегда у предметов есть ярлык...
            String aLabel, bLabel;
            if(a instanceof LabeledItem)
                 aLabel= ((LabeledItem) a).getLabel();
            else aLabel="???";
            if(b instanceof LabeledItem)
                bLabel= ((LabeledItem) b).getLabel();
            else bLabel="???";
            return aLabel.compareTo(bLabel);
        });
        System.out.println("items = " + items);
    }
}
