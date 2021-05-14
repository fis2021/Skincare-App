package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.OfferAlreadyExistsException;
import org.loose.fis.sre.model.Offer;

import java.util.ArrayList;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OfferService {

    private static ObjectRepository<Offer> offerRepository;
    private static Nitrite database;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("offer.db").toFile())
                .openOrCreate("test", "test");

        offerRepository = database.getRepository(Offer.class);
    }
    public static void addOffer(String  nameOffer,int points ) throws OfferAlreadyExistsException {
        checkOfferDoesNotAlreadyExist(nameOffer);
        offerRepository.insert(new Offer(nameOffer,points));
    }
    public static void checkOfferDoesNotAlreadyExist(String nameOffer) throws OfferAlreadyExistsException {
        for (Offer offer : offerRepository.find()) {
            if (Objects.equals(nameOffer, offer.getNameOffer()))
                throw new OfferAlreadyExistsException(nameOffer);
        }
    }

    public static ArrayList<Offer> getAllOffers() {
        ArrayList<Offer> list = new ArrayList<>();
        for(Offer offer : offerRepository.find()) {
            list.add(offer);
        }
        return list;
    }
    public static Offer getOffer(String nameOffer){
        for(Offer offer : offerRepository.find())
            if(Objects.equals(nameOffer, offer.getNameOffer()))
                return offer;
        return null;


    }


}
