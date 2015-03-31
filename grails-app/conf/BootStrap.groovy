import friendsofmine.Utilisateur;
import friendsofmine.JeuTestService;

class BootStrap {

    def jeuTestService

    def init = { servletContext ->
        new Utilisateur(prenom: "Hugues",nom: "Odegaard",email: "ddddd@gmail.com",sexe: "F",dateDeNaissance: new Date()).save();
        new Utilisateur(prenom: "Charles",nom: "Fallourd",email: "il_roxe_sa_maman@gmail.com",sexe: "M",dateDeNaissance: new Date()).save();
        new Utilisateur(prenom: "Jonas",nom: "Gonzalez",email: "ronron@gmail.com",sexe: "F",dateDeNaissance: new Date()).save();

        jeuTestService.createJeuTestFoActivite();
    }
    def destroy = {
    }
}