
public class juomamaatti {
	
	private int tee;
	private int kahvi;
	private int kaakao;
	
	public juomamaatti() {
		this.tee = 50;
		this.kahvi = 50;
		this.kaakao = 50;
	}
	
	// TEE
	
	public int getTee() {
		return tee;
	}

	public void setTee() {
		this.tee = tee;
		
	}
	
	public void valmistaTee() {
		if (getTee() >= 10) {
		this.tee -= 10;
		System.out.println("Odota hetki, teesi valmistuu. Teet� j�ljell� " + getTee() + " yksikk��.");
		} else {
		System.out.println("Teet� ei ole en�� j�ljell�! T�yt� s�ili�.");
		}
	}

	// KAHVI
	
	public int getKahvi() {
		return kahvi;
	}

	public void setKahvi() {
		this.kahvi = kahvi;
	}

	public void valmistaKahvi() {
		if (getKahvi() >= 10) {
		this.kahvi -= 10;
		System.out.println("Odota hetki, kahvisi valmistuu. Kahvia j�ljell� " + getKahvi() + " yksikk��.");		
		} else {
		System.out.println("Kahvia ei ole en�� j�ljell�! T�yt� s�ili�.");
		}
	}
	
	// KAAKAO
	
	public int getKaakao() {
		return kaakao;
	}
	
	public void setKaakao() {
		this.kaakao = kaakao;
	}
	
	public void valmistaKaakao() {
		if (getKaakao() >= 10) {
		this.kaakao -= 10;
		System.out.println("Odota hetki, kaakaosi valmistuu. Kaakaota j�ljell� " + getKaakao() + " yksikk��.");	
		} else {
		System.out.println("Kaakaota ei ole en�� j�ljell�! T�yt� s�ili�.");
		}
	}	
	
}
