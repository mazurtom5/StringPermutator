import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Permutator {
    public static void main(String[] args) {
//        Scanner uInput = new Scanner(System.in);

        String input = "meat";


        Set<String> perms = stringPerm( input );
        System.out.println(perms);
    }

    public static HashSet<String> stringPerm( String a ) {
        Stack<String> things = new Stack<>();
        HashSet<String> answer = new HashSet<>();
        a = "+" + a;
        things.push(a);
        String current;
        StringBuilder moreCurrent;
        int plusPos;
        while ( !things.empty() ) {
            current = things.pop();
            if ( current.charAt( current.length() - 1 ) == '+' )
                answer.add( current.substring(0, current.length() - 1 ) );
            else {
                plusPos = current.indexOf("+");
                for (int i = plusPos + 1; i < current.length(); i++) {
                    moreCurrent = new StringBuilder(current);
                    moreCurrent.insert( plusPos, moreCurrent.charAt(i) );
                    moreCurrent.deleteCharAt(i+1);
                    things.push(moreCurrent.toString());
                }
            }
        }

        return answer;
    }
}
