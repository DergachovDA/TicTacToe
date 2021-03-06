package game;

public abstract class Player implements Comparable {

    private String lastname;
    private String firstname;
    private String middlename;
    private int age;
    private char type;
    public static char X = 'X';
    public static char O = 'O';

    public Player(String lastname, String firstname, String middlename, int age, char type) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.age = age;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Player player = (Player) obj;

        if (this.lastname == null || this.firstname == null || this.middlename == null)
            return false;

        if (this.lastname.equals(player.lastname))
            if (this.firstname.equals(player.firstname))
                if (this.middlename.equals(player.middlename))
                    if (this.age == player.age)
                        if (this.type == player.type)
                            return true;

        return false;
    }

    @Override
    public int compareTo(Object o) {
        Player player = (Player) o;
        return this.firstname.compareTo(player.firstname);
    }

    public char getType() {
        return type;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public int getAge() {
        return age;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String toString() {
        return firstname + " " + lastname + " (" + type + ")";
    }

    public abstract String makeMove();
}

