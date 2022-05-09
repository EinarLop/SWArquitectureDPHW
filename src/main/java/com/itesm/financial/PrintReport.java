package com.itesm.financial;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PrintReport {
    // SOLID Principle 2: The Open Closed Principle
    private ReportInterface report;

    public PrintReport(ReportInterface report) {
        this.report = report;
    }

    public String createContent(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createHeaders(report.getTitle()));
        builder.append(createTableHeaders(report.getHeaders()));
        rides.forEach(ride -> {
            builder.append(addRide(ride));
        });

        return builder.toString();
    }

    public void createFile(String content) throws IOException {
        report.getFile(content, "financial-report.txt");
    }

    private String createHeaders(String title) {
        return title + "\n" + "\n";
    }

    private String createTableHeaders(ArrayList<String> headers) {
        String text = "";
        for (String header : headers) {
            text = text + header + "\t";
        }
        text = text + "\n\n";
        return text;
    }

    private String addRide(Ride ride) {
        return ride.getTaxiId() + "\t" +
                ride.getPickUpTime() + "\t" +
                ride.getDropOffTime() + "\t" +
                ride.getPassengerCount() + "\t" +
                ride.getTripDistance() + "\t" +
                formatAmount(ride.getTollsAmount()) + "\t\n";
    }

    private String formatAmount(double amount) {
        if (amount < 0) {
            return "(" + amount + ")";
        }
        return Double.toString(amount);
    }
}
