package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointeesOnTheGridTest {

    @Test
    public void PointeesOnTheGrid_GridSizeTooSmall_ThrowGridSizeTooSmallException() {
        assertThrows(GridSizeTooSmallException.class,()-> new PointeesOnTheGrid(-15));
    }
    @Test
    public void PointeesOnTheGrid_GridSizeTooBig_Equals() {
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(300);
        PointeesOnTheGrid pointeesOnTheGrid2 = new PointeesOnTheGrid(16516);
        Assertions.assertEquals(pointeesOnTheGrid2, pointeesOnTheGrid);
    }
    @Test
    public void flyingBird_twoUses_NotEquals() {
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid pointeesOnTheGrid2 = new PointeesOnTheGrid(15);

        PointeesOnTheGrid.DEBUG=false;
        pointeesOnTheGrid2.flyingBird();
        pointeesOnTheGrid.flyingBird();

        Assertions.assertNotEquals(pointeesOnTheGrid2, pointeesOnTheGrid);
    }
    @Test
    public void getMaxNumberOfPointeesAt25_returnDefault0_Equals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<24;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertEquals(0,pointeesOnTheGrid.getMaxNumberOfPointeesAt25());
    }
    @Test
    public void getMaxNumberOfPointeesAt25_notReturnDefault0_NotEquals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<25;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertNotEquals(0,pointeesOnTheGrid.getMaxNumberOfPointeesAt25());
    }
    @Test
    public void getMaxNumberOfPointeesAt50_returnDefault0_Equals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<49;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertEquals(0,pointeesOnTheGrid.getMaxNumberOfPointeesAt50());
    }
    @Test
    public void getMaxNumberOfPointeesAt50_notReturnDefault0_NotEquals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<50;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertNotEquals(0,pointeesOnTheGrid.getMaxNumberOfPointeesAt50());
    }
    @Test
    public void getMaxNumberOfPointeesAt100_returnDefault0_Equals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<99;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertEquals(0,pointeesOnTheGrid.getMaxNumberOfPointeesAt100());
    }
    @Test
    public void getMaxNumberOfPointeesAt100_notReturnDefault0_NotEquals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<100;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertNotEquals(0,pointeesOnTheGrid.getMaxNumberOfPointeesAt100());
    }


    @Test
    public void getMaxNumberOfPointees_returnDefault0_Equals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<24;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertEquals(0,pointeesOnTheGrid.getMaxNumberOfPointees());
    }
    @Test
    public void getMaxNumberOfPointees_returnDefault0_NotEquals(){
        PointeesOnTheGrid pointeesOnTheGrid = new PointeesOnTheGrid(15);
        PointeesOnTheGrid.DEBUG=false;
        for(int i=0;i<100;i++){
            pointeesOnTheGrid.flyingBird();
        }
        Assertions.assertNotEquals(0,pointeesOnTheGrid.getMaxNumberOfPointees());
    }

    // jedynimi publicznymi metodami są void, gettery i flyingBirds. Pozostałe metody są prywatne by nikt z zewnątrz
    // nie wpłynał na ich działanie. Metoda flyingBirds opiera się na losowości więc nie da przewidzieć się jej wyników.


}