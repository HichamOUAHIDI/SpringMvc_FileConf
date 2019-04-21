package org.mvc.hou.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mvc.hou.entites.Client;
import org.mvc.hou.entites.Compte;
import org.mvc.hou.entites.Emplye;
import org.mvc.hou.entites.Groupe;
import org.mvc.hou.entites.Operation;

public class BanqueImp implements IBanque {

	@PersistenceContext
	private EntityManager entityManger; 
	@Override
	public Client addClient(Client c) {
		entityManger.persist(c);
		return c;
	}

	@Override
	public Emplye addEmplye(Emplye e, Long codeSup) {
		if (codeSup!=null) {
			Emplye sup = entityManger.find(Emplye.class, codeSup);
			e.setEmployeSup(sup);
		}
		entityManger.persist(e);
		return e;
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		entityManger.persist(g);
		return g;
	}

	@Override
	public void addEmployToGroup(Long CodeEmp, Long CodeGr) {
		Emplye emp = entityManger.find(Emplye.class, CodeEmp);
		Groupe group=entityManger.find(Groupe.class, CodeGr);
		emp.getGroupes().add(group);
		group.getEmployes().add(emp);
	}

	@Override
	public Compte addCompte(Compte cp, Long CodeCli, Long CodeEmp) {
		Client cli = entityManger.find(Client.class, CodeCli);
		Emplye emp = entityManger.find(Emplye.class, CodeEmp);
		cp.setClient(cli);
		cp.setEmploye(emp);
		entityManger.persist(cp);
		return cp;
	}

	@Override
	public Operation addOperation(Operation op, String codeCpe, Long CodeEmp) {
		Compte cp = consulerCompte(codeCpe);
		Emplye emp = entityManger.find(Emplye.class, codeCpe);
		op.setCompte(cp);
		op.setEmploye(emp);
		entityManger.persist(op);
		return op;
	}

	@Override
	public Compte consulerCompte(String CodeCpt) {
		Compte cp = entityManger.find(Compte.class, CodeCpt);
		return cp;
	}

	@Override
	public List<Operation> consulterOperations(String CodeCpt) {
		Query req= entityManger.createQuery("select o from Operation o where o.compte.codeCompte=:x");
		req.setParameter("x", CodeCpt);
		return req.getResultList();
	}

	@Override
	public Client consulterClient(Long codeCli) {
		Client cl = entityManger.find(Client.class, codeCli);
		return cl;
	}

	@Override
	public List<Client> consulterClients(String mc) {
		Query req= entityManger.createQuery("select c from Client c where c.nomClient like:x");
		req.setParameter("x","%" +mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Compte> geComptesByClient(Long codeCli) {
		Query req= entityManger.createQuery("select c from Compte c where c.client.codeClient=:x");
		req.setParameter("x",codeCli);
		return req.getResultList();
	}

	@Override
	public List<Compte> getComptesByEmp(Long codeEmp) {
		Query req= entityManger.createQuery("select c from Compte c where c.employe.codeEmploye=:x");
		req.setParameter("x",codeEmp);
		return req.getResultList();
	}

	@Override
	public List<Emplye> getEmplyes() {
		Query req= entityManger.createQuery("select e from Emplye e");
		return req.getResultList();
	}

	@Override
	public List<Groupe> getGroups() {
		Query req= entityManger.createQuery("select g from Groupe g");
		return req.getResultList();
	}

	@Override
	public List<Emplye> getEmplyesByGrou(Long codeGr) {
		Query req= entityManger.createQuery("select e from Emplye e where e.groupes.codeGroupe=:x");
		req.setParameter("x",codeGr);
		return null;
	}
}
