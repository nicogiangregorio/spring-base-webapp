package it.nicogiangregorio.home.repositories.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MenuItemPojo {
	private BigDecimal menuId;
	private String name;
	private String description;
	private String url;
	private List<MenuItemPojo> children;
	
	public MenuItemPojo(BigDecimal menuId, String name, String description, String url) {
		children = new ArrayList<>();
		this.menuId = menuId;
		this.name = name;
		this.description = description;
		this.url = url;
	}
	public void addChild(MenuItemPojo menuItem){
		this.children.add(menuItem);
	}
	public BigDecimal getMenuId() {
		return menuId;
	}
	public void setMenuId(BigDecimal menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<MenuItemPojo> getChildren() {
		return children;
	}
	public void setChildren(List<MenuItemPojo> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "MenuItemPojo [menuId=" + menuId + ", name=" + name
				+ ", description=" + description + ", url=" + url
				+ ", children=" + children + "]";
	}
	
}
