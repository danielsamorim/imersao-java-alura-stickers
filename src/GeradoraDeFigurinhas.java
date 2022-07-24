import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.plaf.FontUIResource;

public class GeradoraDeFigurinhas {
  
  public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
    // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
    // InputStream inputStream = 
    //                  new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();



      
  
    //leitura da imagem
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    //cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth(); //pega altura da imagem
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


    //copiar a imagem original para nova imagem (em memória)
    Graphics2D graphics  = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);
    
    //configurar nova fonte
    var fonte = new FontUIResource(Font.SANS_SERIF, Font.BOLD, 60);
    graphics.setColor(Color.ORANGE);
    graphics.setFont(fonte);
    //escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 200, novaAltura - 100);

    //escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }


}
