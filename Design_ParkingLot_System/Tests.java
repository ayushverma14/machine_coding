package Design_ParkingLot_System;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Allowed vehicle types are : Cars,Buses,Bikes
public class Tests {
    public static int free_count(ParkingLot pl) {
        int count = 0;
        String types[] = { "Cars", "Buses", "Trucks" };
        for (String type : types) {
            for (int i = 0; i < pl.numFloors; i++) {
                for (int j = 0; j < pl.arr.size(); j += 1) {

                    for (int k = 0; k < pl.arr.get(j).arr.size(); k++) {
                        if (pl.arr.get(j).arr.get(k).type.equals(type) && pl.arr.get(j).arr.get(k).occupied == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static int free_slots(ParkingLot pl, String type) {
        int count = 0;

        for (int j = 0; j < pl.arr.size(); j += 1) {
            for (int k = 0; k < pl.arr.get(j).arr.size(); k++) {
                boolean f1 = true, f2 = true;
                if ((f1 = pl.arr.get(j).arr.get(k).type.equalsIgnoreCase(type.trim()))
                        && (f2 = (pl.arr.get(j).arr.get(k).occupied == 0))) {
                    count++;
                }
                System.out.println(f1 + " " + f2);
            }
        }

        return count;
    }

    // Count of occupied_slots by the given vehicle type
    public static int occupied_slots(ParkingLot pl, String type) {
        int count = 0;

        for (int j = 0; j < pl.arr.size(); j += 1) {
            for (int k = 0; k < pl.arr.get(j).arr.size(); k++) {

                if (pl.arr.get(j).arr.get(k).type.equals(type.trim()) && pl.arr.get(j).arr.get(k).occupied == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    // function to park the vehicle
    public static boolean park(ParkingLot pl, String type, String model, String color) {
        for (int i = 0; i < pl.arr.size(); i++) {
            for (Floor f : pl.arr) {
                for (Slot s : f.arr) {
                    if (s.type.equals(type) && s.occupied == 0) {
                        s.model = model;
                        s.color = color;
                        s.occupied = 1;
                        System.out.println("Parked Successfully ");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /// Method for testing agianst file Input
    public static void testAgainstFile(String[] file) {
        ParkingLot pl = null;
        for (int i = 0; i < file.length; i++) {
            String op[] = file[i].split(" ");
            if (op.length == 4) {
                if (op[0].equalsIgnoreCase("create_parking_Lot")) {

                    pl = new ParkingLot(op[1], Integer.parseInt(op[2]), Integer.parseInt(op[3]));

                } else if (op[0].equals("park_vehicle")) {
                    pl.parkingvehicle(op[1], op[2], op[3]);
                } else if (op[0].equals("unpark_vehicle"))
                    pl.unparkingvehicle(op[1]);
            } else if (op.length == 3) {
                if (op[0].equals("display")) {
                    if (op[1].equals("free_count")) {
                        System.out.println("total free count" + ":" + free_count(pl));
                    } else if (op[1].equals("free_slot"))

                    {
                        System.out.println("Free Slot: " + free_slots(pl, op[2]));
                    } else if (op[1].equals("occupied_slots"))
                        System.out.println("Occupied Slot: " + occupied_slots(pl, op[2]));

                }
            } else if (op[0].equals("DisplayLot")) {
                if (pl == null)
                    System.out.println("Lot empty");
                else {
                    System.out.println(pl.name);
                    pl.display();
                }
            } else if (op[0].equals("exit"))
                break;

        }

    }

    // Main function to test the code
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ParkingLot pl = null;
        ////////// ///////////////////
        // To test the code against the input file mentioned in the inputtxt
        // Paste the array from the TestsInputFile.txt into this file[] array and
        ////////// uncomment thebelow portion
        // String file[]={};
        // testAgainstFile(file);

        ///////
        while (true) {
            String op[] = br.readLine().split(" ");
            if (op.length == 4) {
                if (op[0].equalsIgnoreCase("create_parking_Lot")) {

                    pl = new ParkingLot(op[1], Integer.parseInt(op[2]), Integer.parseInt(op[3]));

                } else if (op[0].equals("park_vehicle")) {
                    pl.parkingvehicle(op[1], op[2], op[3]);
                } else if (op[0].equals("unpark_vehicle"))
                    pl.unparkingvehicle(op[1]);
            } else if (op.length == 3) {
                if (op[0].equals("display")) {
                    if (op[1].equals("free_count")) {
                        System.out.println("total free count" + ":" + free_count(pl));
                    } else if (op[1].equals("free_slot"))

                    {
                        System.out.println("Free Slot: " + free_slots(pl, op[2]));
                    } else if (op[1].equals("occupied_slots"))
                        System.out.println("Occupied Slot: " + occupied_slots(pl, op[2]));

                }
            } else if (op[0].equals("DisplayLot")) {
                if (pl == null)
                    System.out.println("Lot empty");
                else {
                    System.out.println(pl.name);
                    pl.display();
                }
            } else if (op[0].equals("exit"))
                break;

        }
    }
}

// Slot class
class Slot {
    int occupied;
    String type;
    String model;
    String color;

    public Slot(String type, String model, String color) {
        this.type = type;
        this.occupied = 0;
        this.model = model;
        this.color = color;
    }
}

// Floor class
class Floor {
    int slots;
    ArrayList<Slot> arr;

    public Floor(int s) {
        this.slots = s;
        int cars = (int) (Math.random() * 10) % slots;
        int buses = (int) (Math.random() * 10) % (slots - cars);
        int bikes = slots - cars - buses;
        arr = new ArrayList<Slot>();
        for (int i = 0; i < 2; i++)

        {
            arr.add(new Slot("Cars", "None", "None"));

        }
        for (int i = 0; i < 2; i++) {
            arr.add(new Slot("Buses", "None", "None"));

        }
        for (int i = 0; i < slots - 4; i++) {
            arr.add(new Slot("Bikes", "None", "None"));

        }
        System.out.println("floors added");
    }

}

// Parking Lot class
class ParkingLot {
    String name;
    int numFloors;
    int slots;
    ArrayList<Floor> arr;

    public ParkingLot(String name, int num, int slots) {
        this.name = name;
        this.numFloors = num;
        this.slots = slots;
        arr = new ArrayList<Floor>();
        for (int i = 0; i < numFloors; i++) {
            Floor f = new Floor(slots);
            arr.add(f);

        }
        System.out.println("Lot Created");
    }

    public void parkingvehicle(String type, String mod, String color) {
        int f = 0;
        for (int i = 0; i < this.arr.size(); i++) {
            for (int j = 0; j < this.arr.get(i).arr.size(); j++) {
                if (this.arr.get(i).arr.get(j).type.equals(type.trim()) && this.arr.get(i).arr.get(j).occupied == 0) {
                    this.arr.get(i).arr.get(j).model = mod;
                    this.arr.get(i).arr.get(j).occupied = 1;
                    this.arr.get(i).arr.get(j).color = color;
                    System.out.println("Vehicle parked at : floor:" + i + "slot:" + j);
                    f = 1;
                    break;
                }

            }
            if (f == 1)
                break;
        }
        if (f == 0)
            System.out.println("Lot full");
    }

    public void unparkingvehicle(String mod) {
        int f = 0;
        for (int i = 0; i < this.arr.size(); i++) {
            for (int j = 0; j < this.arr.get(i).arr.size(); j++) {
                if (this.arr.get(i).arr.get(j).model.equalsIgnoreCase(mod)) {
                    this.arr.get(i).arr.get(j).model = "None";
                    this.arr.get(i).arr.get(j).occupied = 0;
                    this.arr.get(i).arr.get(j).color = "None";
                    System.out.println("Vehicle unparked at : floor:" + i + "slot:" + j);
                    f = 1;
                    break;
                }

            }
            if (f == 1)
                break;
        }
        if (f == 0)
            System.out.println("Not Found");
    }

    public void display() {
        for (int i = 0; i < this.arr.size(); i++) {
            System.out.println("Floor:" + (i));
            for (int j = 0; j < this.arr.get(i).arr.size(); j++) {
                Slot s = this.arr.get(i).arr.get(j);
                System.out.println(s.type + " " + s.occupied + " " + s.model + " " + s.color);
            }

        }
    }
}
