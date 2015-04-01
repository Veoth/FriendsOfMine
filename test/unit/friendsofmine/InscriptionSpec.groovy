package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Inscription)
class InscriptionSpec extends Specification {

    @Unroll
    void "test la validite d'une inscription valide"() {

        given:"un utilisateur et une activitÃ©"
        Utilisateur unUtilisateur = Mock(Utilisateur)
        Activite uneActivite = Mock(Activite)

        and:"une date"
        Date now = new Date()

        when: "une inscription est crÃ©Ã©e"
        Inscription uneInscription = new Inscription(utilisateur:unUtilisateur, activite: uneActivite, dateInscription: now)

        then: "l'inscription est valide"
        uneInscription.validate() == true

        and: "les propietes de l'inscription sont correctement mises Ã  jour"
        uneInscription.utilisateur == unUtilisateur
        uneInscription.activite == uneActivite
        uneInscription.dateInscription != null

    }

    @Unroll
    void "test l'invalidite d'une inscription non valide"() {

        given:"un utilisateur et une activitÃ©"
        Utilisateur unUtilisateur = Mock(Utilisateur)
        Activite uneActivite = Mock(Activite)

        and:"une date"
        Date now = new Date()

        when: "une inscription sans utilisateur est crÃ©Ã©e"
        Inscription uneInscription = new Inscription(utilisateur:null, activite: uneActivite, dateInscription: now)

        then: "l'inscription n'est pas validÃ©e"
        uneInscription.validate() == false

        when: "une inscription sans activitÃ© est crÃ©Ã©e"
        uneInscription = new Inscription(utilisateur:unUtilisateur, activite: null, dateInscription: now)

        then: "l'inscription n'est pas validÃ©e"
        uneInscription.validate() == false

        when: "une inscription sans date d'inscription est crÃ©Ã©e"
        uneInscription = new Inscription(utilisateur:unUtilisateur, activite: null, dateInscription: now)

        then: "l'inscription n'est pas validÃ©e"
        uneInscription.validate() == false
    }

}