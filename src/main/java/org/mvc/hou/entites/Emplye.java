package org.mvc.hou.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYE")
public class Emplye implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeEmploye; 
	private String nomEmploye; 
	@ManyToOne
	@JoinColumn(name = "CODE_EMP_SUP")
	private Emplye employeSup; 
	@ManyToMany
	@JoinTable(name = "EMP_GR",joinColumns = 
			@JoinColumn(name="CODE_EMP"),
			inverseJoinColumns = @JoinColumn(name="CODE_GROUPE"))
	
	private Collection<Groupe> groupes;
	@OneToMany(mappedBy = "client",fetch =FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Emplye getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Emplye employeSup) {
		this.employeSup = employeSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Emplye(String nomEmploye, Emplye employeSup) {
		super();
		this.nomEmploye = nomEmploye;
		this.employeSup = employeSup;
	}
	public Emplye() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
