import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(final String[] args) throws InterruptedException {
        int vertexCount = 3;

        List<List<Integer>> plateau = new ArrayList<>(vertexCount);
        for(int i=0; i < vertexCount; i++) {
            plateau.add(new ArrayList());
            for(int j=0;j<vertexCount;j++){
                plateau.get(i).add(j,0);
            }
        }

        JoueurConstructeur base = new JoueurConstructeur(plateau);
        int tpsL = 10;
        int tpsCons = 100;
        int nbJoue = 3;
        int nbCons = 3;
        Constructeur[] TabE = new Constructeur[nbCons];
        Joueur[] TabL = new Joueur[nbJoue];
        for (int i = 0; i < nbJoue; i++) {
            TabL[i] = new Joueur(base, tpsL);
            TabL[i].start();        //Joueur start
        }

        for (int i = 0; i < nbCons; i++) {
            TabE[i] = new Constructeur(base, tpsCons);
            TabE[i].start();        //Joueur start
        }
        
        Thread.sleep(100 * 10);
        for (int i = 0; i < nbJoue; i++) {
            TabL[i].Stop();         //Joueur stop
            System.out.println("scoreJoueur: "+TabL[i].scoreTotalJoueur);
        }
        for (int i = 0; i < nbCons; i++) {
            TabE[i].Stop();         //Joueur stop
            System.out.println("scoreCons: "+TabE[i].scoreTotalConstructeur);
        }

        for(List list: base.plateau) {
            System.out.print("\n\n");
            for(int i=0;i<vertexCount;i++) {
                System.out.print("\t" + list.get(i) + "\t");
            }
        }
    }
}
