package friendsofmine


import spock.lang.*

/**
 *
 */
class JeuTestServiceIntegrationSpec extends Specification {

    JeuTestService jeuTestService

    void "test creation jeu de tests pour activitÃ©s"() {

        given: "une base ne contenant pas d'activitÃ©s"
        Activite.count() == 0

        when: "on crÃ©e le jeu de test pour les activite"
        jeuTestService.createJeuTestFoActivite()

        then: "3 nouvelles activitÃ©s ont Ã©tÃ© crÃ©es en base"
        Activite.count() == 3


        when:" des activites exitent deja dans la base"
        Activite.count() == 3

        and:"on dÃ©clenche Ã  nouveau la crÃ©ation du jeu de test pour activitÃ©"
        jeuTestService.createJeuTestFoActivite()

        then:"aucune nouvelle activitÃ© n'est crÃ©e"
        Activite.count() == 3

    }
}