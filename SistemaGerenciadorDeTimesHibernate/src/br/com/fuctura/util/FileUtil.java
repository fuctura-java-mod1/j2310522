package br.com.fuctura.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileUtil {

	public static byte[] carregarFoto(String caminhoCompleto) throws IOException {
		BufferedImage bImage = ImageIO.read(new File(caminhoCompleto));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", bos);
		byte[] data = bos.toByteArray();
		return data;
	}

}
