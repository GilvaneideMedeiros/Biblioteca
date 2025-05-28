import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Principal extends Livro {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("\nDigite o título do livro: ");
        String titulo = leitura.nextLine();

        try {
            String title = URLEncoder.encode(titulo, StandardCharsets.UTF_8.toString());
            String url = "https://www.googleapis.com/books/v1/volumes?q=" + title;

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest requisicao = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson(); //utilizando o Gson
            Principal dados = gson.fromJson(resposta.body(), Principal.class);

            RespostaDados dadosAPI = gson.fromJson(resposta.body(), RespostaDados.class);
            if (dados.getItems() != null && !dados.getItems().isEmpty()) {
                VolumeInfo volumeInfo = dados.getItems().get(0).volumeInfo;

                String titleLivro = volumeInfo.title;
                String authors;
                if (volumeInfo.authors != null && !volumeInfo.authors.isEmpty()) {
                    authors = String.join(", ", volumeInfo.authors);
                } else {
                    authors = "Não informado";
                }

                String publisher = volumeInfo.publisher != null ? volumeInfo.publisher : "Não informado";
                String publishedDate = volumeInfo.publishedDate != null ? volumeInfo.publishedDate : "Não informado";
                String description = volumeInfo.description != null ? volumeInfo.description : "Não informado";
                String language = volumeInfo.language != null ? volumeInfo.language : "Não informado";
                String previewLink = volumeInfo.previewLink != null ? volumeInfo.previewLink : "Não informado";
                String infoLink = volumeInfo.infoLink != null ? volumeInfo.infoLink : "Não informado";

                System.out.println("\n--- Informações do livro ---");
                System.out.println("Título: " + titleLivro);
                System.out.println("Autores: " + authors);
                System.out.println("Editora: " + publisher);
                System.out.println("Data de publicação: " + publishedDate);
                System.out.println("Descrição: " + description);
                System.out.println("Idioma: " + language);
                System.out.println("Link de prévia: " + previewLink);
                System.out.println("Link de informações: " + infoLink);
            } else {
                System.out.println("Nenhum livro encontrado com o título: " + titulo);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Ocorreu um erro ao busar o livro: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            leitura.close();
        }
    }
}





