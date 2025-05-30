package com.pluralsight;

class ReceiptManager {
    public static void saveReceipt(Order order) {
        String fileName = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date()) + ".txt";
        try (java.io.PrintWriter out = new java.io.PrintWriter("receipts/" + fileName)) {
            out.println(order.getOrderDetails());
        } catch (java.io.IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
