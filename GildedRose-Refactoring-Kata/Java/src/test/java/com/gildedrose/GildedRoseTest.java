package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void goldenTest() throws IOException {
        new GoldenLauncher().launch(false, 30);

        final String goldenSnaphot = Files.readString(Path.of(new File("golden-snapshot.txt").toURI()));
        final String currentSnaphot = Files.readString(Path.of(new File("current-snapshot.txt").toURI()));

        assertThat(goldenSnaphot).isEqualTo(currentSnaphot);
    }
}
