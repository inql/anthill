package com.inql.logic;

public class Anthill {

    private int width;
    private int height;
    private static int maxAnts;
    private Ants ants;

    public Ants getAnts() {
        return ants;
    }

    public static int getMaxAnts() {
        return maxAnts;
    }

    public Anthill(int width, int height, int maxAnts) {
        this.width = width;
        this.height = height;
        this.maxAnts = maxAnts;

        this.ants = new Ants(width,height);
    }

    public void buildAnthill(){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                if(ants.isAntThere(j,i))
                    System.out.print("O");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }



}
