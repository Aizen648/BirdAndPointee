package org.example;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;


public class PointeesOnTheGrid {
    private int[][] grid;
    // dla oszczędzenia pamięci nie zapisuje wszystkich ułożeń siatki tylko wybrane;
    private final int[][] gridAfter25Jump;
    private final int[][] gridAfter50Jump;
    private final int[][] gridAfter100Jump;
    private final int sizeGrid;
    private int whichJump =0;
    // dla oszczędzenia pamięci nie zapisuje wszystkich maksymalnych wynikow tylko wybrane;
    @Getter private int maxNumberOfPointeesAt25=0;
    @Getter private int maxNumberOfPointeesAt50=0;
    @Getter private int maxNumberOfPointeesAt100=0;
    @Getter private int maxNumberOfPointees=0;
    public static boolean DEBUG=true;
    public static boolean SLANTJUMP=true;
    //mapa jest wykorzystywana przy debugowaniu
    private static final Map<Integer, String> DIRECTION = Map.of(
            0, "Bottom",
            1, "UP",
            2, "RIGHT",
            3, "LEFT",
            4, "LOWERLEFT",
            5, "LOWERRIGHT" ,
            6, "UPPERLEFT",
            7, "UPPERRIGHT");

    public PointeesOnTheGrid(int sizeGrid) throws GridSizeTooSmallException {
        if(sizeGrid<2){
            throw new GridSizeTooSmallException();
        }
        if(sizeGrid>300){
            System.out.println("Grid size is too big. "+"Created grid size 300");
            sizeGrid=300;
        }
        this.sizeGrid=sizeGrid;
        grid = new int[sizeGrid][sizeGrid];
        gridAfter25Jump= new int[sizeGrid][sizeGrid];
        gridAfter50Jump= new int[sizeGrid][sizeGrid];
        gridAfter100Jump= new int[sizeGrid][sizeGrid];
        for (int X = 0; X < grid.length; X++) {
            for (int Y = 0; Y < grid.length; Y++) {
                grid[X][Y] = 1;
            }
        }
    }

    private static void jump(int[][] newGrid, int X, int Y) {
        int newX = X;
        int newY = Y;
        Random random = new Random();
        int direction;
        
        if(SLANTJUMP) {
            direction = random.nextInt(8);
        } else {
            direction= random.nextInt(4);
        }
        
        switch (direction) {
            case 0 -> newX++;                //dol 0
            case 1 -> newX--;                //gor
            case 2 -> newY++;                //prawo
            case 3 -> newY--;                //lewo
            case 4 -> {newX++;newY--;}       //dol lewo
            case 5 -> {newX++;newY++;}       //dol prawo
            case 6 -> {newX--;newY--;}       //gora lewo
            case 7 -> {newX--;newY++;}       //gora prawo
        }

        if (newX < 0 || newY < 0 || newX > newGrid.length - 1 || newY > newGrid.length - 1) {
            if (DEBUG) System.out.println("failed jump from X:" + X + " Y:" + Y + " towards " + DIRECTION.get(direction));
            jump(newGrid, X, Y);
        } else {
            if (DEBUG) System.out.println("managed to jump from X:" + X + " Y:" + Y + " towards " + DIRECTION.get(direction));
            newGrid[newX][newY]++;
        }
    }



    public void flyingBird() {
        whichJump++;
        int[][] newGrid = new int[sizeGrid][sizeGrid];
        for (int X = 0; X < grid.length; X++) {
            for (int Y = 0; Y < grid.length; Y++) {
                while (grid[X][Y] > 0) {
                    if (DEBUG) System.out.print("i: " + whichJump + " ");
                    jump(newGrid, X, Y);
                    grid[X][Y]--;
                }
            }
        }
        grid = newGrid;
        maxPointees();
        remebmerMap();
    }

    private void remebmerMap() {
        if (whichJump == 25) {
            copy(gridAfter25Jump,grid);
        }
        if (whichJump == 50) {
            copy(gridAfter50Jump,grid);
        }
        if (whichJump == 100) {
            copy(gridAfter100Jump,grid);
        }
    }
    private void copy(int[][] grid,int[][] copyGrid){
        for(int X=0;X<sizeGrid;X++){
            for(int Y=0;Y<sizeGrid;Y++){
                grid[X][Y]=copyGrid[X][Y];
            }
        }
    }

    private void maxPointees() {
        int localMaxNumber=0;
        if (whichJump == 25 || whichJump == 50 || whichJump == 100) {
            for (int X = 0; X < grid.length; X++) {
                for (int Y = 0; Y < grid.length; Y++) {
                    localMaxNumber = Math.max(localMaxNumber, grid[X][Y]);
                }
            }
            if(whichJump ==25) maxNumberOfPointeesAt25=localMaxNumber;
            if(whichJump ==50) maxNumberOfPointeesAt50=localMaxNumber;
            if(whichJump ==100) maxNumberOfPointeesAt100=localMaxNumber;

            maxNumberOfPointees = Math.max(maxNumberOfPointees, localMaxNumber);
        }
    }

    public void displayGridAfter25Jump() {
        System.out.println(display(gridAfter25Jump));
    }
    public void displayGridAfter50Jump() {
        System.out.println(display(gridAfter50Jump));
    }
    public void displayGridAfter100Jump() {
        System.out.println(display(gridAfter100Jump));
    }
    @Override
    public String toString() {
        return display(grid);
    }
    private String display(int[][] grid){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            sb.append("[ ").append(i + 1).append(":").append("\t");
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[i][j]).append("\t");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointeesOnTheGrid that = (PointeesOnTheGrid) o;
        return Arrays.deepEquals(grid, that.grid);
    }

}
