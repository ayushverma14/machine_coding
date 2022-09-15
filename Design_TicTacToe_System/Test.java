package Design_TicTacToe_System;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    public Test() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// size of TicTacToe
        Playground pl = new Playground(n);
        int us = 0;
        int count = 0;

        while (true) {
            pl.display();
            String op[] = br.readLine().split(" ");

            if (op.length == 2) {
                try {
                    int x = Integer.parseInt(op[0]) - 1;
                    int y = Integer.parseInt(op[1]) - 1;
                    boolean res = pl.fill(x, y, pl.user.get(us % count).symbol);
                    if (res) {
                        System.out.println("Filled Successfully");
                        boolean res1 = pl.validate(pl.user.get(us % count).symbol);
                        if (res1) {
                            System.out.println(pl.user.get(us % count).name + " won game");
                            break;
                        }
                        pl.fills++;
                        us++;
                    } else
                        System.out.println("Invalid move");

                } catch (Exception e) {
                    pl.addUser(op[0].charAt(0), op[1]);
                    count++;
                }
            } else if (op[0].equals("exit"))
                break;
            // Checking if board is filled totally
            if (pl.fills == (pl.n * pl.n)) {
                System.out.println("GAME OVER");
                break;
            }
        }

    }

}
