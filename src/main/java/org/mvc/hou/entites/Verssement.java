package org.mvc.hou.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value = "V")
public class Verssement extends Operation{

	public Verssement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Verssement(Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

}
