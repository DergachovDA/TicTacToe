package game;

import java.util.Random;

public class Ai extends Player {

    public Ai(char type) {
        super("Player" + type, "PC", "", 0, type);
    }

    @Override
    public String makeMove() {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        return String.valueOf(x + 1) + String.valueOf(y + 1);
    }


}
