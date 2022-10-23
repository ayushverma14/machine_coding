package Design_SnakeLadder_System;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

class Board {
    HashMap<Integer, Integer> snakes, ladders;
    ArrayList<String> players;
    ArrayList<Integer> positions;

    public Board()
    {
        players=new ArrayList<String>();
        positions=new ArrayList<Integer>();
        snakes=new HashMap<Integer,Integer>();
        ladders=new HashMap<Integer,Integer> ();

    }
// Control the moves of the playground 
    public boolean moves(int pos, int steps) {
        int initPos = positions.get(pos);
        positions.set(pos, positions.get(pos) + steps);
   

        if (snakes.get(positions.get(pos)) != null) {
            positions.set(pos, snakes.get(positions.get(pos)));
            System.out.println(
                    players.get(pos) + " rolled a " + steps + " and moved from " + initPos + " to " + positions.get(pos));

        } else if (ladders.get(positions.get(pos)) != null) {
            positions.set(pos, ladders.get(positions.get(pos)));
            System.out.println(
                    players.get(pos) + " rolled a " + steps + " and moved from " + initPos + " to " + positions.get(pos));

        } else {
            System.out.println(
                    players.get(pos) + " rolled a " + steps + " and moved from " + initPos + " to " + positions.get(pos));

        }

        if (positions.get(pos) >= 100)
            return true;
        else
            return false;
    }
}