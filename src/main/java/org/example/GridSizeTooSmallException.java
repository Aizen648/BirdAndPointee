package org.example;

public class GridSizeTooSmallException extends IllegalArgumentException{
    public GridSizeTooSmallException(){
        super("Grid Size cannot be less that 2");
    }
}
