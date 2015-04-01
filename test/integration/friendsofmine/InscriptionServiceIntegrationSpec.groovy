package friendsofmine


import spock.lang.*

/**
 *
 */
class InscriptionServiceIntegrationSpec extends Specification {

    Activite uneActivite
    Utilisateur unUtilisateur

    ActiviteService activiteService
    InscriptionService inscriptionService

    def setup() {
        // l'activitÃ©
        uneActivite = new Activite(titre: "act1")
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne", sexe: "F", email: "j@j.com")
        activiteService.insertOrUpdateActiviteForResponsable(uneActivite, unResponsable)

        // l'utilisateur
        unUtilisateur = new Utilisateur(nom: "Durand", prenom: "paul", sexe: "M", email: "p@j.com").save()
    }

    void "test la crÃ©ation ou la mise Ã  jour d'une inscription"() {

        given: "une inscription"
        Inscription uneInscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)


        when: "on insert ou met Ã  jour l'inscription"
        Inscription resInscription = inscriptionService.insertOrUpdateInscription(uneInscription)

        then: "l'inscription isÃ©rÃ©e est bien celle retournÃ©e"
        resInscription == uneInscription

        and:"l'inscription a bien un id"
        uneInscription.id != null

        and:"elle est valide"
        uneInscription.validate()

        and:"elle est bien stockÃ©e en base"
        Inscription.findById(uneInscription.id) != null

        and :"les propriÃ©tes sont mises Ã  jours comme attendues"
        uneInscription.activite == uneActivite
        uneInscription.utilisateur == unUtilisateur
        uneInscription.dateInscription != null
    }

    void "test de la suppression d'une inscription"() {

        given:"une inscription existante en base"
        Inscription uneInscription = new Inscription(activite: uneActivite, utilisateur: unUtilisateur)
        inscriptionService.insertOrUpdateInscription(uneInscription)

        when:"on dÃ©clenche la suppression de l'inscription"
        inscriptionService.deleteInscription(uneInscription)

        then:"l'inscription est supprimÃ©e de la base"
        Inscription.findById(uneInscription.id) == null

        and:"ni l'activitÃ©, ni l'utilisateur ne sont supprimÃ©s"
        Activite.findById(uneActivite.id) != null
        Utilisateur.findById(unUtilisateur.id) != null

    }
}