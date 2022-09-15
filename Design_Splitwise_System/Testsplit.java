package Design_Splitwise_System;

import java.io.*;
import java.util.*;

/////////////////////////////////////
//TEST-CLASS
public class Testsplit extends Split1 {

    public Testsplit(int num) {
        super(num);
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]) throws IOException {
        Test();
    }

    public static void Test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 4;
        Split1 ss = new Split1(4);

        while (true) {
            String op[] = br.readLine().split(" ");
            if (op[0].trim().equals("SHOW")) {
                if (op.length == 1)
                    ss.show();
                else
                    ss.show(ss.hp.get(op[1].trim()));
            } else if (op[0].equals("EXPENSE")) {
                String source = op[1].trim();
                double amt = Double.parseDouble(op[2]);
                int n = Integer.parseInt(op[3]);
                ArrayList<User> users = new ArrayList<User>();
                for (int i = 0; i < n; i++) {
                    users.add(ss.hp.get(op[4 + i].trim()));
                }
                String term = op[4 + n];
                ArrayList<Double> arr = new ArrayList<Double>();
                if (term.equals("EQUAL") == false)
                    for (int i = 0; i < n; i++) {
                        arr.add(Double.parseDouble(op[4 + n + 1 + i]));
                    }
                ss.partition(source, amt, n, users, term, arr);

            } else if (op[0].equals("exit")) {
                break;
            }

        }

    }

}

