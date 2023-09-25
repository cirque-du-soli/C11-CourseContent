package com.solifsd08.slay.stencil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SLAYSTENCILREFERENCE {
    
    public static void ssrMethod1() {
        System.out.println("oi. SSR method 1");
    }
    
    //////// MISC
    /*
    @SuppressWarnings("unchecked")
    
    
    
    
    */
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// METHODS and CONTEXTS /////////////////////
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    ////////////////////////////////////////////////////////////// Get if exists
    static int getIfExists(int[][] data, int row, int col) {
        // If exists, return the element, otherwise return 0
        try {
            // seems elegant, a simple if may be better
            return data[row][col];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }
    

    ////////////////////////////////////////////////////// timing the operations
    static void measureSpeed() {
        long startTime1 = System.currentTimeMillis();
        System.out.println("Time passed (miliseconds): " + (System.currentTimeMillis() - startTime1));
    }
    
    
    ////////////////////////////////////////////////// finding unique duplicates
    static int[] findDuplicates(int[] a1, int[] a2) {
        int[] dups = new int[Math.min(a1.length, a2.length)];
        int dupsFound = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    // duplicate found but is it unique? (did we see it before?)
                    boolean isUnique = true;
                    for (int k = 0; k < dupsFound; k++) {
                        if (dups[k] == a1[i]) {
                            isUnique = false; // already in dups
                            break;
                        }
                    }
                    if (isUnique) {
                        dups[dupsFound++] = a1[i];
                    }
                }
            }
        }
        // allocate a new array and copy the final result to return it
        int[] finalDups = new int[dupsFound];
        for (int i = 0; i < dupsFound; i++) {
            finalDups[i] = dups[i];
        }
        return finalDups;
    }
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////// Printing, toString(), Formatting
    ////////////////////////////////////////////////////////////////////////////
    

    //////////////////////////////////////////////////////// System.out.printf()
    /////////////////////////////////////////////////////////// Turnary operator
    
    // 1D
    static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%s%d", (i == 0 ? "" : ", "), data[i]);
        }
        System.out.println();
    }
    
    // 2D
    // TL;DR: System.out.printf("%s%d", (col == 0 ? "" : ", "), itemToPrint);
    static void print2D(int[][] data2d) {
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("%s%d", (col == 0 ? "" : ", "), data2d[row][col]);
            }
        }
    }
    
    // 2D ////////////////////////////////////// dynamically adjust column sizes
    static void printArraySmart(int[][] data2d) {
        // 1: find the maximum row length
        int maxRowLength = 0;
        for (int row = 0; row < data2d.length; row++) {
            // maxRowLength = Math.max(maxRowLength, data2d[row].length);
            maxRowLength = (maxRowLength > data2d[row].length) ? maxRowLength : data2d[row].length;
        }
        // 2: allocate colWidth array and fill it in with column widths (max string size of each cell)
        int[] colsWidth = new int[maxRowLength];
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                // String dataStr = data2d[row][col] + "";
                // int length = dataStr.length();
                int length = String.valueOf(data2d[row][col]).length();
                colsWidth[col] = Math.max(colsWidth[col], length);
            }
        }
        // 3: print data with columns appropriately sized
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("%s%" + colsWidth[col] + "d", (col == 0 ? "" : ", "), data2d[row][col]);
            }
            System.out.println();
        }
    }
    
    
    ////////////////////////////////////////////////////////////// StringBuilder
    ///////////////////////////////////////////// same as above, but no turnery
    // return values, comma separated, single line
    /*
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<Integer, Long> entry : fibsCached.entrySet()) {
            if (first) {
                result.append(String.format("%d", entry.getValue()));
                first = false;
            } else {
                result.append(String.format(", %d", entry.getValue()));
            }
        }
        return result.toString();
    }
    */
    /* /////////////////////////////////////////////////////// custom toString()
    @Override
    public String toString() {
        return "Car{" + "makeModel=" + makeModel + ", engineSizeL=" + engineSizeL + ", prodYear=" + prodYear + '}';
    }
    */



    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////// Comparable & Comparator
    ////////////////////////////////////////////////////////////////////////////
    
    /*
    ////////////////////////////////////////////////////////// The Class itself:
    
    public class Car implements Comparable<Car> {

        // for comparing floats!! must account for Java approximation error!
        static final double FP_THRESHOLD = 0.000000001;

        String makeModel;
        double engineSizeL;
        int prodYear;

    public Car(String makeModel, double engineSizeL, int prodYear) {
        this.makeModel = makeModel;
        this.engineSizeL = engineSizeL;
        this.prodYear = prodYear;
    }
    
    ////////////////////////////////////////////////////////////////// .equals()
    @Override
    public boolean equals(Object o) {
        Car c = (Car) o;
        System.out.println("Equals on car called");
        return (makeModel.equals(c.makeModel) && engineSizeL == c.engineSizeL && prodYear == c.prodYear);
    }

    //////////// getters, setters, and toString go here like normally in a Class
    
    ///////////////////////////////////////////////// Field COMPARISON 1: String
    /////////////////////////////////////// simple .compareTo() within the class
    @Override
    public int compareTo(Car o) {
        return makeModel.compareTo(o.makeModel); //this just compare
    }

    /////////////////////////////////////////////////// Field COMPARISON 2: ints
    ////////////////////////////////////////////////////// CREATE INNER CLASS !!
    
    public static final CarsSortByProdYear sortByProdYear = new CarsSortByProdYear();
    static class CarsSortByProdYear implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            System.out.print("C ");
            return o1.prodYear - o2.prodYear;
        }
    }

    ///////////////////////////////////////////////// Field COMPARISON 3: floats
    ////////////////////////////////////////////////////// CREATE INNER CLASS !!
    
    public static final CarSortByEngineSizeComparator sortByEngineSizeComparator = new CarSortByEngineSizeComparator();
    static class CarSortByEngineSizeComparator implements Comparator<Car> {

        @Override
        public int compare(Car car1, Car car2) {
    
            // WITHOUT TOLERANCE
            // WRONG: return (int)(car1.engineSizeL - car2.engineSizeL); 
            if (car1.engineSizeL == car2.engineSizeL) {
                return 0;
            }
            return (car1.engineSizeL > car2.engineSizeL) ? 1 : -1;
    
            // WITH TOLERANCE
            if (Math.abs(car1.engineSizeL - car2.engineSizeL) < FP_THRESHOLD) return 0;
            return (car1.engineSizeL > car2.engineSizeL) ? 1 : -1;
    
            // works for integer value 
            return (int) (1000000 * car1.engineSizeL) - (int) (1000000 * car2.engineSizeL); 
        }
    }
    
    /////////////////////////////////////////////// MAKING COMPARISONS / SORTING
    // 1. Natural sort by make model using COMPARABLE
    Collections.sort(parking);
    for (Car car : parking) {
        System.out.println(car);
    }

    // 2a. Sort by engine size using COMPARATOR
    Collections.sort(parking, Car.sortByEngineSizeComparator);
    for (Car car : parking) {
        System.out.println(car);
    }
    
    // 2b. Sort by prod year using: full anonymous method. COMPARATOR, LAMBDA
    parking.sort((Car c1, Car c2) -> {
        return c2.prodYear - c1.prodYear;
    });
    
    // 2c. short notation, one expression. COMPARATOR, LAMBDA
    parking.sort((Car c1, Car c2) -> c2.prodYear - c1.prodYear);
    
    // 3. MULTIPLE COMPARISONS
    // sort by prod year then make model. MAKING + USING COMPARATOR
    // MAKE COMPARATOR
    Comparator<Car> compProdYearMakeModel = Comparator.comparing(Car::getProdYear).thenComparing(Car::getMakeModel); //.reversed();
    // PASS COMPARATOR TO obj that extends comparable
    parking.sort(compProdYearMakeModel); 

    // followup print of the arrayList
    for (Car car : parking) {
        System.out.println(car);
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// I/O & File Read-Write
    ////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////// Reading Data from File
    
    // STEPS:
    // 1. TRY: Scanner() with File(). BufferedReader is ok (see soli's version)
    // 2. While loop (each line)
    // 3. TRY encloses whole content of loop
    // 4. Validate line: proper # of components
    // 5. Validate components: (try catch parseInts, parseFloat, etc)
    // 6. Create new object and populate it with the data
    // 7. Add object to wherever it goes (arrayList etc)
    /*

    // e.g. this is a method within the main method.
    static void readDataFromFile() {
            
        try (Scanner fileInput = new Scanner(new File("cars.txt"))) {
            while (fileInput.hasNextLine()) {
                try {
                    String line = fileInput.nextLine();
                    String[] data = line.split(";");
                    if (data.length != 3) {
                        System.out.println("Error in line, skipping");
                        continue;
                    }
                    String makeModel = data[0];
                    double engSize = Double.parseDouble(data[1]); // ex NumberFormatException
                    int yop = Integer.parseInt(data[2]); // ex NumberFormatException
                    parking.add(new Car(makeModel, engSize, yop));
                } catch (NumberFormatException ex) {
                    System.out.println("Error in line, skipping: " + ex);
                }
            }
        } catch (IOException ex) {
            System.out.println("Fatal error reading file: " + ex);
        }
    }    
    */
    
    /////////////////////////////////////////////////// Get Data from user input
    ///// these methods exist with the class, not in the main method
    
    public static Scanner input = new Scanner(System.in);

    static int inputInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException ex) {
                input.nextLine(); // consume the invalid input
                System.out.println("Not an integer, try again.");
            }
        }
    }

    static void inputArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Enter value %d: ", i + 1);
            data[i] = inputInt();
        }
    }

    static void inputArray(int[][] data2d) {
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("Enter value row %d column %d: ", row + 1, col + 1);
                data2d[row][col] = inputInt();
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////// EXCEPTIONS
    ////////////////////////////////////////////////////////////////////////////
    // AVAILABLE BY DEFAULT: 
    // 1. Illegal Argument Exception
    // 2. 
    // 3. 
    
    // 1. IllegalArgumentException
    public long getNthFib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("No negative fibonacci exist");
        }
        // return computeNthFib(n);
        return 1; 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////// HashMaps
    ////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////// general navigation
    
    /*   
    // because a hashmap is an arrayList of arrayLists of type of the hashmap
    for (String memberName : teamMembers) {
        if (!playersWithTeams.containsKey(memberName)) {
            // player not found, create a new entry (list with one item)
            ArrayList teamsList = new ArrayList();
            teamsList.add(teamName);
            playersWithTeams.put(memberName, teamsList);
        } else {
            // player is found, add team name to an existing entry
            ArrayList<String> teamsList = playersWithTeams.get(memberName);
            teamsList.add(teamName);
        }
    }
    
    // done reading file, display the result
    for (String memberName : playersWithTeams.keySet()) {
        ArrayList<String> teamsList = playersWithTeams.get(memberName);
        System.out.printf("%s plays in : %s\n", memberName, String.join(", ", teamsList));
    }
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////// Lambdas
    ////////////////////////////////////////////////////////////////////////////
    /*    
    ////////////////////////////////////////////////////////////// normal lambda
    parking.sort((Car c1, Car c2) -> {
        return c2.prodYear - c1.prodYear;
    });
    
    ///////////////////////////////////////////////////////////// short notation
    parking.sort((Car c1, Car c2) -> c2.prodYear - c1.prodYear);
    
    // (followup print of the parking arrayList)
    for (Car car : parking) {
        System.out.println(car);
    }
    */
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////// Iterable & Iterator
    ////////////////////////////////////////////////////////////////////////////
    /*    

    //////////////////////////////////////////////// 1. Integer structure example
    // BinaryTreeOfInts
    public class BinaryTreeOfInts implements Iterable<Integer> {

        // THIS GOES IN THE DATASTRUCTURE'S CLASS
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                int [] data = getValuesInOrder(); // MUST USE "get all vals" method!!
                int nextItemIndex = 0;

                @Override
                public boolean hasNext() {
                    return (nextItemIndex < data.length);
                }

                @Override
                public Integer next() {
                    return data[nextItemIndex++];
                }
            };
        }
    
    
    
    
    
    
    
    
    */















}