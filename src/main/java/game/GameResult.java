package game;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameResult implements Comparable{

//    public static final String WIN = "win";
//    public static final String LOSS = "loss";
//    public static final String DRAW = "draw";

    private Player player;
    private Result result;
    private Date date;

    public GameResult() {
    }

    public GameResult(Player player, Result result) {
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

    public Player getPlayer() {
        return  this.player;
    }

    public Result getResult() {
        return this.result;
    }

    public Date getDate() {
        return this.date;
    }

    public boolean equalsWin() {
        return result.equals(Result.WIN);
    }

    public boolean equalsLoss() {
        return result.equals(Result.LOSS);
    }

    public boolean equalsDraw() {
        return result.equals(Result.DRAW);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(long date) {
        this.date.setTime(date);
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return player + "\t" + result + "\t" + dateFormat.format(date);
    }

    @Override
    public int compareTo(Object o) {
        GameResult gameResult = (GameResult) o;
        return this.player.compareTo(gameResult.player);
    }
}