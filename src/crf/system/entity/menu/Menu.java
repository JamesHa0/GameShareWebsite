package crf.system.entity.menu;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class Menu {
	private String text;
	private List<Item> items;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
