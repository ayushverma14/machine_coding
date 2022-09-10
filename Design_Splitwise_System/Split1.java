package Design_Splitwise_System;

import java.util.*;

//USER CLASS
class User {
    String userid;
    String name;
    String mobile;

    HashMap<String, Double> expenses;

    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
        expenses = new HashMap<String, Double>();
    }
}

// SPLIT CLASS FOR MANAGING SPLIT OPERATIONS
public class Split1 {

    int num;
    ArrayList<User> users;
    HashMap<String, User> hp;

    public Split1(int num) {
        this.num = num;
        users = new ArrayList<User>();
        hp = new HashMap<String, User>();
        for (int i = 0; i < num; i++) {
            String us = "u" + (i + 1);
            User us1 = new User(us, "");
            users.add(us1);
            hp.put(us, us1);
        }
    }

    // showing result for the SHOW operation
    public void show() {
        for (int i = 0; i < users.size(); i++) {
            for (Map.Entry<String, Double> m : users.get(i).expenses.entrySet()) {
                String owner = m.getKey();
                Double balance = m.getValue();
                System.out.println(owner + " owes " + users.get(i).name + ":" + balance);

            }
        }
    }

    // showing operation for the given UserID
    public void show(User userID) {

        for (Map.Entry<String, Double> m : userID.expenses.entrySet()) {
            String owner = m.getKey();
            Double balance = m.getValue();
            System.out.println(owner + " owes " + userID.name + ":" + balance);

        }

    }

    public ArrayList<Double> divide(double amt, String term, int n, ArrayList<Double> div) {

        ArrayList<Double> arr = new ArrayList<Double>();

        if (term.equals("EQUAL")) {
            double p = amt / n;
            for (int i = 0; i < n; i++) {
                arr.add(p);
            }
        } else if (term.equals("EXACT")) {

            for (int i = 0; i < n; i++) {
                arr.add(div.get(i));

            }
        } else if (term.equals("PERCENT")) {
            for (int i = 0; i < n; i++) {
                double x = (div.get(i) / 100.0) * (amt);
                arr.add(x);
            }

        }

        return arr;

    }

    public void AddUser(String userID, String name, String phone) {
        User u1 = new User(name, phone);
        users.add(u1);
        hp.put(name, u1);
    }

    // Partitioning money on the basis of TERM:EXACT,EQUAL and PERCENT
    public void partition(String u1, double amt, int n, ArrayList<User> users, String term, ArrayList<Double> divs) {

        ArrayList<Double> div = divide(amt, term, n, divs);
        double sum = 0;
        for (Double i : div) {
            sum += i;
        }
        if (sum != amt) {
            System.out.println("Invalid Values for division");
            return;
        }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).expenses.get(u1) != null) {
                users.get(i).expenses.put(u1, div.get(i) + users.get(i).expenses.get(u1));
            } else {
                users.get(i).expenses.put(u1, div.get(i));
            }
        }

    }

}