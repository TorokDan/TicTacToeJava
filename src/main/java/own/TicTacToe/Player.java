package own.TicTacToe;

enum Players {
    None,
    Player1,
    Player2
}
enum Emblem {
    X,
    O
}
public class Player {
    Players name;
    Emblem emblem;

    public Players getName() {
        return name;
    }

    public Player(Players name, Emblem emblem) {
        this.name = name;
        this.emblem = emblem;
    }
}
