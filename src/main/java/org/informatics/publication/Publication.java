package org.informatics.publication;

import org.informatics.printingshop.PrintingShop;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Publication {
    private String title;
    private int count;
    private int countDiscount;
    private double discount;
    private static int maxPaperSheets;
    private PublicationType publicationType;
    private SizePage sizePage;
    private TypePaper typePaper;
    private MachineType machineType;
    public Publication(String title, int count, PublicationType publicationType, SizePage sizePage, TypePaper typePaper, MachineType machineType, PrintingShop printingShop) {
        this.title = title;
        this.count = count;
        this.publicationType = publicationType;
        this.sizePage = sizePage;
        this.typePaper = typePaper;
        this.machineType = machineType;
        printingShop.addPublication(this);
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public String getTitle() {
        return title;
    }

    public static int getMaxPaperSheets() {
        return maxPaperSheets;
    }

    public static void setMaxPaperSheets(int maxPaperSheets) {
        Publication.maxPaperSheets = maxPaperSheets;
    }

    public int getCountDiscount() {
        return countDiscount;
    }

    public void setCountDiscount(int countDiscount) {
        this.countDiscount = countDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getCount() {
        return count;
    }

    public void checkPaperLoad() throws PaperLoadedException {
        if(count > maxPaperSheets) {
            throw new PaperLoadedException(maxPaperSheets, this);
        }
    }
    public double priceOfPaper() {
        Map<String, Double> paperPrices = createPaperPriceMap();
        String paperKey = sizePage.name() + "_" + typePaper.name();
        return paperPrices.getOrDefault(paperKey, 0.0);
    }
    private static Map<String, Double> createPaperPriceMap() {
        Map<String, Double> paperPrices = new HashMap<>();
        // Add size and type combinations with prices to the map
        paperPrices.put("A1_NORMAL", 9.23);
        paperPrices.put("A2_NORMAL", 8.32);
        paperPrices.put("A3_NORMAL", 7.43);
        paperPrices.put("A4_NORMAL", 6.12);
        paperPrices.put("A5_NORMAL", 5.74);
        paperPrices.put("A1_GLOSSY", 9.63);
        paperPrices.put("A2_GLOSSY", 8.76);
        paperPrices.put("A3_GLOSSY", 7.53);
        paperPrices.put("A4_GLOSSY", 6.73);
        paperPrices.put("A5_GLOSSY", 5.03);
        paperPrices.put("A1_PAPER", 6.23);
        paperPrices.put("A2_PAPER", 5.67);
        paperPrices.put("A3_PAPER", 4.48);
        paperPrices.put("A4_PAPER", 3.42);
        paperPrices.put("A5_PAPER", 2.37);
        return paperPrices;
    }

}
