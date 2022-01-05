import java.util.List;

public class Joueur extends Thread {
    private JoueurConstructeur ES;
    int tempsJoueur;
    boolean stop = false;
    int scoreTotalJoueur=0;
    public Joueur(JoueurConstructeur base, int tpsJoueur) {
        this.ES = base;
        this.tempsJoueur = tpsJoueur;
    }
    public void Stop() {
        this.stop = true;
    }
    public void run() {
        double x = Math.random()*3;
        double y = Math.random()*3;
        ES.entreJoueur();
        try {
            sleep(this.tempsJoueur);
        } catch (InterruptedException e) {
        }
        if(ES.plateau.get((int)x).get((int)y)==-1){
            ES.sortJoueur();
            ES.entreConstructeur();
            if(ES.plateau.get((int)x).get((int)y)==-1) {
                ES.plateau.get((int) x).remove((int) y);
                ES.plateau.get((int) x).add((int) y, (int) this.getId());
                scoreTotalJoueur++;
            }
            ES.sortConstructeur();
        }
        else{ES.sortJoueur();}
    }
}
