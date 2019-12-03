package springMVC;

import springMVC.model.SizeType;


public class TestApp {

    public static void main(String[] args) {
        for (SizeType p : SizeType.values ( ))
            System.out.println (
                    p.ordinal ( ) + " " + p.name ( ));
    }
}

