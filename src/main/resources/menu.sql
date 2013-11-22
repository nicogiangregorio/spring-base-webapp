CREATE TABLE geo.menu_items
(
   id_menu numeric NOT NULL, 
   name character varying(100) NOT NULL, 
   url character varying(2048) DEFAULT '#', 
   id_parent numeric NOT NULL DEFAULT 0, 
   menu_item_dsc character varying(256)
) 
WITH (
  OIDS = FALSE
)
;
ALTER TABLE geo.menu_items
  OWNER TO geo;
  
INSERT INTO geo.menu_items(
            id_menu, name, url,  id_parent, menu_item_dsc)
    VALUES (1, 'Home', '/', 0, 'Homepage');
INSERT INTO geo.menu_items(
            id_menu, name, url,  id_parent, menu_item_dsc)
    VALUES (2, 'Admin', '/admin', 0, 'Administration page');
INSERT INTO geo.menu_items(
            id_menu, name, url,  id_parent, menu_item_dsc)
    VALUES (3, 'About', '/about', 0, 'Info page');
INSERT INTO geo.menu_items(
            id_menu, name, url,  id_parent, menu_item_dsc)
    VALUES (4, 'Contact', '/contact', 2, 'Contact page');
Commit;
