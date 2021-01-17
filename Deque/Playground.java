import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Playground {
    private Deque<Integer> left = new ArrayDeque<Integer>();
    private Deque<Integer> right = new ArrayDeque<Integer>();
    private int size = 0;
    private int count1 = 0;
    private int count2 = 0;

    public String deque(String cmd, int arg) {
        StringBuilder sb = new StringBuilder();

        if (cmd.equals("PushLeft")) {
            if (count1+count2 < size) {
                left.offerFirst(arg);
                count1++;
                sb.append("Push Left : ");
                sb.append(arg);
                return sb.toString();
            } else {
                sb.append("Deque is full!");
                return sb.toString();
            }
        } else if (cmd.equals("PushRight")) {
            if (count1+count2 < size) {
                right.offerFirst(arg);
                count2++;
                sb.append("Push Right : ");
                sb.append(arg);
                return sb.toString();
            } else {
                sb.append("Deque is full!");
                return sb.toString();
            }

        } else if (cmd.equals("PollLeft")) {
            if (count1+count2 > 0) {
                if (count1 <= 0 ) {
                    left.offerFirst(right.pollFirst());
                    count1++;
                    count2--;
                }
                    int n = left.pollFirst();
                    count1--;
                    sb.append("Push Left : ");
                    sb.append(n);
                    return sb.toString();
            } else {
                sb.append("No element left!");
                return sb.toString();
            }
        } else if (cmd.equals("PollRight")) {
            if (count1+count2 > 0) {
                if (count2 <= 0 ) {
                    right.offerFirst(left.pollFirst());
                    count1--;
                    count2++;
                }
                int n = right.pollFirst();
                count2--;
                sb.append("Push Right : ");
                sb.append(n);
                return sb.toString();
            } else {
                sb.append("No element left!");
                return sb.toString();
            }
        } else {
            return (sb.append("Illegal Command! Please type again")).toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        int a[] = new int[2]; //  size, num of cmd
        a[0] = Integer.valueOf(s1[0]);
        a[1] = Integer.valueOf(s1[1]);


        Playground sol = new Playground();
        sol.size = a[0];
        for (int i = 0; i < a[1]; i++) {
            if (in.hasNextLine()) {
                String[] s = in.nextLine().split(" ");
                if (s.length == 2) {
                    String cmd = s[0];
                    int arg = Integer.valueOf(s[1]);
                    String ans = sol.deque(cmd, arg);
                    System.out.println(ans);
                } else {
                    String cmd = s[0];
                    String ans = sol.deque(cmd, 0);
                    System.out.println(ans);
                }
            } else {
                System.out.println("Invalid command!");
                continue;
            }
        }
    }
}


