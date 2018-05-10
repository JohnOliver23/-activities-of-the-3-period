
public class Teste {
public static void main(String[] args) {
	Motorista motorista = new Motorista("João");
	Motor motor = new Motor("Zetec", 1.0);
	Carro carro = new Carro("AAAA1234",motor, motorista);
	System.out.println("Carro1 :"+carro);
	motor.setPotencia(1.4);
	motorista.setNome("José");
	System.out.println("Carro1 :"+carro);
	Motor motor2 = new Motor("fire",2.0);
	carro.setMotor(motor2);
	System.out.println("Carro1"+carro);
	Carro carro2 = new Carro("XYZ2000",carro.getMotor(), carro.getMotorista());
	System.out.println("Carro 1 :"+carro);
	System.out.println("Carro2 : "+carro2);
	
	
}
}


