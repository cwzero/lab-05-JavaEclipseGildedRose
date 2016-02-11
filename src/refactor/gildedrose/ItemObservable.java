package refactor.gildedrose;

import java.util.Observable;

import gildedrose.Item;

public class ItemObservable extends Observable {
	private Item item;
	private boolean legendary = false;
	private boolean reverse = false;
	private boolean special = false;
	private boolean conjured = false;

	public ItemObservable(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isLegendary() {
		return legendary;
	}

	public void setLegendary(boolean legendary) {
		this.legendary = legendary;
	}

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public boolean isConjured() {
		return conjured;
	}

	public void setConjured(boolean conjured) {
		this.conjured = conjured;
	}

	public void updateQuality() {
		if (!isLegendary()) {
			item.setSellIn(item.getSellIn() - 1);
			if (isReverse()) {
				updateItemQuality(item, 1);
			} else if (isSpecial()) {
				if (item.getSellIn() < 0) {
					item.setQuality(0);
				} else if (item.getSellIn() < 6) {
					updateItemQuality(item, 3);
				} else if (item.getSellIn() < 11) {
					updateItemQuality(item, 2);
				} else {
					updateItemQuality(item, 1);
				}
			} else if (isConjured()) {
				updateItemQuality(item, -2);
			} else {
				updateItemQuality(item, -1);
			}
			setChanged();
		}
	}

	public void updateItemQuality(Item item, int increment) {
		if (item.getSellIn() < 0) {
			increment *= 2;
		}
		int newQuality = item.getQuality() + increment;
		if (newQuality > 50) {
			item.setQuality(50);
		} else if (newQuality < 0) {
			item.setQuality(0);
		} else {
			item.setQuality(newQuality);
		}
	}
}
