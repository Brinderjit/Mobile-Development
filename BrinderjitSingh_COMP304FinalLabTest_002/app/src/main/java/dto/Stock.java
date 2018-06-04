package dto;

/**
 * Created by Brinder Saini on 11/01/2018.
 */

public class Stock {
    private String stockSymbol;
    private String companyName;
    private int stockQuote;
    public Stock(){

    }
    public Stock(String stockSymbol,String companyName,int stockQuote){

    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getStockQuote() {
        return stockQuote;
    }

    public void setStockQuote(int stockQuote) {
        this.stockQuote = stockQuote;
    }




}
