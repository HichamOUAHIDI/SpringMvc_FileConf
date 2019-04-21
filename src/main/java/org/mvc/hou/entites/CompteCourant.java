package org.mvc.hou.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
/**
 * la class CompteCourant est une entity qui hirte de Compte donc la on utilise @DiscriminatorValue
 * si je crere un objet de type courant la colum TYPE_CPTE = CC 
 * */
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant(String codeCompte, Date dateCreation, double solde, double decouvert) {
		super(codeCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
