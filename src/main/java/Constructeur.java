import java.util.List;

public class Constructeur extends Thread {
    private JoueurConstructeur ES;
    int tempsConstructeur;
    boolean stop = false;
    int scoreTotalConstructeur=0;
    public Constructeur(JoueurConstructeur base, int tpsCons) {
        this.ES = base;
        this.tempsConstructeur = tpsCons;
    }
    public void Stop() {
        this.stop = true;
    }
    public void run() {
        while (!stop) {
            double x = Math.random()*3;
            double y = Math.random()*3;

            if(ES.plateau.get((int)x).get((int)y)==0){
                ES.plateau.get((int)x).remove((int)y);
                ES.plateau.get((int)x).add((int)y,-1);
                scoreTotalConstructeur++;
            }
            ES.entreConstructeur();

            try {
                sleep(this.tempsConstructeur);
            } catch (InterruptedException e) {
            }
            ES.sortConstructeur();
        }
    }
}