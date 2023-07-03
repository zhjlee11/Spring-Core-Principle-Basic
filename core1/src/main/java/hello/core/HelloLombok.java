package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;


    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfgh");

        // code 1
        String name = helloLombok.getName();
        System.out.println("name = " + name);

        // code 2
        System.out.printf(helloLombok.toString());
    }

}
