import java.io.*;

public class MapLoader {
	static void Load(String URL) {
		try {
			StringBuilder contents = new StringBuilder();
			BufferedReader input = new BufferedReader(new FileReader(URL));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					System.out.println(line);
					String[] obj = line.split(",");
					System.out.println((short)Integer.parseInt(obj[1]) +" "+ (short)Integer.parseInt(obj[2])+" "+(short)Integer.parseInt(obj[3])+" "+(short)Integer.parseInt(obj[4]));
					if (obj.length >=1) {
						if (obj[0] == "obstacle") {
							GerenciadorDeJogo.instancia.obstaculos.add(new Obstaculo((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4])));
						}
						if (obj[0] == "player" && obj.length >= 1) {
							System.out.println("asdf");
							GerenciadorDeJogo.instancia.heroi = new Heroi((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4]), (short) Integer.parseInt(obj[5]));
						}
						if (obj[0] == "coin") {
							GerenciadorDeJogo.instancia.moedas.add(new Moeda((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4]), (byte) Integer.parseInt(obj[5])));
						}
					}
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}