import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IbmQuestion {

    void question1() {
        List<String> input = new ArrayList<>();

        input.add("2 2 1");
        input.add("323 323 945");
        input.add("1 1 3");
        input.add("3 3 3");
        List<String> output = triangleType(input);

        for (String s : output) {
            System.out.println(s);
        }
    }


    List<String> triangleType(List<String> triangleToy) {
        List<String> output = new ArrayList<>();

        for (String toy : triangleToy) {
            String[] items = toy.split(" ");
            int x = Integer.parseInt(items[0]);
            int y = Integer.parseInt(items[1]);
            int z = Integer.parseInt(items[2]);



            if (x == y && y ==z) {
                output.add("Equilateral");
            }
            else if (x == y || y == z || z == x) {

                if (x == y) {

                    if (x + y > z)
                        output.add("Isosceles");
                    else
                        output.add("None of these");
                }
                else if (y == z){
                    if (y + z > x)
                        output.add("Isosceles");
                    else
                        output.add("None of these");
                }
                else if (x == z){

                    if (x + z > y)
                        output.add("Isosceles");
                    else
                        output.add("None of these");
               }
            }
        }
        return output;
    }

    void question2() {
        int d = 5;
//        List<Integer> input = List.of(1, 10, 4,3, 2, 5, 0, 1, 9, 5);
        int []input = new int[]{1, 10, 4,3, 2, 5, 0, 1, 9, 5};
        Arrays.sort(input);
        tripletsDivisibleByD(input, d);

    }

    private void tripletsDivisibleByD(int[] data, int d) {
        long start = System.nanoTime();
        int size = data.length;
        int count = 0;
        for (int i =0; i<size; i++) {
            for (int j=i+1; j < size; j++) {
                for (int k=  j+1; k < size; k++) {
//                    int sum = data.get(i) + data.get(j) + data.get(k);
                    int sum = data[i] + data[j] + data[k];
                    if (sum % d == 0) {
                        count++;
                    }
                }
            }
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("Count: " + count + ", Time required: " + time);
    }
}
