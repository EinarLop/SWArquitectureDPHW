package com.itesm.financial;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class WebReport {

    // SOLID Principle 2: The Open Closed Principle
    private ReportInterface report;

    public WebReport(ReportInterface report) {
        this.report = report;
    }

    public String createContent(List<Ride> rides) {
        StringBuilder builder = new StringBuilder();
        builder.append(createHeaders(report.getTitle()));
        builder.append(createTableHeaders(report.getHeaders()));
        rides.forEach(ride -> {
            builder.append(addRide(ride));
        });
        builder.append(closeTableHeaders());
        return builder.toString();
    }

    public void createFile(String content) throws IOException {
        report.getFile(content, "financial-report.html");
    }

    private String createHeaders(String title) {
        return "<h1>" + title + "</h1>";
    }

    private String createTableHeaders(ArrayList<String> headers) {
        String text = "<table> <tr>";
        for (String header : headers) {
            text = text + "<th>" + header + "</th>";
        }
        text = text + "</tr>";
        return text;
    }

    private String closeTableHeaders() {
        return "</table>";
    }

    private String addRide(Ride ride) {
        return "<tr>" +
                "<td>" + ride.getTaxiId() + "</td>" +
                "<td>" + ride.getPickUpTime() + "</td>" +
                "<td>" + ride.getDropOffTime() + "</td>" +
                "<td>" + ride.getPassengerCount() + "</td>" +
                "<td>" + ride.getTripDistance() + "</td>" +
                "<td>" + formatAmount(ride.getTollsAmount()) + "</td>" +
                "</tr>";
    }

    private String formatAmount(double amount) {
        if (amount < 0) {
            return "<span style='color:red'>" + amount + "</span>";
        }
        return Double.toString(amount);
    }
}
