package friendsofmine

import grails.transaction.Transactional

@Transactional
class JeuTestService {

    def serviceMethod() {

    }

    void createJeuTestFoActivite() {
        if (Activite.count() == 0) {
            new Activite(titre: "Foot", descriptif: "Jouer au foot", responsable: Utilisateur.findByNom("Odegaard")).save()
            new Activite(titre: "Tennis", descriptif: "Jouer au Tennis", responsable: Utilisateur.findByNom("Odegaard")).save()
            new Activite(titre: "Badminton", descriptif: "Jouer au badminton", responsable: Utilisateur.findByNom("Gonzalez")).save()
        }
    }
}
