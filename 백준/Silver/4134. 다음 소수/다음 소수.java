import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            BigInteger n = new BigInteger(br.readLine());
            if(n.isProbablePrime(100)){
                System.out.println(n);
            }else {
                System.out.println(n.nextProbablePrime());
            }
        }
    }
}
