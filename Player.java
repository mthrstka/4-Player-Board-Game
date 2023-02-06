public class Player {
    private int[] array;
    private int score;

    public Player() {
        array = new int[20];
        score = 0;
    }


    /* Array Control */

    public int[] getInitArray() {

        int[] result = new int[3];

        for(int i = 0; i < 3; i++) {
            result[i] = array[i];
        }

        return result;
    }

    public int[] getFullArray() {
        return array;
    }

    public void setArrayData(/*input*/) {

        // Will create new array for player, creation depends on how we are choosing to send data, or whether player object creates or recieves it's array
        // Some options: recieves list of numbers in string, recieves array obj directly, etc.

    }


    /* Score Control */

    public void win() {
        score += GameManagement.currentTurn;
    }

    public void lose() {
        score += 10;
    }

    public int getScore() {
        return score;
    }
}