//Make a class called Squarelotron with the following instance variables
//
//        int[][] squarelotron.
//
//        int size


import java.util.Arrays;

public class Squarelotron {
    public int[][] squarelotron;
    public int size;

//    Constructors:
//
//    Squarelotron should have a constructor.
//    Squarelotron(int n) - It fills the 2-dimensional array with the numbers 1 to n squared,
//    in order. It also sets the size instance variable to be n.

    public Squarelotron(int n){
        this.size = n;
        this.squarelotron = new int[size][size];
        for (int i = 0; i < size; i ++){
            for (int j = 0; j < size; j ++){
                squarelotron[i][j] = i * size + j + 1;
            }
        }
    }
//    Squarelotron upsideDownFlip(int ring)
//    This method performs the Upside-Down Flip of the squarelotron,
//    as described above, and returns the new squarelotron.
//    The original squarelotron should not be modified (we will check for this).
    public Squarelotron upsideDownFlip(int ring){
        Squarelotron different = new Squarelotron(this.size);
        for (int i = 0; i < size; i ++){
            for (int j = 0; j < size; j ++){
                if (i == ring - 1 || i == size - ring || j == ring - 1|| j == size - ring){
                    different.squarelotron[i][j] = this.squarelotron[size - i - 1][j];
                }
                else {
                    different.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
        }
        return different;
    }
//    Squarelotron mainDiagonalFlip(int ring)
//
//    This method performs the Main Diagonal Flip of the squarelotron,
//    as described above, and returns the new squarelotron.
//    The original squarelotron should not be modified (we will check for this)

    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron different = new Squarelotron(this.size);

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring) {
                    different.squarelotron[i][j] = this.squarelotron[j][i];
                }
                else {
                    different.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
        }
        return different;
    }
//    void rotateRight(int numberOfTurns)
//
//    The argument numberOfTurns indicates the number of times the entire squarelotron
//    should be rotated 90° clockwise. Any integer, including zero and negative integers,
//    is allowable as the argument. A value of -1 indicates a 90° counterclockwise rotation.
//    This method modifies the internal representation of the squarelotron;
//    it does not create a new squarelotron.

    public void rotateRight(int numberOfTurns) {
        for (int n = 0; n < Math.abs(numberOfTurns); n++) {
            Squarelotron different = new Squarelotron(this.size);
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (numberOfTurns > 0) {
                        different.squarelotron[j][this.size - 1 - i] = this.squarelotron[i][j];
                    }
                    else {
                        different.squarelotron[i][j] = this.squarelotron[j][this.size - 1 - i];
                    }
                }
            }
            this.squarelotron = Arrays.copyOf(different.squarelotron, different.size);
        }
    }


}
