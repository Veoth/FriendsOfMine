package friendsofmine;

class Utilisateur {
    String nom;
    String prenom;
    String email;
    String sexe;
    Date dateDeNaissance;

    static constraints = {
        nom blank: false
        prenom blank: false
        email email: true
        sexe inList: ["F", "M"]
        dateDeNaissance nullable: true
    }
}
