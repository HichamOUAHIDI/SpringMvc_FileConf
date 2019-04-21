package org.mvc.hou.entites;
/*** 
 * 
 * @author hicham
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/**
 * dans ce cas j'ai pas spécifier la notation @DiscriminatorColumn 
 * il vas utlisé un tye par defaut 
 */
public class Operation  implements Serializable{
   private Long numOpertaion; 
   private Date dateOperation; 
   private double montant; 
   @ManyToOne
   @JoinColumn(name = "CODE_CPTE")
   private Compte compte; 
   @ManyToOne
   @JoinColumn(name = "CODE_EMP")
   private Emplye employe;
public Long getNumOpertaion() {
	return numOpertaion;
}
public void setNumOpertaion(Long numOpertaion) {
	this.numOpertaion = numOpertaion;
}
public Date getDateOperation() {
	return dateOperation;
}
public void setDateOperation(Date dateOperation) {
	this.dateOperation = dateOperation;
}
public double getMontant() {
	return montant;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public Compte getCompte() {
	return compte;
}
public void setCompte(Compte compte) {
	this.compte = compte;
}
public Emplye getEmploye() {
	return employe;
}
public void setEmploye(Emplye employe) {
	this.employe = employe;
}
public Operation(Date dateOperation, double montant) {
	super();
	this.dateOperation = dateOperation;
	this.montant = montant;
}
public Operation() {
	super();
	// TODO Auto-generated constructor stub
} 
   
   
}
