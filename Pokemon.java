public class Pokemon {

    private String nom;
    private int hp;
    private int atk;

    public Pokemon(String nom, int hp, int atk) {
        this.nom = nom;
        this.hp = hp;
        this.atk = atk;
    }

    public String getNom() {
        return this.nom;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public boolean isDead() {
        if (this.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void attaquer(Pokemon cible) {
        int degat = this.atk;
        cible.setHp(cible.getHp() - degat);
        System.out.println(this.nom + " attaque " + cible.getNom() + " !");
        System.out.println("Degats infliges : " + degat);
        System.out.println(cible.getNom() + " a maintenant " + cible.getHp() + " HP");
        System.out.println("");
    }

    @Override
    public String toString() {
        return this.nom + " (HP: " + this.hp + ", ATK: " + this.atk + ")";
    }
}
