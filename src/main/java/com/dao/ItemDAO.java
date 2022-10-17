package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {

	public List<Item> findByItemName(String itemName);
	public int countByItemId(int id);
	public int countByItemName(String itemName);
	   
}
