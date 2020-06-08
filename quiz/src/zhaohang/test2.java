package zhaohang;

/**
 * @author jgz
 * @Date 2020-04-29 10:19
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class test2 {

    private  float sum(List<Integer> heights){
        int result = 0;
        for( int i=0;i<heights.size();i++){
            result += heights.get(i);
        }
        return result;
    }
}

class Annoyance extends Exception {
}
class Sneeze extends Annoyance {
}
class Human {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        } finally {
            System.out.println("Hello World!");
        }
    }
}


