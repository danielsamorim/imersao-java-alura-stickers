import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {
 
    public static void main(String[] args) throws Exception {

        String key;
        Properties prop = Manipulador.getProp();
        
        key = prop.getProperty("key");
        String urlMovie = "https://api.themoviedb.org/3/movie/top_rated?api_key="+key;
                
        String body = movieTV.myMethod(urlMovie);
        
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // exibir e manipular os dados 
        for (Map<String,String> filme : listaDeFilmes) {
            String titulo = filme.get("title");
            String nomeArquivo = titulo +".png";

            String urlImagem = "https://image.tmdb.org/t/p/w500"+filme.get("backdrop_path");
            InputStream inputStream = new URL(urlImagem).openStream();

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            
            System.out.println(titulo);
            // System.out.println("https://image.tmdb.org/t/p/w500"+filme.get("backdrop_path"));
            // System.out.println(filme.get("vote_average"));
            System.out.println();
        }
    }
}


// String urlTV = "https://api.themoviedb.org/3/tv/popular?api_key="+key+"&language=en-US&page=1";
//         List<Map<String, String>> listaDeFilmes = parser.parse(body);

//         // exibir e manipular os dados 
//         for (Map<String,String> filme : listaDeFilmes) {
//             System.out.println(filme.get("original_name"));
//             System.out.println(filme.get("backdrop_path"));
//             System.out.println(filme.get("vote_average"));
//             System.out.println();
//         }