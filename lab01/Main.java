package lab01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String userInput = "";
        while (userInput.toUpperCase().compareTo("Q") != 0) {
            System.out.println("Which level do you want to try?");
            System.out.println("1. Reach the finish line");
            System.out.println("2. All commands up front");
            System.out.println("3. Hack the path");
            System.out.println("4. You are the one");
            System.out.println("5. Random Maze");
            System.out.println("6. Code solution for random maze");
            System.out.println("Q. Quit");
            System.out.print("> ");
            userInput = s.nextLine().toUpperCase();
            if (userInput.compareTo("1") == 0)
                level1();
            if (userInput.compareTo("2") == 0)
                level2();
            if (userInput.compareTo("3") == 0)
                level3();
            if (userInput.compareTo("4") == 0)
                level4();
            if (userInput.compareTo("5") == 0)
                level5();
            if (userInput.compareTo("6") == 0)
                level6();
        }
    }

    public static int[][] copy(int[][] moose) {
        int[][] photo = new int[moose.length][moose[0].length];

        for (int i = 0; i < photo.length; i++)
            for (int x = 0; x < photo[i].length; x++)
                photo[i][x] = moose[i][x];
        return photo;
    }

    public static void level1() {
        // This is the maze, it's stored as a 2-d array.
        // 0 = Empty spot
        // 1 = You facing north
        // 2 = You facing east
        // 3 = You facing south
        // 4 = You facing west
        // 5 = Finish line
        // 6 = Obstacle
        int[][] m = { { 6, 6, 0, 0, 0 }, { 0, 0, 6, 0, 6 }, { 0, 6, 5, 0, 0 }, { 0, 1, 6, 6, 0 }, { 0, 0, 0, 0, 0 } };
        playManualUnlimited(m);
        System.out.print("G");
        for (int i = 0; i < 200; i++) {
            System.out.print("o");
        }
        for (int i = 0; i < 200; i++) {
            System.out.print("a");
        }
        for (int i = 0; i < 200; i++) {
            System.out.print("l");
        }
        for (int i = 0; i < 200; i++) {
            System.out.print("!");
        }
        System.out.println("\n");
    }

    public static void level2() {
        // This is the maze, it's stored as a 2-d array.
        // 0 = Empty spot
        // 1 = You facing north
        // 2 = You facing east
        // 3 = You facing south
        // 4 = You facing west
        // 5 = Finish line
        // 6 = Obstacle
        int[][] m = { { 6, 0, 0, 0, 0 }, { 0, 0, 6, 0, 6 }, { 0, 6, 5, 0, 6 }, { 0, 1, 6, 6, 0 }, { 0, 0, 0, 0, 0 } };
        playManualOnce(m);
        int[] coordinate = find(m, 5);
        if (coordinate == null)
            System.out.println("Anybody can do that, now go study math.");
        else
            System.out.println("Go study math.");
        System.out.println();
    }

    public static void level3() {
        clearScreen();
        int[][] m = { { 6, 0, 0, 0, 0 }, { 0, 0, 6, 0, 6 }, { 0, 6, 5, 0, 6 }, { 0, 1, 6, 6, 0 }, { 0, 0, 0, 0, 0 } };
        // Write your code here, between the comments:
        turnLeft(m);
        moveForward(m);
        turnRight(m);
        moveForward(m);
        moveForward(m);
        turnRight(m);
        moveForward(m);
        turnLeft(m);
        moveForward(m);
        turnRight(m);
        moveForward(m);
        moveForward(m);
        turnRight(m);
        moveForward(m);
        moveForward(m);
        turnRight(m);
        moveForward(m);
        // Do not change the code below this line.
        printMap(m);
        System.out.println("Level 3: This level requires code hacking! (Changing the code in the compiler.)");
        System.out.println("In this level, you must write your action out in code and replay this level.");
        System.out.println(
                "Find the level3() function, and use the turnLeft(), turnRight(), and moveForward() functions.\n");
        int[] coordinate = find(m, 5);
        if (coordinate == null)
            System.out.println("Congratulations!!!");
        else
            System.out.println("You failed");
        pressEnterToContinue();
    }

    public static void level4() {
        clearScreen();
        int[][] m = { { 1, 6, 5, 0, 0 }, { 6, 6, 6, 0, 6 }, { 0, 6, 0, 0, 6 }, { 6, 6, 6, 6, 0 }, { 0, 6, 0, 0, 0 } };
        m[0][1] = 0;
        // Do not change the code below this line.
        printMap(m);
        System.out.println("Level 4: This level requires code hacking! (Changing the code in the compiler.)");
        System.out.println("In this level, you are trapped in the matrix like Neo.");
        System.out.println("Find the level4() function, and change the underlying maze data so that you can escape.");
        pressEnterToContinue();
        playManualUnlimited(m);
        int[] coordinate = find(m, 5);
        if (coordinate == null)
            System.out.println("Congratulations!!!");
        else
            System.out.println("You failed");
    }

    public static void level5() {
        clearScreen();
        int[][] m = createMap(5 + (int) (Math.random() * 5), 5 + (int) (Math.random() * 5));

        // Do not change the code below this line.
        printMap(m);
        System.out.println("Level 5: This is a randomly created maze. It should be easy.");
        System.out.println(
                "However, start thinking about how you would create a program to navigate a randomly generated maze.");
        pressEnterToContinue();
        playManualUnlimited(m);
        System.out.println("Now how would we automate that?");
        pressEnterToContinue();
    }

    public static void level6() {
        clearScreen();
        int[][] m = createMap(5 + (int) (Math.random() * 10), 5 + (int) (Math.random() * 10));
        printMap(m);
        System.out.println("Level 6: This level requires code hacking! (Changing the code in the compiler.)");
        System.out.println("This is a randomly created maze. Automate a solution.");
        System.out.println(
                "Find the level6() function, and write code using turnLeft(), turnRight(), and moveForward().");
        pressEnterToContinue();
        // Your code goes here
        String win = minPath(m);
        for (int i = 0; i < win.length(); i++) {
            if (win.charAt(i) == 'F') {
                moveForward(m);
            } else if (win.charAt(i) == 'R') {
                turnRight(m);
            } else if (win.charAt(i) == 'L') {
                turnLeft(m);
            }
            pause();
            clearScreen();
            printMap(m);
        }
        System.out.println(win);
        int[] coordinate = find(m, 5);
        if (coordinate == null)
            System.out.println("Congratulations!!!");
        else
            System.out.println("You failed");
        pressEnterToContinue();
    }

    // Allows user to see updates every turn.
    public static void playManualUnlimited(int[][] m) {
        String userInput = "";
        Scanner s = new Scanner(System.in);

        // Player location
        int[] coordinate = findPlayer(m);
        int r = coordinate[0];
        int c = coordinate[1];

        // This continues to run until you reach the finish line.
        // 6 is the code for the finish line, and when you reach it, you'll overwrite
        // it.
        // So keep running the code until the 6 is off the board.
        while (find(m, 5) != null) {
            clearScreen();
            printMap(m);
            System.out.println("You are the arrow.");
            System.out.println("Type in L, R, and F to navigate to the finish.");
            System.out.println("L = turn left, R = turn right, F = move forward.");
            System.out.println("Type in 1 letter at a time and press enter.");
            System.out.print("> ");
            // Uppercase the user input to make the checking more uniform. Check equsl F
            // instead of f or F.
            userInput = s.nextLine().toUpperCase();
            // This updates the map with a single action
            updateMap(m, userInput);
        }
        // Just print 1 more time before exiting. Otherwise, the last view
        // would be of you just before the goal.
        clearScreen();
        printMap(m);
    }

    // Allows for multiple commands at once, but only accepts 1 input
    public static void playManualOnce(int[][] m) {
        String userInput = "";
        Scanner s = new Scanner(System.in);

        // Player location
        int[] coordinate = findPlayer(m);
        int r = coordinate[0];
        int c = coordinate[1];

        // This continues to run until you reach the finish line.
        // 6 is the code for the finish line, and when you reach it, you'll overwrite
        // it.
        // So keep running the code until the 6 is off the board.
        clearScreen();
        printMap(m);
        System.out.println("You are the arrow.");
        System.out.println("Type in L, R, and F to navigate to the finish.");
        System.out.println("L = turn left, R = turn right, F = move forward.");
        System.out.println("Type in ALL actions at once then press enter.");
        System.out.print("> ");

        // Uppercase the user input to make the checking more uniform. Check equsl F
        // instead of f or F.
        userInput = s.nextLine().toUpperCase();
        executeActions(m, userInput);
    }

    // Performs a sequence of actions represented as a String, ex, "RRLFFLLF"
    public static void executeActions(int[][] m, String actions) {
        while (actions.compareTo("") != 0) {
            // updateMap based on first letter of userInput
            updateMap(m, actions.substring(0, 1));
            // Chop off the first letter of userInput.
            actions = actions.substring(1);
            pause();
            clearScreen();
            printMap(m);
        }
    }

    public static void updateMap(int[][] m, String action) {
        // Checks valid inputs L,R,F. Ignores anything else.
        if (action.compareTo("L") == 0) {
            // User had typed in L
            turnLeft(m);
        } else if (action.compareTo("R") == 0) {
            turnRight(m);
        } else if (action.compareTo("F") == 0 && canMoveF(m)) {
            moveForward(m);
        }
    }

    public static void turnLeft(int[][] m) {
        int[] coordinate = findPlayer(m);
        int r = coordinate[0];
        int c = coordinate[1];
        m[r][c] = (m[r][c] + 2) % 4 + 1;
    }

    public static void turnRight(int[][] m) {
        int[] coordinate = findPlayer(m);
        int r = coordinate[0];
        int c = coordinate[1];
        m[r][c] = m[r][c] % 4 + 1;
    }

    public static void moveForward(int[][] m) {
        int[] coordinate = findPlayer(m);
        int r = coordinate[0];
        int c = coordinate[1];
        if (canMoveF(m)) {
            if (m[r][c] == 1) {
                m[r - 1][c] = 1;
            } else if (m[r][c] == 2) {
                m[r][c + 1] = 2;
            } else if (m[r][c] == 3) {
                m[r + 1][c] = 3;
            } else if (m[r][c] == 4) {
                m[r][c - 1] = 4;
            }
            m[r][c] = 0;
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("press enter to continue");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }

    public static void clearScreen() {
        // I didn't know how to do this, so I searched up "How to clear screen java",
        // and in equal or shorter time than Google would have taken,
        // Bing gave the following:
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        try {
            Thread.currentThread().sleep(500);
        } catch (Exception e) {
        }
    }

    public static int[][] createMap(int rowSize, int colSize) {
        if (rowSize <= 0 || colSize <= 0)
            return null;
        int r = 0, c = 0;
        int[][] m = new int[2 * rowSize + 1][2 * colSize + 1];
        createMapHelper(m, 0, 2 * rowSize, 0, 2 * colSize);
        // Randomly spawn player
        int[] coordinate = find(m, 6);
        r = coordinate[0];
        c = coordinate[1];
        while (m[r][c] != 0) {
            r = (int) (Math.random() * rowSize);
            c = (int) (Math.random() * colSize);
        }
        m[r][c] = 1;
        // Randomly spawn goal
        while (m[r][c] != 0) {
            r = (int) (Math.random() * rowSize);
            c = (int) (Math.random() * colSize);
        }
        m[r][c] = 5;
        return m;
    }

    public static void createMapHelper(int[][] m, int rowMin, int rowMax, int colMin, int colMax) {
        // This is the recursive division algorithm as described here:
        // https://en.wikipedia.org/wiki/Maze_generation_algorithm
        // Base case: When the region becomes too small, stop.
        boolean mustDivideRows = rowMax - rowMin >= 2;
        boolean mustDivideCols = colMax - colMin >= 2;
        if (!mustDivideRows || !mustDivideCols) {
            return;
        }

        // Pick a random row and column, leaving space for travelling on the outer edges
        // and between walls.
        // (rowMax - rowMin - 1) / 2: this is to calculate the number of walls in this
        // region.
        // The following + rowMin + 1 is to align the random number with where walls
        // should go.
        // randomRow, randomCol initialized to -1, and will remain -1 if we are not
        // creating corresponding row/wall.
        int randomRow = -1, randomCol = -1;
        randomRow = (int) (Math.random() * (rowMax - rowMin - 1) / 2) * 2 + rowMin + 1;
        randomCol = (int) (Math.random() * (colMax - colMin - 1) / 2) * 2 + colMin + 1;

        // Draw the line of walls, creating up to 4 quadrants.
        // Includes checks to see if you must divide rows.
        for (int i = colMin; i <= colMax; i++)
            m[randomRow][i] = 6; // 6 is obstacle / cactus.
        for (int i = rowMin; i <= rowMax; i++)
            m[i][randomCol] = 6; // 6 is obstacle / cactus.

        // Create a random hole on the created row
        // On a pathway, not a wall.
        // Loop until your random spot is not on the intersection of row and col.
        int randomRowHole = randomCol;
        int randomColHole = randomRow;
        while (randomRowHole == randomCol) { // below is +2?
            randomRowHole = (int) (Math.random() * ((colMax - colMin) / 2 + 1)) * 2 + colMin;
        }
        while (randomColHole == randomRow) {
            randomColHole = (int) (Math.random() * ((rowMax - rowMin) / 2 + 1)) * 2 + rowMin;
        }

        m[randomRow][randomRowHole] = 0; // 0 = empty space
        m[randomColHole][randomCol] = 0;

        // Flip a coin to decide if the 3rd hole goes on the row or column.
        boolean isHeads = Math.random() > .5; // This will be true or false.
        boolean isMinSide = false;
        int newHoleCoordinate = 0;
        if (isHeads) {
            // Put the extra hole on the row.
            // Determine if the existing randomColHole is on the min or max side of the
            // subdivision.
            isMinSide = randomRowHole < randomCol;
            if (isMinSide) {
                // then put the new hole on the max side.
                newHoleCoordinate = (int) (Math.random() * (colMax - randomCol + 1) / 2) * 2 + randomCol + 1;
            } else {
                // then put the hole on the min side.
                newHoleCoordinate = (int) (Math.random() * (randomCol - colMin - 1) / 2) * 2 + colMin;
            }
            m[randomRow][newHoleCoordinate] = 0;
        } else {
            // Put the extra hole on the col.
            // Determine if the existing randomRowHole is on the min or max side of the
            // subdivision.
            isMinSide = randomColHole < randomRow;
            if (isMinSide) {
                // then put the new hole on the max side.
                newHoleCoordinate = (int) (Math.random() * (rowMax - randomRow + 1) / 2) * 2 + randomRow + 1;
            } else {
                // then put the hole on the min side.
                newHoleCoordinate = (int) (Math.random() * (randomRow - rowMin - 1) / 2) * 2 + rowMin;
            }
            m[newHoleCoordinate][randomCol] = 0;
        }

        // Recursive calls to inner regions.
        createMapHelper(m, rowMin, randomRow - 1, colMin, randomCol - 1); // UL
        createMapHelper(m, rowMin, randomRow - 1, randomCol + 1, colMax); // UR
        createMapHelper(m, randomRow + 1, rowMax, colMin, randomCol - 1); // BL
        createMapHelper(m, randomRow + 1, rowMax, randomCol + 1, colMax); // BR
    }

    public static String getSymbol(int value) {
        // We represent facing up as value 1, facing right as 2, down as 3, left as 4.
        if (value == 0)
            return "__";
        if (value == 1)
            return " ⬆";
        if (value == 2)
            return "➡ ";
        if (value == 3)
            return " ⬇";
        if (value == 4)
            return "⬅ ";
        if (value == 5)
            return "🏁";
        if (value == 6)
            return "🌵";
        return "  ";
    } // end getSymbol

    public static void printMap(int[][] m) {
        System.out.println("Maze Game!!!");
        System.out.println(mapToString(m));
    }

    public static String mapToString(int[][] m) {
        String rv = "";
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                rv += "  " + getSymbol(m[r][c]);
            }
            rv += "\n";
        }
        return rv;
    } // end mapToString()

    public static int[] find(int[][] m, int value) {
        // Ex, find( {{0,0,3},{3,3,2},{1,3,0}} , 1) => {2,0} the coordinates row2, col0.
        // noCoordinate => null;
        int[] coordinate = new int[2];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (m[r][c] == value) {
                    coordinate[0] = r;
                    coordinate[1] = c;
                    return coordinate;
                }
            }
        }
        return null;
    } // end find()
      // Finds player on the map. Player will have value 1,2,3, or 4.

    public static int[] findPlayer(int[][] m) {
        int[] coordinate = new int[2];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (m[r][c] >= 1 && m[r][c] <= 4) {
                    coordinate[0] = r;
                    coordinate[1] = c;
                    return coordinate;
                }
            }
        }
        return null;
    }

    public static boolean canMoveF(int[][] m) {
        // This function checks to see if player can walk forward.
        // Find the player
        int[] myCoordinates = findPlayer(m);
        int r = myCoordinates[0];
        int c = myCoordinates[1];
        // Player facing up
        /*
         * You can have separate if statements for each direction. The following is for
         * facing up: if(m[r][c] == 1 && canGoN(m)) return true;
         */
        // Or you can just combine all directions:
        return m[r][c] == 1 && canGoN(m) || m[r][c] == 2 && canGoE(m) || m[r][c] == 3 && canGoS(m)
                || m[r][c] == 4 && canGoW(m);
    }

    public static boolean canGoN(int[][] m) {
        // Find the player
        int[] myCoordinates = findPlayer(m);
        int r = myCoordinates[0];
        int c = myCoordinates[1];
        // Checks if the spot below is empty or finish.
        /*
         * if(r-1 >= 0 && (m[r-1][c] == 0 || m[r-1][c] == 2)){ return true; return
         * false;
         */
        // The previous 3 lines can be replaced with:
        return r >= 1 && (m[r - 1][c] == 0 || m[r - 1][c] == 5);
    }

    static Queue<Integer> row_queue = new LinkedList<>();
    static Queue<Integer> column_queue = new LinkedList<>();
    static int[] row_direction_vector = { -1, 1, 0, 0 };
    static int[] column_direction_vector = { 0, 0, 1, -1 };
    static boolean[][] visited;
    static int[][][] previous;
    static int max_r;
    static int max_c;

    public static String minPath(int[][] m) {
        // BFS search
        // 0 = Empty spot
        // 1 = You facing north
        // 2 = You facing east
        // 3 = You facing south
        // 4 = You facing west
        // 5 = Finish line
        // 6 = Obstacle
        Main.row_queue = new LinkedList<>();
        Main.column_queue = new LinkedList<>();
        Main.max_c = m[0].length;
        Main.max_r = m.length;
        Main.visited = new boolean[Main.max_r][Main.max_c];
        Main.previous = new int[Main.max_r][Main.max_c][2];
        for (int i = 0; i < Main.previous.length; i++)
            for (int k = 0; k < Main.previous[0].length; k++)
                Main.previous[i][k] = null;

        int[] player = findPlayer(m);
        int[] end_goal = find(m, 5);

        Main.row_queue.add(player[0]);
        Main.column_queue.add(player[1]);
        Main.visited[player[0]][player[1]] = true;

        while (Main.row_queue.size() > 0) {
            int r = Main.row_queue.remove();
            int c = Main.column_queue.remove();
            if (m[r][c] == 5) {
                break;
            }
            queue_neighbors(r, c, m);
        }
        ArrayList<int[]> shortest = make_path(player, end_goal);

        return convert_to_turns(shortest, m[player[0]][player[1]]);
    }

    public static String convert_to_turns(ArrayList<int[]> path, int orientation) {
        String guide = "";
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i)[0] == path.get(i - 1)[0]) {
                if (path.get(i)[1] > path.get(i - 1)[1]) {
                    if (orientation == 2) {
                        guide += "F";
                    } else if (orientation == 1) {
                        guide += "RF";
                    } else if (orientation == 3) {
                        guide += "LF";
                    } else if (orientation == 4) {
                        guide += "LLF";
                    }
                    orientation = 2;
                } else if (path.get(i)[1] < path.get(i - 1)[1]) {
                    if (orientation == 4) {
                        guide += "F";
                    } else if (orientation == 3) {
                        guide += "RF";
                    } else if (orientation == 1) {
                        guide += "LF";
                    } else if (orientation == 2) {
                        guide += "LLF";
                    }
                    orientation = 4;
                }
            } else {
                if (path.get(i)[0] < path.get(i - 1)[0]) {
                    if (orientation == 1) {
                        guide += "F";
                    } else if (orientation == 4) {
                        guide += "RF";
                    } else if (orientation == 2) {
                        guide += "LF";
                    } else if (orientation == 3) {
                        guide += "LLF";
                    }
                    orientation = 1;
                } else if (path.get(i)[0] > path.get(i - 1)[0]) {
                    if (orientation == 3) {
                        guide += "F";
                    } else if (orientation == 2) {
                        guide += "RF";
                    } else if (orientation == 4) {
                        guide += "LF";
                    } else if (orientation == 1) {
                        guide += "LLF";
                    }
                    orientation = 3;
                }
            }
        }
        return guide;
    }

    public static ArrayList<int[]> make_path(int[] start, int[] end) {
        ArrayList<int[]> node_path = new ArrayList<int[]>();
        node_path.add(end);
        for (int[] path = end; path != null; path = Main.previous[path[0]][path[1]]) {
            // System.out.println(Arrays.deepToString(node_path.toArray()));
            node_path.add(path);
        }
        node_path.remove(0);
        Collections.reverse(node_path);

        return node_path;
    }

    public static void queue_neighbors(int r, int c, int[][] m) {
        for (int i = 0; i < 4; i++) {
            int new_r = r + Main.row_direction_vector[i];
            int new_c = c + Main.column_direction_vector[i];

            if (new_r < 0 || new_c < 0)
                continue;
            if (new_r >= Main.max_r || new_c >= Main.max_c)
                continue;

            if (Main.visited[new_r][new_c])
                continue;
            if (m[new_r][new_c] == 6)
                continue;

            Main.row_queue.add(new_r);
            Main.column_queue.add(new_c);
            Main.visited[new_r][new_c] = true;
            int[] pair = new int[2];
            pair[0] = r;
            pair[1] = c;
            Main.previous[new_r][new_c] = pair;
        }
    }

    public static boolean canGoS(int[][] m) {
        int[] myCoordinates = findPlayer(m);
        int r = myCoordinates[0];
        int c = myCoordinates[1];
        return r < m.length - 1 && (m[r + 1][c] == 0 || m[r + 1][c] == 5);
    }

    public static boolean canGoE(int[][] m) {
        int[] myCoordinates = findPlayer(m);
        int r = myCoordinates[0];
        int c = myCoordinates[1];
        return c < m[r].length - 1 && (m[r][c + 1] == 0 || m[r][c + 1] == 5);
    }

    public static boolean canGoW(int[][] m) {
        ;
        int[] myCoordinates = findPlayer(m);
        int r = myCoordinates[0];
        int c = myCoordinates[1];
        return c >= 1 && (m[r][c - 1] == 0 || m[r][c - 1] == 5);
    }

}