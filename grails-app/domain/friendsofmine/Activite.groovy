package friendsofmine

class Activite {
    String titre;
    String descriptif;

    static constraints = {
        descriptif nullable: true
        titre blank: false
    }
}
