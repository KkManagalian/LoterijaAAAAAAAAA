import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class PatstavigaisDarbs {

	public static void main(String[] args) {
		
		String izvele;
		int Laiks=0;
		Random rand = new Random();
		Stack<Integer> Izlozetie = new Stack<>();
		Stack<Integer> Laimejosie = new Stack<>();

		
		String[] darbibas = {"Veikt izlozi", "Laimīgo skaitļu apskate", "Apturēt"};
		
		do {
			
			izvele=(String)JOptionPane.showInputDialog(null,"Izvēlies darbību", "Darbību saraksts", JOptionPane.PLAIN_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele==null)
				break;
			
			switch(izvele) {
			case"Veikt izlozi":
				if(Laiks==0) {
					do {
						for(int i=0;i<10;i++) {
						int Skaitlis = rand.nextInt(10);
						Izlozetie.push(Skaitlis);
						
						
						
						Laimejosie.push(Izlozetie.pop());
						Laiks+=1;
						}
					}while(Laiks==0);

				}else {
					JOptionPane.showMessageDialog(null, "Nav pagājusi minūte!","Brīdinājums",JOptionPane.WARNING_MESSAGE);
				}
				break;
			
			case"Laimīgo skaitļu apskate":
				if(!Laimejosie.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Laimējošie skaitļi ir: "+Laimejosie);
					
					}else {
					JOptionPane.showMessageDialog(null, "Laimests nav veikts!");
				}
				break;
				
			case"Apturēt":
				
				break;
			}
			
		}while(!izvele.equals("Apturēt"));
		
	}

}
