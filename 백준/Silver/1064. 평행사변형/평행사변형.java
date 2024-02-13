import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] xArr = new double[3];
        double[] yArr = new double[3];

        for (int i = 0; i < 3; i++) {
            xArr[i] = Double.parseDouble(st.nextToken());
            yArr[i] = Double.parseDouble(st.nextToken());
        }

        if (Math.abs((yArr[0] - yArr[1]) / (xArr[0] - xArr[1])) == Math.abs((yArr[0] - yArr[2]) / (xArr[0] - xArr[2]))) {
            System.out.println(-1);
        } else {

            double[] edges = new double[3];
            double triangleLength = 0;
            for (int i = 0; i < 3; i++) {
                double edge = Math.sqrt(
                        Math.pow(xArr[(i + 1) % 3] - xArr[i], 2)
                                + Math.pow(yArr[(i + 1) % 3] - yArr[i], 2)
                );

                edges[i] = edge;
                triangleLength += edge;
            }

            double minLength = triangleLength * 2;
            double maxLength = 0;
            for (int i = 0; i < 3; i++) {
                double rectangleLength = (triangleLength - edges[i]) * 2;
                minLength = Math.min(rectangleLength, minLength);
                maxLength = Math.max(rectangleLength, maxLength);
            }

            System.out.println(maxLength - minLength);
        }
    }
}