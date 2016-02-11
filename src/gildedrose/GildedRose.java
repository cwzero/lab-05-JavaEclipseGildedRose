package gildedrose;

import java.util.ArrayList;
import java.util.List;

import refactor.gildedrose.ItemObservable;

public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQuality();
	}

	public static void updateQuality() {
		for (Item item : items) {
			ItemObservable observable = new ItemObservable(item);
			if (item.getName().equals("Aged Brie")) {
				observable.setReverse(true);
			} else if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
				observable.setLegendary(true);
			} else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
				observable.setSpecial(true);
			} else if (item.getName().toLowerCase().contains("conjured")) {
				observable.setConjured(true);
			}
			observable.updateQuality();
		}
	}

	/*
	 * minimal addition to ensure testability
	 */
	public static void setItems(List<Item> items) {
		GildedRose.items = items;
	}
}