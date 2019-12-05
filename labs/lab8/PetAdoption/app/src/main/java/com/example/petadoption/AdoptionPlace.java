package com.example.petadoption;



public class AdoptionPlace {
    private String adoptionPlace;
    private String adoptionPlaceURL;
    private  void setAdoptionInfo(Integer adoptionPets){
        switch (adoptionPets){
            case 0://dogs
                adoptionPlace = "PetsFinder";
                adoptionPlaceURL = "https://www.petfinder.com/search/dogs-for-adoption/us/co/boulder/";
                break;
            case 1://cats
                adoptionPlace = "PetFinder";
                adoptionPlaceURL = "https://www.petfinder.com/search/cats-for-adoption/us/co/boulder/";
                break;
            case 2://other
                adoptionPlace = "PetsFinder";
                adoptionPlaceURL = "https://www.petfinder.com/search/rabbits-for-adoption/us/co/boulder/";
                break;

            default:
                adoptionPlace = "none";
                adoptionPlaceURL = "https://www.google.com/search?q=pets+adoption&rlz=1C5CHFA_enUS859US864&oq=pets+ad&aqs=chrome.1.69i57j0l6j69i61.3330j0j4&sourceid=chrome&ie=UTF-8";
                break;
        }
    }
    public void setAdoptionPlace(Integer adoptionPets){
        setAdoptionInfo(adoptionPets);
    }
    public  void  setAdoptionPlaceURL(Integer adoptionPets){
        setAdoptionInfo(adoptionPets);

    }
    public String getAdoptionPlace(){
        return adoptionPlace;
    }
    public String getAdoptionPlaceURL(){
        return adoptionPlaceURL;
    }
}
