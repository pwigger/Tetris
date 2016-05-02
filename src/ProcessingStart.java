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

    Rechteck[] elemente= new Rechteck[400];

    public void settings(){size(400, 400);}
    public void setup() {

        for (int i=0; i<20; i++) {
            for (int i1=0; i1<20; i1++) {
                elemente[i*20+i1]=new Rechteck(i*20, i1*20);
            }
        }
    }
    public void draw() {
        background(255, 255, 255);

        for (int i=0; i<400; i++) {
            elemente[i].paint();
            if (elemente[i].zeit == 0) {
                elemente[i].zeit = (int)random(200, 255);
            }
        }
    }
    public class Rechteck {

        int zeit;
        int x, y;
        boolean clickable;

        public Rechteck(int x, int y) {

            zeit = (int) random(0, 255);
            this.x=x;
            this.y=y;
        }
        public void paint() {
            fill(0, 0, 0);
            if (zeit<40) {
                fill(255, 0, 0);
            }
            if (clickable) {
                fill(0, 255, 0);
            }
            rect(x, y, 20, 20);
            zeit--;
            if (mousePressed && zeit<100 && mouseX/20==x/20 && mouseY/20==y/20) {
                clickable=true;
            }
        }
    }





}
