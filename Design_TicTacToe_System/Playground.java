package Design_TicTacToe_System;

import java.util.ArrayList;

class User {
    String name;
    char symbol;

    public User(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }
}

public class Playground {

    int n;
    char area[][];
    ArrayList<User> user;
    int fills;

    public Playground(int n) {
        this.n = n;
        area = new char[n][n];
        user = new ArrayList<User>();
        fills = 0;
        // Prepares the playground
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] = '_';
            }
        }
    }

    public void addUser(char symbol, String name) {
        User u1 = new User(symbol, name);
        user.add(u1);
    }

    // Displays the PlayArea
    public void display() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(area[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Does validation
    public boolean validate(char symbol) {

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.area[i][j] == symbol) {
                    int f = 0;
                    for (int p = 0; p < this.n; p++) {
                        if (this.area[i][p] != symbol) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 0)
                        return true;
                    f = 0;
                    for (int p = 0; p < this.n; p++) {
                        if (this.area[p][j] != symbol) {
                            f = 1;
                            break;
                        }
                    }
                    if (f == 0)
                        return true;
                    if (i == j) {
                        for (int p = 0; p < n; p++) {
                            if (this.area[p][p] != symbol) {

                                f = 1;
                            }
                        }
                        if (f == 0)
                            return true;
                    }
                    if (i == n - 1 - j) {
                        for (int p = 0; p < n; p++) {
                            if (this.area[p][n - p - 1] != symbol) {
                                f = 1;
                            }
                        }
                        if (f == 0)
                            return true;
                    }

                }
            }
        }
        return false;
    }

    // Fills the Chessboard
    public boolean fill(int x, int y, char symbol) {
        try {
            if (area[x][y] == '_')
                area[x][y] = symbol;
            else
                return false;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}