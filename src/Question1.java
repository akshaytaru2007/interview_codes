import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question1 {
    public void run() {
        int n= 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:3");
        logs.add("1:end:6");
        logs.add("0:end:10");
        getTotalExecutionTime(n, logs);
    }


    public static int[] getTotalExecutionTime(int n, List<String> logs) {
        // Write your code here

        int [] numbers = new int [n];
        int arraySize = getMaxArraysize(logs);
        int [] functionQue = new int [arraySize + 1];
        for (int i = 0; i <logs.size(); i++) {

            String item = logs.get(i);
            String[] functionDetails = item.split(":");
            int functionId = Integer.parseInt(functionDetails[0]);
            String functionName = functionDetails[1];
            int functionTime = Integer.parseInt(functionDetails[2]);

            if (functionName.equals("start")) {
                functionQue[functionTime] = functionId;

                for (int j=i+1; j<logs.size(); j++) {

                    String nextItem = logs.get(j);
                    String[] nextFunctionDetails = nextItem.split(":");
                    int newFunctionId = Integer.parseInt(nextFunctionDetails[0]);
                    String newFunctionName = nextFunctionDetails[1];
                    int newFunctionTime = Integer.parseInt(nextFunctionDetails[2]);
                    if (newFunctionId == functionId && newFunctionName.equals("end")) {
                        copyFunctionId(functionQue, functionId, functionTime, newFunctionTime);
                        break;
                    }
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<functionQue.length; i++) {
            set.add(functionQue[i]);
        }

        int numberIndex = 0;
        for (Integer item : set) {
            int count = 0;
            for (int i : functionQue) {
                if (item == i) {
                    count++;
                }

            }
            numbers[numberIndex++] = count;
        }

        for (Integer number : numbers) {
            System.out.println(number);
        }
        return numbers;
    }

    private static void copyFunctionId(int[] functionQue,int functionId,  int startIndex, int endIndex) {
        int currentIndex = startIndex;
        while (currentIndex < endIndex) {
            functionQue[currentIndex] = functionId;
                currentIndex++;
        }
        functionQue[currentIndex] = functionId;
    }

    private static int getMaxArraysize(List<String> logs) {
        int max = 0;
        for (int i=0 ; i < logs.size(); i++) {
            String item = logs.get(i);
            String[] content = item.split(":");
            int arrayIndex = Integer.parseInt(content[2]);
            max = Math.max(max, arrayIndex);
        }
        return max;
    }

}
