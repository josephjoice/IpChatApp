import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by joseph on 13/4/15.
 */
public class HelloWorld {
    public static void main(String args[]) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(in);
        try {
            int num1 = Integer.parseInt(read.readLine());
            int num2 = Integer.parseInt(read.readLine());
            System.out.println("The sum is " + (num1 + num2));
        } catch (Exception e) {
            System.out.println("Some error occured");
        }
    }
}
