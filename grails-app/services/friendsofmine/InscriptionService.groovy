package friendsofmine

import grails.transaction.Transactional

@Transactional
class InscriptionService {

    def serviceMethod() {

    }

    Inscription insertOrUpdateInscription(Inscription uneInscription) {
        uneInscription.dateInscription = new Date();

        uneInscription.save()

        uneInscription
    }

    void deleteInscription(uneInscription) {

        uneInscription.delete()
    }
}
