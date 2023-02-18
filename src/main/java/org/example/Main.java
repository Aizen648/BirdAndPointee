package org.example;

public class Main {
    public static void main(String[] args) {
        //TODO: program pozwala zmieniać rozmiar siatki
        int sizeGrid = 15;
        PointeesOnTheGrid.DEBUG = false;
        PointeesOnTheGrid.SLANTJUMP = true;

        try {
            PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(sizeGrid);

            for (int i = 0; i < 100; i++) {
                pointeesOnTheGrid.flyingBird();
            }

            if (PointeesOnTheGrid.DEBUG) {
                System.out.println(pointeesOnTheGrid);
            }

            System.out.println("The maximum number of pointees on one coupon after 25,50 and 100 jumps is " + pointeesOnTheGrid.getMaxNumberOfPointees() + " pointees");

            pointeesOnTheGrid.displayGridAfter25Jump();
            pointeesOnTheGrid.displayGridAfter50Jump();
            pointeesOnTheGrid.displayGridAfter100Jump();

            System.out.println("The maximum number of pointees on one coupon after 25 jump " + pointeesOnTheGrid.getMaxNumberOfPointeesAt25());
            System.out.println("The maximum number of pointees on one coupon after 50 jump " + pointeesOnTheGrid.getMaxNumberOfPointeesAt50());
            System.out.println("The maximum number of pointees on one coupon after 100 jump " + pointeesOnTheGrid.getMaxNumberOfPointeesAt100());

        } catch (GridSizeTooSmallException Gstse) {
            System.out.println("a teraz rzucem ci błedem");
            throw new RuntimeException(Gstse);
        }
    }
}
