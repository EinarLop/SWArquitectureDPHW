//Einar López Altamirano A01656259

package com.itesm.financial;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");
        List<Ride> result;

        // SOLID Principle 1: Single Responsibility Principle
        ResultGenerator resultGenerator = new ResultGenerator();
        resultGenerator.createBuilder(CSV_FILENAME);
        result = resultGenerator.buildResult();

        ArrayList<String> headers = new ArrayList<>();
        headers.add("TaxiID");
        headers.add("Pickup time");
        headers.add("Dropoff time");
        headers.add("Passenger count");
        headers.add("Trip Distance");
        headers.add("Total amount");

        // Design Pattern 2: Decorator
        // Object Oriented Principle 1: Program to interfaces, not implementations
        ReportInterface report = new Report(headers, "Taxi Report");

        WebReport webReportDecorator = new WebReport(report);
        String htmlReport = webReportDecorator.createContent(result);

        PrintReport printReportDecorator = new PrintReport(report);
        String txtReport = printReportDecorator.createContent(result);

        webReportDecorator.createFile(htmlReport);
        printReportDecorator.createFile(txtReport);

    }
}
