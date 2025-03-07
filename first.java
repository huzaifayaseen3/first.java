    /*
import java.util.*;
class First { 
    public static void main(String[] args) {
     
        Scanner sc = new Scanner (System.in);
        int x = sc.nextInt() ;
        int y = sc.nextInt() ;
        int sum = x + y ;
        int diff = x - y ;
        int mult = x * y ;
        System.out.println(sum);
        System.out.println(diff);
        System.out.println(mult);
       
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age >= 18 ){
            System.out.println("Adult");

        }else {
            System.out.println("Minor");
        }
   
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    if (num %2 == 0 ){
        System.out.println("Even");

    }else {
        System.out.println("odd");
    }
    sc.close();
}
}
 
import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read number of test cases
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // Read the number
            int sum = 0;
            
            // Calculate sum of digits
            while (num > 0) {
                sum += num % 10; // Add last digit to sum
                num /= 10; // Remove last digit
            }
            
            // Check if the sum of digits is less than 10
            if (sum < 10) {
                System.out.println("Number is unique");
            } else {
                System.out.println("Number is not unique");
            }
        }
        
        sc.close();
    }
}
    */
    /*
    import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine(); // Read number of test cases
        int count = 0 ;
        do{
            System.out.println(n);
            count++;

        }while(count<10);
            
        
        
        sc.close();
    }
}
*/


public class first {
      public static void main(String[] args) {
       for (double i=1 ;i<11 ; i++){
        System.out.println(i/10); 
       }       
    }
}
