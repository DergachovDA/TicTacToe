package game;

import java.util.Scanner;

public class Human extends Player {

    public Human(char type) {
        this("Player" + type, type);
    }

    public Human(String firstname, char type) {
        this("", firstname, type);
    }

    public Human(String lastname, String firstname, char type) {
        this(lastname, firstname, "", type);
    }

    public Human(String lastname, String firstname, String middlename, char type) {
        this(lastname, firstname, middlename, 16, type);
    }

    public Human(String lastname, String firstname, String middlename, int age, char type) {
        super(lastname, firstname, middlename, age, type);
    }

    @Override
    public String makeMove() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
