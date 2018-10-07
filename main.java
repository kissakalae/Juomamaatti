import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
	juomamaatti omaKone = new juomamaatti();
	Scanner skanneri = new Scanner(System.in);
	int i = 0;
	
	do {
		System.out.println("*****Juoma-automaatti***** \n" + 
				"1. Tee \n" +
				"2. Kahvi \n" + 
				"3. Kaakao \n" +
				"4. Lopeta");
	i = skanneri.nextInt();
		if (i<1 || i>4) {
			System.out.println("V‰‰r‰ valinta.");
		} else if (i == 4){
			System.exit(0);
		} else if (i == 1) {
			omaKone.valmistaTee();
		} else if (i == 2) {
			omaKone.valmistaKahvi();
		} else if (i == 3) {
			omaKone.valmistaKaakao();
		}
	} while (i != 4);
	}
}