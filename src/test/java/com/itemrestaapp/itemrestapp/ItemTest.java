package com.itemrestaapp.itemrestapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.ItemDAO;
import com.model.Item;
@SpringBootTest
class ItemTest {

	@Autowired
	ItemDAO dao;
	Item i;
	@BeforeEach
	void init()
	{
		i=new Item("Coffee",40.5f,10);
		dao.deleteAll();
	}
	@Test
	void InsertionTest()
	{
		Item actual=dao.save(i);
		assertEquals(actual.toString(), i.toString());
	}
	@Test
	void DeletionTest()
	{
		dao.save(i);
		dao.delete(i);
		int actual=0;
		int expected=dao.countByItemId(i.getItemId());
		assertEquals(actual, expected);
	}
	@Test
	void GetTest()
	{
		dao.save(i);
		List<Item> actual=new ArrayList<>();
		actual.add(i);
		List<Item> expected=dao.findAll();
		assertEquals(actual.toString(),expected.toString());
	}
	@Test
	void TestUpdate()
	{
		dao.save(i);
		i.setGetQuantity(100);
		Item actual=dao.save(i);
		assertEquals(actual.toString(), i.toString());
	}
	@Test
	void TestCountByName()
	{
		dao.save(i);
		Item i2=new Item("Coffee",30,303);
		dao.save(i2);
		int expected=2;
		int actual=dao.countByItemName(i.getItemName());
		assertEquals(actual, expected);
	}
}
