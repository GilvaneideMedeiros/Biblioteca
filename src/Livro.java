import java.util.List;

public class Livro{

    private String title;
    private String authors;
    private String publisher;
    private int publisherDate;
    private String identifier;
    private String country;
    private String language;
    private String listPrice;

    public List<Item> items;

    public Livro() { //Construtor sem argumentos (usado pelo Gson)
    }

    public Livro(String title, String authors, String publisher, int publisherDate, String identifier, String country, String language, String listPrice, List<Item> items) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publisherDate = publisherDate;
        this.identifier = identifier;
        this.country = country;
        this.language = language;
        this.listPrice = listPrice;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getEditora() {
        return publisher;
    }

    public int getpublisherDate() {
        return publisherDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getListPrice() {
        return listPrice;
    }

    public List<Item> getItems() { return items; }

    public void setItems(List<Item> items) { this.items = items; }


    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + title + '\'' +
                "items=" + (items != null ? items.size() + "items" : "null") + '}';

    }
}
