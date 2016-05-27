package game;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameResult {

    public static final String WIN = "win";
    public static final String LOSS = "loss";
    public static final String DRAW = "draw";

    private Player player;
    private String result;
    private Date date;

    public GameResult(Player player, String result) {
        this.player = player;
        this.result = result;
        this.date = new Date();
    }

    @Override //generate IDEA
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameResult that = (GameResult) o;

        if (!player.equals(that.player)) return false;
        if (!result.equals(that.result)) return false;
        return date.equals(that.date);
    }

    public String getResult() {
        return this.result;
    }

    public Date getDate() {
        return this.date;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return player + "\t| " + result + "\t| " + dateFormat.format(date);
    }


}