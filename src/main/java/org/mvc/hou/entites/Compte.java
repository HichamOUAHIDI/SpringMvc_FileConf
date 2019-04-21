package org.mvc.hou.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
/**
 * cette annotation pour l'heritage on utilisan la strategie single_table
 * Single_table tout les type de compte on vas les enrgister dans la meme table 
 * mais la on doit declarer une variable pour déferencier entre les compte
 * */  
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE",
discriminatorType = DiscriminatorType.STRING,length =4)
public class Compte implements Serializable{
	@Id
	private String codeCompte; 
	private Date dateCreation; 
	private double solde; 
	@ManyToOne
	@JoinColumn(name ="CODE_CLI")
	private Client client;
	@ManyToOne
	@JoinColumn(name ="CODE_EMP")
	private Emplye employe;
	@OneToMany(mappedBy = "compte")
	private List<Operation> operation;
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Emplye getEmploye() {
		return employe;
	}
	public void setEmploye(Emplye employe) {
		this.employe = employe;
	}
	public List<Operation> getOperation() {
		return operation;
	}
	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}
	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	

	
	
}
