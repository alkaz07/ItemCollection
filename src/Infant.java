import java.util.Comparator;

public class Infant implements Comparator<Item> {
    String name;
    int age;

    public Infant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compare(Item a, Item b){
        System.out.println("Я, "+name+", сравниваю "+a +" и "+b);
          if (a.getVolume() < b.getVolume())
              return -1;
          if (a.getVolume() > b.getVolume())
              return 1;
          return 0;
    }
}
