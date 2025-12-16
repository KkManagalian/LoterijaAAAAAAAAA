import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class PatstavigaisDarbs {

	public static void main(String[] args) {
		
		String izvele;
		Random rand = new Random();
		Stack<Integer> Izlozetie = new Stack<>();
		Stack<Integer> Laimejosie = new Stack<>();
		long Pauze =60000;
		String[] darbibas = {"Veikt izlozi", "Laimīgo skaitļu apskate", "Apturēt"};
		
		do {
			izvele=(String)JOptionPane.showInputDialog(null,"Izvēlies darbību", "Darbību saraksts", JOptionPane.PLAIN_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele==null)
				break;
			
			long Laiks=System.currentTimeMillis();
			
			switch(izvele) {
			case"Veikt izlozi":
				if(Laiks>Pauze) {
					do {
						while(Laimejosie.size()<3) {
						for(int i=0;i<10;i++) {
						int Skaitlis = rand.nextInt(10);
						Izlozetie.push(Skaitlis);
						}
						
						System.out.println(Izlozetie);
						for(int i=0;i<rand.nextInt(8)+1;i++) {
							Izlozetie.pop();
							}
						System.out.println(Izlozetie);
					Laimejosie.push(Izlozetie.pop());
						}
						
						Laiks+=60;
					}while(Laiks==0);
					
					LocalTime IstsLaiks = LocalTime.now();
					DateTimeFormatter Formats = DateTimeFormatter.ofPattern("HH:mm:ss");
				    String Formatets = IstsLaiks.format(Formats);
					JOptionPane.showMessageDialog(null, "Izlozes laiks ir: "+Formatets);
					Pauze=Laiks+60000;

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
