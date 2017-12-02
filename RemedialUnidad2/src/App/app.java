package App;

import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import ListasCirculares.ListasCirculares;
import ListasDobles.ListasDobles;
import ListasSimples.ListasSimples;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("-------------Listas-Dobles--------");
		ListasDobles<String> ld=new ListasDobles<String>();
		ListIterator <String> lit=ld.listiterator();
		
		ld.add("Gustavo");
		ld.add("Norma");
		ld.add("Milton");
		ld.add("Ricardo");
		ld.add("Angela");
		
		
		ld.addAfter(6, "Ana");//Metodo 1
		ld.replace("Ricardo", "Emanuel");//Metodo 4
		System.out.println("Valor: "+ld.forPosition(3));//Metodo 2
		System.out.println("Indice: "+ld.forValue("Milton"));//Metodo 3
		System.out.println("-----------------Lista------------");
		ld.list(lit);
		System.out.println("----------------------------------");
		System.out.println("-------------Listas-Simples-------");
		ListasSimples<String> ls=new ListasSimples<String>();
		ListasSimples<String> ls2=new ListasSimples<String>();
		Iterator<String> it=ls.iterator();
		Iterator<String> it2=ls2.iterator();
		
		


		ls.addASC("Carol");
		ls.addASC("Beto");
		ls.addASC("Zapato");
		ls.addASC("Andrea");
		ls.addASC("Gonzalo");
		ls.addASC("Oscar");
		ls.addASC("Aaron");
		ls.addASC("Edna");
		System.out.println("------------------Lista-ASC----------");
		ls.list(it);
		System.out.println("-------------------------------------");
		ls2.addDSC("Carol");
		ls2.addDSC("Beto");
		ls2.addDSC("Zapato");
		ls2.addDSC("Andrea");
		ls2.addDSC("Gonzalo");
		ls2.addDSC("Oscar");
		ls2.addDSC("Aaron");
		ls2.addDSC("Edna");
		System.out.println("------------------Lista-DSC----------");
		ls2.list(it2);
		System.out.println("-------------------------------------");
		System.out.println("------------Lstas-Circulares---------");
		ListasCirculares<Integer> nums=new ListasCirculares<Integer>();
		
		
		nums.addFirst(1);
		nums.addFirst(3);
		nums.addFirst(2);
		nums.addFirst(4);
		nums.addFirst(5);
		
		int potencia=Integer.parseInt(JOptionPane.showInputDialog("¿A que potencia?"));
		System.out.println("-------------------Lista---------------");
		nums.List();
		System.out.println("----------Lista-con-exponente---------");
		nums.ListEx(potencia);
		
		
		
	}

}
