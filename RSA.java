import java.math.*; 
import java.util.*; 
  
public class RSA 
{ 
    public static void main(String args[]) 
    { 
        int p=0, q=0, n, z, d = 0, e, i; 
        List<Integer> primenumbers = new ArrayList<Integer>();
        List<Integer> numlist = Arrays.asList( 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 47, 53, 59, 67, 71, 83, 89, 101, 107, 109, 113, 127, 131, 137, 139, 149, 157, 167, 179, 181, 191, 197, 199, 211, 227, 233, 239, 251, 257, 263, 269, 281, 293, 307, 311, 317, 337, 347, 353, 359, 379, 389, 401, 409);
        primenumbers.addAll(numlist);
        // The number to be encrypted and decrypted 
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        System.out.print("Enter the number : ");
        int msg =  Integer.parseInt(sc.nextLine());

        double c; 
        BigInteger msgback; 
  
        // 1st prime number p 
        Boolean status =false;
        for(int h =3; h<primenumbers.size(); h++){
            for(int k =h-1; k<primenumbers.size(); k++){
                if(primenumbers.get(h)*primenumbers.get(k) > msg+msg/100
                ){
                    p = primenumbers.get(h);
                    q = primenumbers.get(k);
                    status = true;
                    break;
                }
                
            }
            if(status == true){
                break;
            }
        }
      
        System.out.println("the value p = " + p); 
  
        // 2nd prime number q 
       
        System.out.println("the value q = " + q); 
        n = p * q; 
        System.out.println("the value n = " + n); 
        z = (p - 1) * (q - 1); 
        System.out.println("the value of z = " + z); 
  
        for (e = 2; e < z; e++) { 
  
            // e is for public key exponent 
            if (gcd(e, z) == 1) { 
                break; 
            } 
        } 
        System.out.println("the value of e = " + e); 
        for (i = 0; i <= 9; i++) { 
            int x = 1 + (i * z); 
  
            // d is for private key exponent 
            if (x % e == 0) { 
                d = x / e; 
                break; 
            } 
        } 
        System.out.println("the value of d = " + d); 
        c = (Math.pow(msg, e)) % n; 
        System.out.println("Encrypted message is : " + c); 
  
        // converting int value of n to BigInteger 
        BigInteger N = BigInteger.valueOf(n); 
  
        // converting float value of c to BigInteger 
        BigInteger C = BigDecimal.valueOf(c).toBigInteger(); 
        msgback = (C.pow(d)).mod(N); 
        System.out.println("Derypted message is : "
                           + msgback); 
    } 
  
    static int gcd(int e, int z) 
    { 
        if (e == 0) 
            return z; 
        else
            return gcd(z % e, e); 
    } 

    
}

