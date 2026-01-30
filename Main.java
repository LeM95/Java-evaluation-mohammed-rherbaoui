import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("===========================================");
        System.out.println("   BIENVENUE DANS LE COMBAT POKEMON !");
        System.out.println("===========================================");
        System.out.println("");

        PokemonFeu salameche = new PokemonFeu("Salameche", 100, 20);
        PokemonFeu dracaufeu = new PokemonFeu("Dracaufeu", 120, 25);

        PokemonEau carapuce = new PokemonEau("Carapuce", 100, 20);
        PokemonEau tortank = new PokemonEau("Tortank", 120, 25);

        PokemonPlante bulbizarre = new PokemonPlante("Bulbizarre", 100, 20);
        PokemonPlante florizarre = new PokemonPlante("Florizarre", 120, 25);

        Pokemon[] listePokemon = {salameche, dracaufeu, carapuce, tortank, bulbizarre, florizarre};
        int[] hpInitial = {100, 120, 100, 120, 100, 120};

        boolean continuer = true;

        while (continuer) {

            for (int i = 0; i < listePokemon.length; i++) {
                listePokemon[i].setHp(hpInitial[i]);
            }

            System.out.println("Voici les Pokemon disponibles :");
            System.out.println("");
            System.out.println("=== TYPE FEU ===");
            System.out.println("1. " + salameche);
            System.out.println("2. " + dracaufeu);
            System.out.println("");
            System.out.println("=== TYPE EAU ===");
            System.out.println("3. " + carapuce);
            System.out.println("4. " + tortank);
            System.out.println("");
            System.out.println("=== TYPE PLANTE ===");
            System.out.println("5. " + bulbizarre);
            System.out.println("6. " + florizarre);
            System.out.println("");

            System.out.println("Quel Pokemon choisis-tu ? (1-6)");
            System.out.print("Ton choix : ");

            int choixJoueur = sc.nextInt();

            if (choixJoueur < 1 || choixJoueur > 6) {
                System.out.println("Choix invalide ! Tape un numero entre 1 et 6.");
                System.out.println("");
                continue;
            }

            Pokemon monPokemon = listePokemon[choixJoueur - 1];

            System.out.println("");
            System.out.println("Tu as choisi : " + monPokemon.getNom() + " !");
            System.out.println("");

            int indexEnnemi;
            do {
                indexEnnemi = rand.nextInt(6);
            } while (indexEnnemi == choixJoueur - 1);

            Pokemon ennemi = listePokemon[indexEnnemi];

            System.out.println("Ton adversaire est : " + ennemi.getNom() + " !");
            System.out.println("");

            System.out.println("===========================================");
            System.out.println("         DEBUT DU COMBAT !");
            System.out.println("   " + monPokemon.getNom() + "  VS  " + ennemi.getNom());
            System.out.println("===========================================");
            System.out.println("");

            int numTour = 1;

            while (monPokemon.isDead() == false && ennemi.isDead() == false) {

                System.out.println("--- Tour " + numTour + " ---");
                System.out.println("");

                monPokemon.attaquer(ennemi);

                if (ennemi.isDead()) {
                    System.out.println("===========================================");
                    System.out.println(ennemi.getNom() + " est KO !");
                    System.out.println("");
                    System.out.println("VICTOIRE ! " + monPokemon.getNom() + " a gagne !");
                    System.out.println("===========================================");
                    break;
                }

                ennemi.attaquer(monPokemon);

                if (monPokemon.isDead()) {
                    System.out.println("===========================================");
                    System.out.println(monPokemon.getNom() + " est KO !");
                    System.out.println("");
                    System.out.println("DEFAITE ! " + ennemi.getNom() + " a gagne !");
                    System.out.println("===========================================");
                    break;
                }

                numTour = numTour + 1;
            }

            System.out.println("");
            System.out.println("Veux-tu rejouer ? (1 = Oui, 0 = Non)");
            System.out.print("Ton choix : ");

            int reponse = sc.nextInt();

            if (reponse == 0) {
                continuer = false;
                System.out.println("");
                System.out.println("Merci d'avoir joue ! A bientot !");
            } else {
                System.out.println("");
                System.out.println("===========================================");
                System.out.println("         NOUVELLE PARTIE !");
                System.out.println("===========================================");
                System.out.println("");
            }
        }

        sc.close();
    }
}
