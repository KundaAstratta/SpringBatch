package filrouge.training.batch.springbatchdemo.dto;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

//@Entity
public class CollaboratorDTO {

/*
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
*/
    private String uid;
    private String civilite;
    private String nom;
    private String prenom;
    private String fonction;
    private String telephone;
    private String mail;
    private String etage;
    private String uoAffectation;
    private String codeImmeubleEmplacementCollaborateur;
    private String region;
    private String codeRegion;
    private String niveauTerritoire;
    private String codeTerritoire;
    private String niveauEntite;
    private String codeEntite;
    private String niveauAgence;
    private String codeAgence;
    private String localisationCollaborateur;
    private String pj;
    private String aMigrer;
/*
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
*/

    public CollaboratorDTO(){}

    public CollaboratorDTO(String uid, String civilite, String nom, String prenom, String fonction, String telephone, String mail, String etage, String uoAffectation, String codeImmeubleEmplacementCollaborateur, String region, String codeRegion, String niveauTerritoire, String codeTerritoire, String niveauEntite, String codeEntite, String niveauAgence, String codeAgence, String localisationCollaborateur, String pj,
                           String aMigrer) {
     //   this.id=id;
        this.uid = uid;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.telephone = telephone;
        this.mail = mail;
        this.etage = etage;
        this.uoAffectation = uoAffectation;
        this.codeImmeubleEmplacementCollaborateur = codeImmeubleEmplacementCollaborateur;
        this.region = region;
        this.codeRegion = codeRegion;
        this.niveauTerritoire = niveauTerritoire;
        this.codeTerritoire = codeTerritoire;
        this.niveauEntite = niveauEntite;
        this.codeEntite = codeEntite;
        this.niveauAgence = niveauAgence;
        this.codeAgence = codeAgence;
        this.localisationCollaborateur = localisationCollaborateur;
        this.pj = pj;
        this.aMigrer = aMigrer;
      //  this.createDateTime= createDateTime;
      //  this.updateDateTime=updateDateTime;
    }

/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

*/
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getUoAffectation() {
        return uoAffectation;
    }

    public void setUoAffectation(String uoAffectation) {
        this.uoAffectation = uoAffectation;
    }

    public String getCodeImmeubleEmplacementCollaborateur() {
        return codeImmeubleEmplacementCollaborateur;
    }

    public void setCodeImmeubleEmplacementCollaborateur(String codeImmeubleEmplacementCollaborateur) {
        this.codeImmeubleEmplacementCollaborateur = codeImmeubleEmplacementCollaborateur;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getNiveauTerritoire() {
        return niveauTerritoire;
    }

    public void setNiveauTerritoire(String niveauTerritoire) {
        this.niveauTerritoire = niveauTerritoire;
    }

    public String getCodeTerritoire() {
        return codeTerritoire;
    }

    public void setCodeTerritoire(String codeTerritoire) {
        this.codeTerritoire = codeTerritoire;
    }

    public String getNiveauEntite() {
        return niveauEntite;
    }

    public void setNiveauEntite(String niveauEntite) {
        this.niveauEntite = niveauEntite;
    }

    public String getCodeEntite() {
        return codeEntite;
    }

    public void setCodeEntite(String codeEntite) {
        this.codeEntite = codeEntite;
    }

    public String getNiveauAgence() {
        return niveauAgence;
    }

    public void setNiveauAgence(String niveauAgence) {
        this.niveauAgence = niveauAgence;
    }

    public String getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(String codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getLocalisationCollaborateur() {
        return localisationCollaborateur;
    }

    public void setLocalisationCollaborateur(String localisationCollaborateur) {
        this.localisationCollaborateur = localisationCollaborateur;
    }

    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getaMigrer() {
        return aMigrer;
    }

    public void setaMigrer(String aMigrer) {
        this.aMigrer = aMigrer;
    }



/*

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

*/

}
