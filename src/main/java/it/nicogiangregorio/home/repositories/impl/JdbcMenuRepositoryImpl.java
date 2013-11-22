package it.nicogiangregorio.home.repositories.impl;

import it.nicogiangregorio.home.repositories.MenuQueries;
import it.nicogiangregorio.home.repositories.MenuRepository;
import it.nicogiangregorio.home.repositories.pojo.MenuItemPojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcMenuRepositoryImpl implements MenuRepository {
	Logger logger = LoggerFactory.getLogger(JdbcMenuRepositoryImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(readOnly = true)
	public Map<BigDecimal, MenuItemPojo> getMenu() {
		Map<BigDecimal, MenuItemPojo> itemsMap = new HashMap<BigDecimal, MenuItemPojo>();
		List<Map<String, Object>> results = new ArrayList<>();
		
		try {
			results = jdbcTemplate.queryForList(MenuQueries.SQL_GET_MENU);
			
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			logger.error("No menu items found");
		}
		
		
		for (Map<String, Object> row : results) {
			BigDecimal menuId = (BigDecimal) row.get("id_menu");
			String name = (String) row.get("name");
			String description = (String) row.get("menu_item_dsc");
			String url = (String) row.get("url");
			
			MenuItemPojo menuItem = new MenuItemPojo(menuId, name, description, url);
			itemsMap.put(menuId, menuItem);
		}
		return itemsMap;
	}

}
