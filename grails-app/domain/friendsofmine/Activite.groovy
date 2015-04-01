package friendsofmine

class Activite {
    String titre;
    String descriptif;

    Utilisateur responsable;

    static constraints = {
        descriptif nullable: true
        titre blank: false
    }

    String toString() {
        return "Titre : " + titre + " (Responsable: " + responsable.nom;
    }
}
