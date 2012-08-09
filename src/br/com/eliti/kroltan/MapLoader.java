package br.com.eliti.kroltan;
import java.io.*;

public class MapLoader {
	static boolean Load(String location) {
		try {
			//StringBuilder contents = new StringBuilder();
			BufferedReader input = new BufferedReader(new InputStreamReader(MapLoader.class.getResourceAsStream(location))); //n�o encontrado quando em JAR
			
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
						if (obj[0].equals("map.finish") && obj.length >= 6) {
							GerenciadorDeJogo.instancia.finish = new Finish((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)Integer.parseInt(obj[3]), (short)Integer.parseInt(obj[4]), obj[5]);
						}
					} 
					if (obj.length >= 2) {
						if (obj[0].equals("meta.title")) {
							System.out.println("Titulo: "+obj[1]);
							GamePanel.instancia.setName(obj[1]); //n�o pega!
						}
					}
					if (obj[0].equals("map.coin") && obj.length == 4) {
						GerenciadorDeJogo.instancia.moedas.add(new Moeda((short)Integer.parseInt(obj[1]), (short)Integer.parseInt(obj[2]), (short)5, (short)5, (byte) Integer.parseInt(obj[3])));
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
	public MapLoader() {
		// TODO Auto-generated constructor stub
	}
}