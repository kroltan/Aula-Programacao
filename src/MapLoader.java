import java.io.*;

public class MapLoader {
	static boolean Load(String URL) {
		try {
			//StringBuilder contents = new StringBuilder();
			BufferedReader input = new BufferedReader(new FileReader(URL));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					System.out.println(line);
					String[] obj = line.split(",");
					if (obj.length >=5) {
						if (obj[0].equals("map.obstacle")) {
							GerenciadorDeJogo.instancia.obstaculos.add(new Obstaculo((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4])));
						}
						if (obj[0].equals("map.spawn") && obj.length >= 6) {
							GerenciadorDeJogo.instancia.heroi = new Heroi((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4]), (short) Integer.parseInt(obj[5]));
						}
						if (obj[0].equals("map.coin") && obj.length >= 6) {
							System.out.println("asdf");
							GerenciadorDeJogo.instancia.moedas.add(new Moeda((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4]), (byte) Integer.parseInt(obj[5])));
						}
					} else if (obj.length >= 2) {
						if (obj[0].equals("meta.title")) {
							//TROCAR TITULO DA JANELA
						}
					}
				}
			} finally {
				input.close();
			}
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}