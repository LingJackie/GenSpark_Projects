import java.util.ArrayList;
import java.util.Arrays;

public class ReverseAString {

    public static String reverseIter(String str){
        ArrayList<String> tmplst = new ArrayList<String>(Arrays.asList(str.split("")));
        return tmplst.stream().reduce("", (sum , elem)-> elem + sum);
    }

    public static String reverseRecur(String str){
        if(str.isEmpty()){
            return "";
        }else{
            return reverseRecur(str.substring(1, str.length())) + str.substring(0,1);
        }
    }

    public static void main(String[] args){
        System.out.println(reverseIter("genspark"));
        System.out.println(reverseRecur("genspark"));
    }
}
