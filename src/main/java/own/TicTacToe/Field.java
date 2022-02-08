package own.TicTacToe;

public class Field {
    int position;
    String toShow;
    boolean isChecked;
    Players checkedBy;

    public int getPosition() {
        return position;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public Players getCheckedBy() {
        return checkedBy;
    }

    {
        isChecked = false;
        checkedBy = Players.None;
    }

    public Field(int position) {
        this.position = position;
        toShow = String.valueOf(position);
    }

    public void Check(Player player){
        isChecked = true;
        checkedBy = player.name;
        toShow = player.emblem.name();
    }
}
