package friendsofmine


import spock.lang.*

/**
 *
 */
class ActiviteServiceIntegrationTestSpec extends Specification {

    ActiviteService activiteService

    void "test insertion ou mise Ã  jour d'une  activitÃ© avec responsable"() {

        given:"une activitÃ©"
        Activite uneActivite = new Activite(titre: "act1")

        and: "un responsable"
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne",sexe: "F",email: "j@j.com")

        when: "on tente de rÃ©percuter en base la crÃ©ation ou la modification de l'activitÃ©"
        Activite resultActivite = activiteService.insertOrUpdateActiviteForResponsable(uneActivite,unResponsable)

        then: "l'activite resultante pointe sur l'activite initale"
        resultActivite == uneActivite

        and:"l'activitÃ© rÃ©sultante n'a pas d'erreur"
        !resultActivite.hasErrors()

        and:"l'activitÃ© rÃ©sultante a un id"
        resultActivite.id

        and:"l'activitÃ© est bien presente en base"
        Activite.findById(resultActivite.id) != null

        and: "l'activite a pour responsable le responsable passÃ© en paramÃ¨tre"
        resultActivite.responsable == unResponsable

        and:"le responsable a dans sa liste d'activitÃ© l'activitÃ© passÃ© en paramÃ¨tre"
        unResponsable.activites.contains(resultActivite)
    }

    void "test suppression d'une activitÃ©"() {

        given: "une activitÃ© existante en base"
        Activite uneActivite = new Activite(titre: "act1")
        Utilisateur unResponsable = new Utilisateur(nom: "Dupont", prenom: "Jeanne",sexe: "F",email: "j@j.com")
        uneActivite = activiteService.insertOrUpdateActiviteForResponsable(uneActivite,unResponsable)

        when:"on tente de supprimer l'activitÃ©"
        activiteService.deleteActivite(uneActivite)

        then:"l'activite n'existe plus en base"
        Activite.findById(uneActivite.id) == null

        and:"le responsable n'a plus l'activite dans sa liste d'activitÃ©"
        !unResponsable.activites.contains(uneActivite)
    }
}