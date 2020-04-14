import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
      ArrayList<Integer> visited = new ArrayList<Integer>( );
        int i;
        int cut = 0;
        int pair = 0;
        int count;
        int j;

        for(i=0;i<n;i++){
            //Check if the numbers are present in visited.
            if(!(visited.isEmpty())){
                //If the numbers are present then check if the number is already present
                // in the visited set.
                for(j = 0;j<visited.size();j++){
                    //If the number is already present then nothing should be carried out
                    if(visited.contains(ar[i])){
                        cut = 1;
                    }
                }

                if(cut == 0){
                    visited.add(ar[i]);
                }
            }else{
                visited.add(ar[i]);
            }

            if(cut == 0){
                count = 1;
                for(j=i+1;j<n;j++){
                    if(ar[i] == ar[j]){
                    
                        count++;
                    }
                }
               pair = pair + (count/2); 
            }else{
                cut = 0;
            }
        }
        return pair;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
