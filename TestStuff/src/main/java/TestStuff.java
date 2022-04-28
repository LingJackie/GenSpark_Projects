import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class TestStuff {
    public static ArrayList<Integer> stuff(int nth) {
        if(nth == 0){
            return new ArrayList<Integer>(Arrays.asList(1));
        }
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= nth; i++){
            ArrayList<Integer> rowAbove = stuff(nth-1);
            if(i==0){
                row.add(1);
            }else if(i==nth) {
                row.add(1);
                break;
            }else if(rowAbove.size()>1){
                int sum = rowAbove.get(i-1)+rowAbove.get(i);
                row.add(sum);
            }
        }
        return row;
    }
    public static ArrayList<Integer> pascals(int nth) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(nth == 0){
            return new ArrayList<Integer>(Arrays.asList(1));
        }
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= nth; i++){
            ArrayList<Integer> rowAbove = pascals(nth-1);
            if(i==0){
                row.add(1);
            }else if(i==nth) {
                row.add(1);
                break;
            }else if(rowAbove.size()>1){
                int sum = rowAbove.get(i-1)+rowAbove.get(i);
                row.add(sum);
            }
        }
        return row;
    }

    public static ArrayList<Integer> maxSub(ArrayList<Integer> nums) {
        int globalStart =0;// Starting index of the global max sublist
        int currStart = 0;// Starting index of current sublist
        int end = 0;

        int globalMax = 0;
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            int currentElem = nums.get(i);

            sum+=currentElem;
            if(sum >= globalMax){// if current sum is greater than previous max
                globalMax = sum;
                end = i;// If current trend continues, end will keep incrementing
                globalStart = currStart;
            }
            if(sum <= 0){// When sum encounters negatives
                sum = 0;
                currStart = i+1;
            }
        }
        ArrayList<Integer> maxSublist = new ArrayList<Integer>(nums.subList(globalStart,end+1));

        return maxSublist;
    }

    // Edge case where sublist is [14,-3,3]; we want [14]
    // MaxSub method doesn't catch it so this will reverse the list and tries again
    public static ArrayList<Integer> checkEdgeCase(ArrayList<Integer> maxSublist) {
        Collections.reverse(maxSublist);
        ArrayList<Integer> lst = maxSub(maxSublist);
        Collections.reverse(lst);
        return  lst;
    }


    public static Stack<Integer> organizeStack(Stack<Integer> stack) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(stack.isEmpty()){
            return stack;
        }
        Stack<Integer> tmp = new Stack<Integer>();
        tmp.push(stack.pop());

        int currElem;
        while(!stack.isEmpty()){
            currElem = stack.pop();

            while(!tmp.isEmpty() && currElem < tmp.peek()) {
                int tmpElem = tmp.pop();
                stack.push(tmpElem);
            }
            tmp.push(currElem);
        }
        return tmp;
    }

    public Object[] filterMap(ArrayList<ArrayList<Integer>> listolists) {
        Object[] output = listolists.stream()// Convert to stream
                        .filter(innerArr -> innerArr.size() % 2 != 0)// Filter out inner arraylists with odd size
                        .map(innerArr -> innerArr.stream()// Convert inner ArrayList to stream
                                .map(num -> num *10)// Multiplies each element of inner Stream by 10
                                .collect(Collectors.toCollection(ArrayList<Integer>::new)))// Convert inner Stream back to ArrayList
                        .toArray(size -> new Object[size]);// Sticks the inner ArrayList into an Object array
        return output;
    }
    public static Object queryTheFile() {
        // ↓↓↓↓ your code goes here ↓↓↓↓

        try{
            Path filePath = Paths.get("src/main/resources/filter_problem.text");//needs try catch
            List<String> strList =  Files.readAllLines(filePath);

            return strList.stream()
                    .filter(str -> !str.contains("2"))
                    .collect(Collectors.toCollection(ArrayList<String>::new));


        }catch(Exception e){

            return new ArrayList<String>();
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrList1 = new ArrayList<Integer>(Arrays.asList(-14,-17,2,10,8,12,23,-13));
        ArrayList<Integer> arrList2 = new ArrayList<Integer>(Arrays.asList(5,-18,-34,4,10,-15,22,9,1,-10,21,28,-8,26,-12,28,8,2,-29,15,22,11,-27,32));
        ArrayList<Integer> arrList3 = new ArrayList<Integer>(Arrays.asList(4,-3,-5,-4,-9,4,-8,3,-7));//sublist is just [4]
        ArrayList<Integer> arrList4 = new ArrayList<Integer>(Arrays.asList(-14,3,-7,0,14,-3,3));// maxSublist is [14]
        ArrayList<Integer> arrList5 = new ArrayList<Integer>(Arrays.asList(-6,-2,0,-11,0,-11,-5,0,0,-1));// sublist should be [0]
        ArrayList<Integer> arrList6 = new ArrayList<Integer>(Arrays.asList(19,-10,5,27,-27,27,-16,-25,27,26));// sublist should be [27,26]
        ArrayList<Integer> arrList7 = new ArrayList<Integer>(Arrays.asList(14,-3,3));// sublist should be [14]
//
//        ArrayList<Integer> maxy2 = maxSub(arrList2);
//        ArrayList<Integer> maxy3 = maxSub(arrList3);
//        ArrayList<Integer> maxy4 = maxSub(arrList4);
//        ArrayList<Integer> maxy5 = maxSub(arrList5);
//        ArrayList<Integer> maxy6 = maxSub(arrList6);
//        ArrayList<Integer> maxy7 = checkEdgeCase(arrList7);
//        Stack<Integer> st = new Stack<Integer>();
//        st.push(-1); st.push(-14); st.push(-8); st.push(-3); st.push(15); st.push(1); st.push(8); st.push(0);
//        Stack<Integer> sorted = organizeStack(st);

        Object tmp = queryTheFile();
        int[] arr = new int[0];
        IntStream stream = Arrays.stream(arr);

    }


}
