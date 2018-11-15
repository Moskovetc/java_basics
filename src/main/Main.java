package main;

import main.trainingcenter.TrainingCenter;

public class Main {
    public static void main(String[] args) {
        TrainingCenter trainingCenter = new TrainingCenter();
        if (1 == args.length) {
            trainingCenter.setStudentFile(args[0]);
            trainingCenter.runMenu();
        } else if (1 < args.length) {
            System.out.println("Argument is invalid");
        } else {
            trainingCenter.runMenu();
        }
    }
}
