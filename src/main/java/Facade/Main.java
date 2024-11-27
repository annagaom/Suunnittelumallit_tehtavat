package Facade;

public class Main {
    public static void main(String[] args) {
        JokeSearchImpl jokeSearch = new JokeSearchImpl();
        ExchangeRateImpl exchangeRate = new ExchangeRateImpl();

        jokeSearch.startSearch();
        exchangeRate.startExchange();
    }
}
