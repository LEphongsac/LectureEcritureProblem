import java.util.List;

public class JoueurConstructeur  {
    private int nbJoueurs = 0;
    private boolean redacteurPresent = false;
    List<List<Integer>> plateau;

    public JoueurConstructeur(List<List<Integer>> plateau){
        this.plateau=plateau;
    }

    public synchronized void entreJoueur() {
        while (this.redacteurPresent){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nbJoueurs++;
    }


    public synchronized void sortJoueur() {
        nbJoueurs--;
        notify();
    }


    public synchronized void entreConstructeur() {
        while ((this.redacteurPresent)|| (this.nbJoueurs > 0)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.redacteurPresent = true;
    }


    public synchronized void sortConstructeur(){
        this.redacteurPresent = false;
        notify();
    }
}
