package friendsofmine

import grails.transaction.Transactional

@Transactional
class ActiviteService {

    def serviceMethod() {

    }

    Activite insertOrUpdateActiviteForResponsable(Activite activite, Utilisateur responsable) {
        responsable.addToActivites(activite)
        responsable.save()

        activite.save()

        return activite
    }

    void deleteActivite(Activite activite) {
        def responsable = activite.responsable
        responsable.removeFromActivites(activite)
        activite.delete()
        responsable.save()
    }
}
