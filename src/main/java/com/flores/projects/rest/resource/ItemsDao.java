package com.flores.projects.rest.resource;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.flores.projects.rest.model.Item;

/**
 * static class used to interact with items * 
 * @author Jason
 *
 */
public class ItemsDao {

	protected static Map<String, Item> items;
	static {
		items = new LinkedHashMap<String, Item>() {
			private static final long serialVersionUID = 1L; {
				put("1AB2C3", new Item("Xbox Controller", 20.0));
				put("0074A", new Item("Samsung Galaxy S5", 12.2));
				put("9H21X", new Item("Half-empty can of Lipton's Brisk half&half", 149.99));
				put("100IL8E", new Item("Glass coaster", 2.7));
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	public static Item getItem(String id) {
		return items.get(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public static Collection<Item> getItems() {
		return items.values();
	}
}
