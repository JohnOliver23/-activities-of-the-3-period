package view;

public class BatalhaNaval {
	private int boat10 = 0;//barco de 10 pontos
	private int boat15 = 0;//barco de 15 pontos
	private int boat20 = 0;// barco de 20 pontos
	int points = 0;
	private int life = 15;
	int sort;//numero sorteado
	private static int point10 = 0;//flag que guarda o barco de 10 pontos
	
	public int sortear() {
		return (int) (0 + Math.random() * 9);
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public void decrementaLife() {
		this.life = this.life-1;
	}
	
	public void addLife() {
		this.life = this.life+1;
	}

	public int getBoat10() {
		return boat10;
	}

	public void setBoat10(int boat10) {
		this.boat10 = boat10;
	}

	public int getBoat15() {
		return boat15;
	}

	public void setBoat15(int boat15) {
		this.boat15 = boat15;
	}

	public int getBoat20() {
		return boat20;
	}

	public void setBoat20(int boat20) {
		this.boat20 = boat20;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
}
