package org.mvc.hou.dao;

import java.security.acl.Group;
import java.util.List;

import org.mvc.hou.entites.*;

public interface IBanque {

	public Client addClient(Client c);
	public Emplye addEmplye(Emplye e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployToGroup(Long CodeEmp,Long CodeGr);
	public Compte addCompte(Compte cp,Long CodeCli,Long CodeEmp);
	public Operation  addOperation (Operation op, String codeCpe,Long CodeEmp);
	public Compte consulerCompte(String CodeCpt);
	public List<Operation> consulterOperations(String codeCpte); 
	public Client consulterClient(Long codeCli); 
	public List<Client> consulterClients(String mc); 
	public List<Compte> geComptesByClient(Long codeCli);
	public List<Compte> getComptesByEmp(Long codeEmp);
	public List<Emplye> getEmplyes();
	public List<Groupe> getGroups();
	public List<Emplye> getEmplyesByGrou(Long codeGr);
}
