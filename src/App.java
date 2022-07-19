import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {
 
    public static void main(String[] args) throws Exception {

        String key;
        Properties prop = Manipulador.getProp();
        
        key = prop.getProperty("key");
        String urlMovie = "https://api.themoviedb.org/3/movie/top_rated?api_key="+key;
        //https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060
        
        
        String body = movieTV.myMethod(urlMovie);
        
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados 
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("backdrop_path"));
            System.out.println(filme.get("vote_average"));
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