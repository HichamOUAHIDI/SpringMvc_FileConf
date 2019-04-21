package org.mvc.hou.metier;

import java.util.List;

import org.mvc.hou.entites.Client;
import org.mvc.hou.entites.Compte;
import org.mvc.hou.entites.Emplye;
import org.mvc.hou.entites.Groupe;
import org.mvc.hou.entites.Operation;

public interface IBanqueMetier {
	public Client addClient(Client c);
	public Emplye addEmplye(Emplye e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployToGroup(Long CodeEmp,Long CodeGr);
	public Compte addCompte(Compte cp,Long CodeCli,Long CodeEmp);
	public void verser(double mt,String cpte,Long codeEm);
	public void retirer(double mt,String cpte,Long codeEm);
	public void virement(double mt,String cpte1,String cpte2,Long codeEm);
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
