/**
    Class to test dividing problem: How few
    operations (+1, -1 when odd; /2 when even)
    does it take to get from some positive #
    down to 1.
    Based on Google's Foo.Bar programming
        challenge problem
    Written for COS 320: Algorithm Analysis
    
    @version 1.0
    Date: 03/02/2018
    @author Ryan Jones
*/

import java.util.Scanner;

public class GetToZero {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number to reduce: ");
        int i = scan.nextInt();
        runFooBar(i);
    }

    /**
        Method runs Foo Bar generator
        to get to zero as fast as
        possible
    */
    private static int runFooBar(int i) {
        int count = 0;
        int i2 = pwr2(i), i2div;
        int hi = (int)Math.pow(2,30);
        while (i > 1) {
            System.out.println(i);
            //odd case
            if(i%2 == 1){
                i2div = i2/2;
                //check overflow case
                if(i2 == hi) i = ((i - hi) < i2div || i==2147483647) ?  i-1 : i+1;
                else i = ((i - i2) < i2div || (i-1==i2)) ? i-1 : i+1;
            }
            else {
                i  /= 2;
                i2 /= 2;
            }
            count++;
        }
        System.out.println(count + " operations to get to 1.");
        return count;
    }

    /**
        Method generates a number
        between n and n/2
        that is a power of 2
    */
    private static int pwr2(int n) {
        int i = 1;
        do {
            i += i;
        }while (i != Math.pow(2, 30) && i*2 < n);
        return i;
    }
}
