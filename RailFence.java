import java.util.*;

public class RailFence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        System.out.print("Enter a string : ");
        String str = sc.nextLine();
        System.out.print("Enter value of depth (k) : ");
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
       
        char[] ch = new char[input.length()];
        char[] answer = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' '){
                ch[i] = ' ';
            }
            else {
                ch[i] = Character.toLowerCase(input.charAt(i));
            }
            
        }
        int count =0;
        for (int i = 0; i < size; i++) {
            for(int j = i; j<input.length(); j=j+size){
                answer[count]= Character.toUpperCase( ch[j]);
                count++;
            }
        }
        String encodedString = new String(answer);
        return encodedString;

    }


    public static String decode(String input, int size) {
        
        char[] ch = new char[input.length()];
        char[] answer = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' '){
                ch[i] = ' ';
            }
            else {
                ch[i] = Character.toLowerCase(input.charAt(i));
            }
            
        }

        int minlen = (int) Math.ceil(input.length()/size);
        int reminder = input.length()%size;
        int limit = minlen * reminder + reminder - 1;
        int outerlooprange;
        if(reminder ==0){
            outerlooprange= minlen;
        }
        else{
            outerlooprange= minlen+1;
        }
        //System.out.print("minlen : " + minlen);
        //System.out.print("reminder : " + reminder);
        //System.out.print("limit : " + limit);
        //System.out.print("outerlooprange : " + outerlooprange);

        int count =0;
        for (int i = 0; i < outerlooprange; i++) {
            for(int j = i; j<input.length(); j=j+minlen){
                //System.out.print("\n"+j);
                answer[count]= Character.toUpperCase( ch[j]);
                if(j<limit){
                    j++;
                }else if(j==limit){  
                    break;
                } 
                count++;
            }
            
        }
        String decodedString = new String(answer);
        return decodedString;

    }
}
