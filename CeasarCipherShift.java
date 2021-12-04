
import java.util.*;

public class CeasarCipherShift {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        System.out.print("Enter a string : ");
        String str = sc.nextLine();
        System.out.print("Enter value of shift (k) : ");
        int k = sc.nextInt();
        System.out.print("Enter option number : 1. Encoding    || 2. Decoding \n");
        int value = sc.nextInt();
        String result;
        if(value == 1){
            result = encode(str, k);
        }else{
            result = decode(str, k);
        }

        sc.close();
        
        System.out.println("Converted Text : " + result);

    }

    public static String encode(String input, int size) {
        char alphaArray[] = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] ch = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' '){
                ch[i] = ' ';
            }
            else {
                ch[i] = Character.toLowerCase(input.charAt(i));
            }
            
        }

        for (int i = 0; i < input.length(); i++) {
            int found = -1;
            for (int j = 0; j < alphaArray.length; ++j) {
                if (alphaArray[j] == ch[i]) {
                    found = j;
                    break;
                }
            }
            if(found + size > 25){
                int extra = found + size ;
                found = extra - 25 - 1;
            }else{
                found = found + size;
            }

            if(ch[i]  == ' '){
                ch[i] = ' ';
            }
            else {
                ch[i] = Character.toUpperCase(alphaArray[found]);
            }
            
        }

        String encodedString = new String(ch);
        return encodedString;

    }


    public static String decode(String input, int size) {
        char alphaArray[] = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        char[] ch = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' '){
                ch[i] = ' ';
            }
            else {
                ch[i] = Character.toLowerCase(input.charAt(i));
            }
            
        }

        for (int i = 0; i < input.length(); i++) {
            int found = -1;
            for (int j = 0; j < alphaArray.length; ++j) {
                if (alphaArray[j] == ch[i]) {
                    found = j;
                    break;
                }
            }
            if(found - size < 0){
                int extra =  found - size ;
                found = 25 + extra +1 ;
              
            }else{
                found = found - size;
            }

            if(ch[i]  == ' '){
                ch[i] = ' ';
            }
            else {
                ch[i] = Character.toUpperCase(alphaArray[found]);
            }
            
        }

        String decodedString = new String(ch);
        return decodedString;

    }
}

// OUTPUT 

//C:\Users\Asus\Desktop\Java Project>javac CeasarCipherShift.java
//
//C:\Users\Asus\Desktop\Java Project>java CeasarCipherShift
//Enter a string to be encoded : my name is shreyash singh
//Enter value of shift (k) : 3
//Enter option number : 1. Encoding    || 2. Decoding
//1
//Encoded Text : PB QDPH LV VKUHBDVK VLQJK
//
//C:\Users\Asus\Desktop\Java Project>java CeasarCipherShift
//Enter a string to be encoded : PB QDPH LV VKUHBDVK VLQJK
//Enter value of shift (k) : 3
//Enter option number : 1. Encoding    || 2. Decoding
//2
//Encoded Text : MY NAME IS SHREYASH SINGH
//
//C:\Users\Asus\Desktop\Java Project>
