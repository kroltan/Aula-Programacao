

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Constantes {
	public boolean colidecircular(double X1, double Y1, double R1, double X2,
			double Y2, double R2) {
		double dx = X1 - X2;
		double dy = Y1 - Y2;
		double sr = R1 + R2;
		double d2 = dx * dx + dy * dy;

		if (d2 < (sr * sr)) {
			return true;
		}
		return false;
	}
	
	public static boolean colideRetangulo(Sprite colidindo, Sprite colisor) {
		if (colidindo.pos.x+colidindo.size.x >= colisor.pos.x && colidindo.pos.x <= colisor.pos.x+colisor.size.x && colidindo.pos.y+colidindo.size.y >= colisor.pos.y && colidindo.pos.y <= colisor.pos.y+colisor.size.y) {
			return true;
		}
		return false;
	}
	
	public static boolean colideTela(Sprite colidindo, int sizeTelaX, int sizeTelaY) {
		if (colidindo.pos.x+colidindo.size.x <= sizeTelaX && colidindo.pos.x >= 0 && colidindo.pos.y+colidindo.size.y <= sizeTelaY && colidindo.pos.y >= 0) {
			return false;
		}
		return true;
	}

	/**
	 * Lembrar de antes de utilizar esse m�todo criar um composite como vo explicar abaixo 
	 * 
	 * Composite oldComposite = dbg.getComposite();
	 * Chama o m�todo pra alterar o alpha da imagem
	 * manda desenhar
	 * Seta o alpha pro original com
	 * 
	 * dbg.setComposite(oldComposite);
	 * 
	 * @param dbg
	 * @param alpha
	 * @return DBG com alpha
	 */
	public Graphics2D ChangeAlpha(Graphics2D dbg ,float alpha) {
	      AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	      dbg.setComposite(composite);
	      return dbg;
	}

}
