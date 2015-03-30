<%@ page import="friendsofmine.Utilisateur" %>



<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'nom', 'error')} required">
    <label for="nom">
        <g:message code="utilisateur.nom.label" default="Nom"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="nom" required="" value="${utilisateurInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'prenom', 'error')} required">
    <label for="prenom">
        <g:message code="utilisateur.prenom.label" default="Prenom"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="prenom" required="" value="${utilisateurInstance?.prenom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'email', 'error')} required">
    <label for="email">
        <g:message code="utilisateur.email.label" default="Email"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="email" name="email" required="" value="${utilisateurInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'sexe', 'error')} required">
    <label for="sexe">
        <g:message code="utilisateur.sexe.label" default="Sexe"/>
        <span class="required-indicator">*</span>
    </label>
    <g:select name="sexe" from="${utilisateurInstance.constraints.sexe.inList}" required=""
              value="${utilisateurInstance?.sexe}" valueMessagePrefix="utilisateur.sexe"/>

</div>

<div class="fieldcontain ${hasErrors(bean: utilisateurInstance, field: 'dateDeNaissance', 'error')} ">
    <label for="dateDeNaissance">
        <g:message code="utilisateur.dateDeNaissance.label" default="Date De Naissance"/>

    </label>
    <g:datePicker name="dateDeNaissance" precision="day" value="${utilisateurInstance?.dateDeNaissance}" default="none"
                  noSelection="['': '']"/>

</div>

