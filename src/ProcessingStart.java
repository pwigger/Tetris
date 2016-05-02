/**
 * Created by pwg on 18.04.16.
 */

import processing.core.*;
import processing.core.PApplet;

public class ProcessingStart extends PApplet {
    //  public static void main(String[] args) {
    //    PApplet.main(new String[] {"ProcessingStart"});

    //}

    static public void main(String[] args) {
        PApplet.main("ProcessingStart");
    }

    public int[][] tetris = new int[30][12];
    public boolean isMoving = false;

    public void settings() {
        size(240, 600);
    }

    public void setup() {
        frameRate(10);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 12; j++) {
                tetris[i][j] = 0;
            }
        }

    }

    public void draw() {

        fill(255, 0, 0);
        stroke(255, 255, 255);

        for (int i = 0; i < tetris.length; i++) {
            for (int j = 0; j < tetris[i].length; j++) {
                if (tetris[i][j] == 0) {
                    fill(0, 0, 0);
                } else {
                    fill(255, 255, 255);
                }
                rect(j * 20, i * 20, 20, 20);
            }
        }
        fallingStone();
        if (!isMoving) {
            dropBrick();
        }

    }

    public void fallingStone() {
        isMoving = false;
        for (int i = tetris.length - 2; i >= 0; i--) {
            for (int j = tetris[i].length - 1; j >= 0; j--) {
                if (tetris[i][j] == 1&& tetris[i+1][j]==0) {
                    tetris[i + 1][j] = 1;
                    tetris[i][j] = 0;
                    isMoving = true;
                }

            }

        }
    }

    public void dropBrick() {
        tetris[0][(int) random(0, 11)] = 1;
    }


}
