package by.bsu.veget.storage;

import by.bsu.veget.ierarh.Vegetable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 28.11.11
 * Time: 15:45
 */
public class VegetComparators {
    List<Vegetable> ls;

    VegetComparators(List<Vegetable> list) {
        ls = list;
    }

    public void sortBy(String by) {
        Comparator<Vegetable> com;
        switch (by) {
            case "enum":
                com = new CompareByVegEnumId();
                break;
            case "country":
                com = new CompareByVegCountry();
                break;
            case "date":
                com = new CompareByVegDate();
                break;
            case "weight":
                com = new CompareByVegWeight();
                break;
            case "price":
                com = new CompareByVegPrice();
                break;
            default:
                com = new CompareByVegId();
                break;
        }
        Collections.sort(ls, com);
    }

    class CompareByVegId implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable u1, Vegetable u2) {
            return u1.getId() - u2.getId();
        }
    }

    class CompareByVegEnumId implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable u1, Vegetable u2) {
            return u1.getVegetEnumId() - u2.getVegetEnumId();
        }
    }

    class CompareByVegCountry implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable u1, Vegetable u2) {
            return u1.getProduceCountry().compareTo(u2.getProduceCountry());
        }
    }

    class CompareByVegDate implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable u1, Vegetable u2) {
            return u1.getColectDate().compareTo(u2.getColectDate());
        }
    }

    class CompareByVegWeight implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable u1, Vegetable u2) {
            return u1.getWeightPerKg().compareTo(u2.getWeightPerKg());
        }
    }

    class CompareByVegPrice implements Comparator<Vegetable> {
        @Override
        public int compare(Vegetable u1, Vegetable u2) {
            return u1.getPricePerKg().compareTo(u2.getPricePerKg());
        }
    }
}
