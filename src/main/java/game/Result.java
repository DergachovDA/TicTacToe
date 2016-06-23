package game;

public enum Result {
    WIN("win"),
    LOSS("loss"),
    DRAW("draw");

    private String result;

    Result(String result) {
        this.result = result;
    }

    public String getResultValue() {
        return this.result;
    }

    public static Result isValue(String value) {

        if (value.equals("win")) {
            return WIN;
        }
        if (value.equals("loss")) {
            return LOSS;
        }
        if (value.equals("draw")) {
            return DRAW;
        }

        return null;
    }
}
