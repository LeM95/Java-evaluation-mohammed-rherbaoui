public class PokemonPlante extends Pokemon {

    public PokemonPlante(String nom, int hp, int atk) {
        super(nom, hp, atk);
    }

    @Override
    public void attaquer(Pokemon cible) {
        int degat = this.getAtk();

        if (cible instanceof PokemonEau) {
            degat = degat * 2;
            System.out.println("C'est super efficace !");
        }
        else if (cible instanceof PokemonPlante) {
            degat = degat / 2;
            System.out.println("Ce n'est pas tres efficace...");
        }
        else if (cible instanceof PokemonFeu) {
            degat = degat / 2;
            System.out.println("Ce n'est pas tres efficace...");
        }

        cible.setHp(cible.getHp() - degat);
        System.out.println(this.getNom() + " (Plante) attaque " + cible.getNom() + " !");
        System.out.println("Degats infliges : " + degat);
        System.out.println(cible.getNom() + " a maintenant " + cible.getHp() + " HP");
        System.out.println("");
    }
}
