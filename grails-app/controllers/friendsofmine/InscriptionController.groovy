package friendsofmine


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InscriptionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def inscriptionService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Inscription.list(params), model: [inscriptionInstanceCount: Inscription.count()]
    }

    def show(Inscription inscriptionInstance) {
        respond inscriptionInstance
    }

    def create() {
        respond new Inscription(params)
    }

    @Transactional
    def save(Inscription inscriptionInstance) {
        if (inscriptionInstance == null) {
            notFound()
            return
        }

        if (inscriptionInstance.hasErrors()) {
            respond inscriptionInstance.errors, view: 'create'
            return
        }

        //inscriptionInstance.save flush: true
        inscriptionService.insertOrUpdateInscription(inscriptionInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'inscription.label', default: 'Inscription'), inscriptionInstance.id])
                redirect inscriptionInstance
            }
            '*' { respond inscriptionInstance, [status: CREATED] }
        }
    }

    def edit(Inscription inscriptionInstance) {
        respond inscriptionInstance
    }

    @Transactional
    def update(Inscription inscriptionInstance) {
        if (inscriptionInstance == null) {
            notFound()
            return
        }

        if (inscriptionInstance.hasErrors()) {
            respond inscriptionInstance.errors, view: 'edit'
            return
        }

        //inscriptionInstance.save flush: true
        inscriptionService.insertOrUpdateInscription(inscriptionInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Inscription.label', default: 'Inscription'), inscriptionInstance.id])
                redirect inscriptionInstance
            }
            '*' { respond inscriptionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Inscription inscriptionInstance) {

        if (inscriptionInstance == null) {
            notFound()
            return
        }

        //inscriptionInstance.delete flush: true
        inscriptionService.deleteInscription(inscriptionInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Inscription.label', default: 'Inscription'), inscriptionInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscription.label', default: 'Inscription'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
