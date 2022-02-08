package own.TicTacToe;

public class Board {
    Field[][] table;

    {
        table = new Field[3][3];
        int counter = 1;
        for (int i = 0; i < table[0].length; i++){
            for (int j = 0; j < table[1].length;j++){
                table[i][j] = new Field(counter++);
            }
        }
    }

    public boolean GuessAndCheck(int position, Player player){
        Field field = FieldByPosition(position);
        field.Check(player);
        return CheckIfWon(position, player);
    }

    public boolean ValidPosition(int position){
        if (FieldByPosition(position).position == 0)
            return false;
        return true;
    }

    public String ToString(){
        String vissza = new String();
        String firstRow = String.format(new String(new char[3]).replace("\0", " ") + "|" + new String(new char[3]).replace("\0", " ") + "|" + new String(new char[3]).replace("\0", " ") + "\n");
        String lastRow = String.format(new String(new char[3]).replace("\0", "_") + "|" + new String(new char[3]).replace("\0", "_") + "|" + new String(new char[3]).replace("\0", "_") + "\n");
        for (int i = 0; i < table[0].length; i++) {
            String help = new String();
            for (int j = 0; j < table[1].length; j++) {
                if (!help.isEmpty())
                    help += "|";
                help += String.format(" %s ", table[i][j].toShow);
            }
            help += "\n";
            if (vissza.isEmpty()){
                vissza += firstRow + help;
            }
            else {
                vissza += lastRow + firstRow + help;
            }
        }
        vissza += firstRow;
        return vissza;
    }

    private Field FieldByPosition(int position){
        Field vissza = new Field(0);
        for (int i = 0; i < table[0].length; i++){
            for (int j = 0; j < table[1].length; j++){
                if (table[i][j].position == position)
                    return table[i][j];
            }
        }
        return vissza;
    }
    private boolean CheckIfWon(int position, Player player){
        boolean vissza = false;
        switch (position){
            case 1:
                if (CheckLine(1, 2, 3) || CheckLine(1, 5, 9) || CheckLine(1,4,7))
                    vissza = true;
            case 2:
                if (CheckLine(1, 2, 3) || CheckLine(2, 5, 8))
                    vissza = true;
            case 3:
                if (CheckLine(1, 2, 3) || CheckLine(3, 5, 7) || CheckLine(3,6,9))
                    vissza = true;
            case 4:
                if (CheckLine(4, 5, 6) || CheckLine(1, 4, 7))
                    vissza = true;
            case 5:
                if (CheckLine(1, 5, 9) || CheckLine(2, 5, 8) || CheckLine(3,5,7) || CheckLine(4, 5, 6) )
                    vissza = true;
            case 6:
                if (CheckLine(4, 5, 6) || CheckLine(3, 6, 9))
                    vissza = true;
            case 7:
                if (CheckLine(1, 4, 7) || CheckLine(7, 5, 3) || CheckLine(7,8,9))
                    vissza = true;
            case 8:
                if (CheckLine(7, 8, 9) || CheckLine(2, 5, 8))
                    vissza = true;
            case 9:
                if (CheckLine(1, 5, 9) || CheckLine(3, 6, 9) || CheckLine(7,8,9))
                    vissza = true;
        }
        return vissza;
    }
    private boolean CheckLine(int position1, int position2, int position3){
        Field field1 = FieldByPosition(position1);
        Field field2 = FieldByPosition(position2);
        Field field3 = FieldByPosition(position3);
        if (field1.isChecked && field2.isChecked && field3.isChecked
                && field1.checkedBy == field2.checkedBy
                && field2.checkedBy == field3.checkedBy)
            return true;
        return false;
    }
}
