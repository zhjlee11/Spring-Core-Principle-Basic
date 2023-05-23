package hello.core.singleton;

public class StatefullServiceImprovement {


    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

}
