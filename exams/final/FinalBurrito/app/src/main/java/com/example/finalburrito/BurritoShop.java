package com.example.finalburrito;

public class BurritoShop {

    private String burritoShop;
    private String burritoShopURL;



    private void setBurritoInfo(Integer burritoCrowd){
        switch (burritoCrowd){
            case 0: //peal
                burritoShop="Bartaco";
                burritoShopURL="https://bartaco.com/";
                break;
            case 1: //29
                burritoShop="Chipotle";
                burritoShopURL="https://order.chipotle.com/?utm_source=google&utm_medium=cpc&utm_campaign=Brand_Top_Exact&utm_content=chipotle&gclid=EAIaIQobChMIz9qMzuS95gIVEtNkCh37ygCMEAAYASAAEgI7ovD_BwE&gclsrc=aw.ds";
                break;
            case 2: //hill
                burritoShop="Petes";
                burritoShopURL="https://www.illegalpetes.com/location/illegal-petes-boulder-pearl-street/";
                break;

            default:
                burritoShop="none";
                burritoShopURL="https://www.google.com/search?q=boulder+coffee+shops&ie=utf-8&oe=utf-8";
        }
    }

    public String getBurritoShop(){
        return burritoShop;
    }

    public String getburritoeShopURL(){
        return burritoShopURL;
    }

    public void setBurritoShop(Integer burritoCrowd){
        setBurritoInfo(burritoCrowd);
    }

    public void setburritoShopURL(Integer burritoCrowd){
        setBurritoInfo(burritoCrowd);
    }

}
