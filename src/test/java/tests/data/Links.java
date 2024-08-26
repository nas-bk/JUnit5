package tests.data;

public enum Links {
    women("https://www.lamoda.ru/women-home/?sitelink=topmenuW"),
    men("https://www.lamoda.ru/men-home/?sitelink=topmenuM"),
    kids("https://www.lamoda.ru/kids-home/?sitelink=topmenuK");

    public final String description;

    Links(String description){
        this.description = description;
    }

}
