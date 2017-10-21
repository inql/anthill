package com.inql.ui;

import com.inql.logic.Ant;
import com.inql.logic.Anthill;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class UserInterface {

    private Scanner input;
    private Anthill anthill;
    private int width;
    private int height;
    private int maxAnts;

    public UserInterface(int width, int height, int maxAnts) {
        this.input = new Scanner(System.in);
        this.width = width;
        this.height = height;
        this.maxAnts = maxAnts;
        this.anthill = new Anthill(width, height, maxAnts);
    }

    public void run(){
        String command;
        boolean doesUserQuit = false;
        System.out.println("Welcome to Anthill simulator!\nDisplaying Anthill...\n");
        do{
            anthill.buildAnthill();
            anthill.getAnts().showAnts();
            showMenu();
            command = input.nextLine();

            switch (command.toLowerCase()){
                case "add":
                    addAnt();
                    break;
                case "remove":
                    removeAnt();
                    break;
                case "move":
                    moveAnt();
                    break;
                case "randomly":
                    moveAntRandomly();
                    break;
                case "quit":
                    doesUserQuit = true;
                    break;
                default:
                    System.out.println("Unknown command. Try again.");
                    break;


            }
        }while(!doesUserQuit);
    }

    public void showMenu(){
        System.out.println("Main menu:");
        System.out.println("\tADD ant");
        System.out.println("\tREMOVE ant");
        System.out.println("\tMOVE exact ant");
        System.out.println("\tmove RANDOMLY all ants");
        System.out.println("\tor just QUIT\n");
        System.out.println("Choose your option:");
    }

    private void addAnt(){
        System.out.println("Enter ant x and y coordinates (make sure that place isn't taken or out of antihill: \n" +
                "if you dont enter both values, ant will be generated on random place");
        boolean operationCompleted = false;
        do {
            System.out.print("Enter x: ");
            String x = input.nextLine();
            System.out.print("Enter y: ");
            String y = input.nextLine();
            if(x.isEmpty() || y.isEmpty())
                operationCompleted = anthill.getAnts().addAnt();
            else
                operationCompleted = anthill.getAnts().addAnt(Integer.parseInt(x),Integer.parseInt(y));
        }while(!operationCompleted);
    }

    private void removeAnt(){
        System.out.print("Enter proper ant id to delete ant: ");
        int id = Integer.parseInt(input.nextLine());
        Ant ant = anthill.getAnts().getAnt(id);
        if(ant == null)
            System.out.println("Invalid id. Backing to main menu");
        else
            anthill.getAnts().getAnts().remove(ant);
    }

    private void moveAnt(){
        System.out.print("Enter proper ant id to move ant: ");
        int id = Integer.parseInt(input.nextLine());
        Ant ant = anthill.getAnts().getAnt(id);
        if(ant == null)
            System.out.println("Invalid id. Backing to main menu");
        else
        {
            String command;
            do{
                System.out.println("Enter command (up, down, left, right");
                command = input.nextLine();
            }while(!anthill.getAnts().moveAnt(ant, command.toLowerCase()));
        }

    }

    private void moveAntRandomly(){

        String[] commands = new String[4];
        commands[0] = "up";
        commands[1] = "down";
        commands[2] = "left";
        commands[3] = "right";

        for(Ant item : anthill.getAnts().getAnts())
        {
            int num;
            do{
                num = ThreadLocalRandom.current().nextInt(0,3+1);
            }while(!anthill.getAnts().moveAnt(item, commands[num]));
        }
    }
}
