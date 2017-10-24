package com.inql.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Ants {

    private List<Ant> ants;
    private int wLimit;
    private int hLimit;

    public Ants(int wLimit, int hLimit) {
        this.wLimit = wLimit-1;
        this.hLimit = hLimit-1;
        this.ants = new ArrayList<>();
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public boolean addAnt(){
        if(ants.size()<Anthill.getMaxAnts())
        {
            int x,y;

            do{
                x = ThreadLocalRandom.current().nextInt(0,wLimit+1);
                y = ThreadLocalRandom.current().nextInt(0,hLimit+1);
            }while(isAntThere(x,y) && !!isPlaceCorrect(x,y));
            ants.add(new Ant(x,y));
            return true;
        }
        return false;
    }

    public boolean addAnt(int x, int y){
        if(!isAntThere(x,y) && isPlaceCorrect(x,y) && ants.size()<Anthill.getMaxAnts()){
            ants.add(new Ant(x,y));
            return true;
        }
        return false;
    }

    public boolean isAntThere(int x, int y){
        for (Ant item:
                ants) {
            if(x == item.getX() && y == item.getY())
                return true;
        }
        return false;
    }

    public boolean isPlaceCorrect(int x, int y){
        return x>=0 && x<=wLimit && y>=0 && y<=hLimit;
    }

    public boolean moveAnt(Ant ant, String command){
        int x = ant.getX();
        int y = ant.getY();
        switch (command){
            case "up":
                y--;
                break;
            case "down":
                y++;
                break;
            case "left":
                x--;
                break;
            case "right":
                x++;
                break;
            default:
                return false;
        }
        if(!isAntThere(x,y) && isPlaceCorrect(x,y)){
            ant.setX(x);
            ant.setY(y);
            return true;
        }
        return false;
    }

    public void showAnts(){
        for (Ant item:
             ants) {
            System.out.println(item);
        }
    }

    public Ant getAnt(int id){
        for(Ant item : ants){
            if(item.getId() == id)
                return item;
        }
        return null;
    }

}
