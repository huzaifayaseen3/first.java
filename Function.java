// import java.util.*;

// public class Function {
//     // public static int Addition(int a, int b) {
//     //     int sum = a + b;
//     //     return sum;
//     // public static int multiply(int a , int b){
//     //     int multiply = a * b ;
//     //     return multiply ;
//     // }
  
//     public static void Factorial(int a ){
//         int n=4;
//         int fact = 1 ;
//         for( int i= n ; i>=1 ; i--){
//              fact = fact *i ;
//         }
//     } 
    

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = sc.nextInt();
//     //    int b = sc.nextInt();
//       //  int sum = Addition(a, b);
//      // int mult = multiply(a, b);
//      Factorial(a);
//         System.out.println(a);
//     }
// }
import java.util.Scanner;

public class Function { // Keep only one class
    public static int Factorial(int a) {
        int fact = 1;
        for (int i = a; i >= 1; i--) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();
        sc.close(); // Close scanner to avoid resource leak

        int result = Factorial(a); // Call the method and store the result
        System.out.println("Factorial of " + a + " is: " + result);
    }
}
