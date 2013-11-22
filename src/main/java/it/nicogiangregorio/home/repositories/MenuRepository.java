package it.nicogiangregorio.home.repositories;

import it.nicogiangregorio.home.repositories.pojo.MenuItemPojo;

import java.math.BigDecimal;
import java.util.Map;

public interface MenuRepository {
	/**
	 * Retrieve from DB all the menu items without hierarchical relationship
	 * 
	 * @return a Map with id_menu as key and row as value
	 */
	public Map<BigDecimal, MenuItemPojo> getMenu();
}
