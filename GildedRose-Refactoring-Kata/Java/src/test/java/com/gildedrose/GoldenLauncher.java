package com.gildedrose;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GoldenLauncher {


    public void launch(boolean golden, int days) throws IOException {
        try (final PrintWriter printWriter = printWriter(golden ? "golden-snapshot.txt" : "current-snapshot.txt")) {
            printWriter.println("OMGHAI!");
            final Item[] items = new ItemFixtures().buildItems();

            GildedRose app = new GildedRose(items);

            for (int i = 0; i < days; i++) {
                printWriter.println("-------- day " + i + " --------");
                printWriter.println("name, sellIn, quality");
                for (Item item : items) {
                    printWriter.println(item);
                }
                printWriter.println();
                app.updateQuality();
            }
        }
    }

    private PrintWriter printWriter(String fileName) throws IOException {
        return new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    }
}
