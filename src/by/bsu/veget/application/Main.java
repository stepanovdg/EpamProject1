package by.bsu.veget.application;

import by.bsu.veget.data.ReadSalat;
import by.bsu.veget.data.ReadVeget;
import by.bsu.veget.exception.VegetException;
import by.bsu.veget.out.VegetOutManager;
import by.bsu.veget.reports.VegetStorageReport;
import by.bsu.veget.reports.VegetStorageXMLReport;

class Main {
     /**
     * @param args
     * @author Stepanov Dmitriy
     */

    public static void main(String[] args) {
        //VegetOutManager.getInstance().setPrevStream(System.out);
        ReadVeget rv = new ReadVeget();
        ReadSalat rs = new ReadSalat();
        VegetStorageReport vr = new VegetStorageReport();
        VegetStorageXMLReport vrxml = new VegetStorageXMLReport("vegetStorage.xml");
        try {
            rv.readVegetToProgram("txt");
            vr.allVeget();
            vr.freeSpace();
            vr.allSalatVeget(rs.readSalatToProgram(), true, true);
            vrxml.allVeget();
        } catch (VegetException e) {
            VegetOutManager.getInstance().println("Read and try to correct mistakes");
        }

    }

}
