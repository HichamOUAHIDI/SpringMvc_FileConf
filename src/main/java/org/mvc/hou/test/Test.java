package org.mvc.hou.test;

import org.mvc.hou.entites.Client;
import org.mvc.hou.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
	public static void main(String[] args) {
		// en demande a spring de lire le ficher de configuration quand crier 
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		IBanqueMetier metier=(IBanqueMetier)context.getBean("metier");
		metier.addClient(new Client("C1", "AD1"));
		metier.addClient(new Client("C1", "AD1"));
	}
}
