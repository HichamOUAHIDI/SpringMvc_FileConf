package org.mvc.hou.metier;

import java.util.Date;
import java.util.List;

import org.mvc.hou.dao.IBanque;
import org.mvc.hou.entites.Client;
import org.mvc.hou.entites.Compte;
import org.mvc.hou.entites.Emplye;
import org.mvc.hou.entites.Groupe;
import org.mvc.hou.entites.Operation;
import org.mvc.hou.entites.Retrait;
import org.mvc.hou.entites.Verssement;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Transactional : En demande a spring de gerer les transaction 
 * si la methode genere une exception spring vas faire une rollback sinon il faire un commit 
 * */
@Transactional
public class BanqueMetierImp implements IBanqueMetier{
	// couplage faible 
	private IBanque dao;
	
	public void setDao(IBanque dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		return dao.addClient(c);
	}

	@Override
	public Emplye addEmplye(Emplye e, Long codeSup) {
		return dao.addEmplye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployToGroup(Long CodeEmp, Long CodeGr) {
		dao.addEmployToGroup(CodeEmp, CodeGr);
	}

	@Override
	public Compte addCompte(Compte cp, Long CodeCli, Long CodeEmp) {
		return dao.addCompte(cp, CodeCli, CodeEmp);
	}

	@Override
	public void verser(double mt, String cpte, Long codeEm) {
		dao.addOperation(new Verssement(new Date(), mt), cpte, codeEm);
		Compte cp = dao.consulerCompte(cpte);
		cp.setSolde(cp.getSolde()+mt);
	}

	@Override
	public void retirer(double mt, String cpte, Long codeEm) {
		dao.addOperation(new Retrait(new Date(), mt), cpte, codeEm);
		Compte cp = dao.consulerCompte(cpte);
		cp.setSolde(cp.getSolde() - mt);
	}

	@Override
	public void virement(double mt, String cpte1, String cpte2, Long codeEm) {
		retirer(mt, cpte1, codeEm);
		verser(mt, cpte2, codeEm);
	}

	@Override
	public Compte consulerCompte(String CodeCpt) {
		return dao.consulerCompte(CodeCpt);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		return dao.consulterOperations(codeCpte);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> geComptesByClient(Long codeCli) {
		return dao.geComptesByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmp(Long codeEmp) {
		return dao.getComptesByEmp(codeEmp);
	}

	@Override
	public List<Emplye> getEmplyes() {
		return dao.getEmplyes();
	}

	@Override
	public List<Groupe> getGroups() {
		return dao.getGroups();
	}

	@Override
	public List<Emplye> getEmplyesByGrou(Long codeGr) {
		return dao.getEmplyesByGrou(codeGr);
	}

}
