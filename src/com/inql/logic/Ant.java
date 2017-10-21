package com.inql.logic;

public class Ant {

    static int instanceCounter = 0;
    int id = 0;
    int x;
    int y;

    public Ant(int x, int y) {
        instanceCounter++;
        this.id = instanceCounter;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ant{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
