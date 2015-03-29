package friendsofmine

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Activite)
class ActiviteSpec extends Specification {

    @Unroll
    void "test la validite d'une activite valide"(String unTitre, String unDescriptif) {

        given: "une activite initialise avec un titre non vide et un descriptif"
        Activite activite = new Activite(titre: unTitre, descriptif: unDescriptif)

        expect: "l'activite est valide"
        activite.validate() == true

        where:
        unTitre    | unDescriptif
        "un titre" | null
        "un titre" | ""
        "un titre" | "un descriptif"

    }

    @Unroll
    void "test l'invalidite d'une activite non valide"(String unTitre, String _) {

        given: "une activite initialise avec un titre vide"
        Activite activite = new Activite(titre: unTitre)

        expect: "l'activite est invalide"
        activite.validate() == false

        where:
        unTitre | _
        null    | _
        ""      | _

    }
}