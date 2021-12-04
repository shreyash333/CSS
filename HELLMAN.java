import java.util.*;

public class HELLMAN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of P");
        int p = sc.nextInt();
        System.out.println("Enter the value of G");
        int g = sc.nextInt();
        System.out.println("select 1st secret no of Alice");
        int a = sc.nextInt();
        System.out.println("select 2nd secret no of Bob");
        int b = sc.nextInt();
        int A = (int) Math.pow(g, a) % p;
        int B = (int) Math.pow(g, b) % p;
        System.out.println("\nKey Alice Received = " + B);
        System.out.println("\nKey Bob Received = " + A);
        int S_A = (int) Math.pow(B, a) % p;
        int S_B = (int) Math.pow(A, b) % p;
        if (S_A == S_B) {
            System.out.println("\nShared a secret key is = " + S_A);
            System.out.println("Alice and Bob can exchange information with each other");
        } else {
            System.out.println("Alice and Bob cannot exchange information with each other");
        }
    }

}
