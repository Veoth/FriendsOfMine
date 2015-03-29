import friendsofmine.Utilisateur;

class BootStrap {
    def init = { servletContext ->
        new Utilisateur(prenom: "Hugues",nom: "Odegaard",email: "ddddd@gmail.com",sexe: "F",dateDeNaissance: new Date()).save();
        new Utilisateur(prenom: "BigBoss",nom: "Fallourd",email: "il_roxe_sa_maman@gmail.com",sexe: "M",dateDeNaissance: new Date()).save();
        new Utilisateur(prenom: "RonRon",nom: "Gonzalez",email: "ronron@gmail.com",sexe: "F",dateDeNaissance: new Date()).save();
    }
    def destroy = {
    }
}