package ud5JavaBasics;

public class MetodoMathTA05 {

	public static void main(String[] args) {
		// abs(double a)
        double numAbs = -9.5;
        double absNum = Math.abs(numAbs);
        System.out.println("El valor absoluto de " + numAbs + " es " + absNum);

        // sqrt(double a)
        double numSqrt = 11;
        double sqrtNum = Math.sqrt(numSqrt);
        System.out.println("La raíz cuadrada de " + numSqrt + " es " + sqrtNum);

        // pow(double a, double b)
        double base = 3;
        double exponente = 6;
        double resultadoPotencia = Math.pow(base, exponente);
        System.out.println(base + " elevado a la potencia " + exponente + " es " + resultadoPotencia);

        // ceil(double a) y floor(double a)
        double numCeilFloor = 3.5;
        double ceilNum = Math.ceil(numCeilFloor);
        double floorNum = Math.floor(numCeilFloor);
        System.out.println("El techo de " + numCeilFloor + " es " + ceilNum);
        System.out.println("El piso de " + numCeilFloor + " es " + floorNum);

        // round(double a)
        double numRound = 5.5;
        double roundNum = Math.round(numRound);
        System.out.println("El redondeo de " + numRound + " es " + roundNum);

        // random()
        double randomNum = Math.random();
        System.out.println("Número aleatorio entre 0.0 y 1.0: " + randomNum);
    }

}


