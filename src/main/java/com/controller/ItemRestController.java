package com.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ItemDAO;
import com.model.Item;

@RestController
public class ItemRestController {

	@Autowired
	ItemDAO dao;
	@Autowired
	SessionFactory sessionFactory;
	
	@GetMapping("/homeinfo")
	public String getHomeInfo()
	{
		return "Home for ItemRestController";
	}
	@PostMapping("/additem")
	public ResponseEntity<String> addItem(@RequestBody Item i)
	{
		dao.save(i);
		return new ResponseEntity<String>("Item Added",HttpStatus.OK);
	}
	@GetMapping("/getallitem")
	public List<Item> getAllItem()
	{
		return dao.findAll();
	}
	@PatchMapping("/updateitem")
	public ResponseEntity<String> updateItem(@RequestBody Item i)
	{
		dao.save(i);
		return new ResponseEntity<String>("Item Updated",HttpStatus.OK);
	}
	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id") int id )
	{
		dao.deleteById(id);
		return new ResponseEntity<String>("Item deleted",HttpStatus.OK);
	}
	@GetMapping("/findbyid/{id}")
	public Optional<Item> getbyId(@PathVariable("id") int id)
	{
		return dao.findById(id);
	}
	@GetMapping("/findbyname/{itemname}")
	public List<Item> findByItemName(@PathVariable("itemname") String itemName)
	{
		return dao.findByItemName(itemName);
	}
	@GetMapping("/countbyid/{id}")
	public int countById(@PathVariable("id") int id)
	{
		return dao.countByItemId(id);
	}
	@GetMapping("/findbyprice/{price}")
	public List<Item> findByPrice(@PathVariable("price") float price)
	{
		Session session=sessionFactory.openSession();
		Query jpaquery=session.createNamedQuery("findByPrice");
		jpaquery.setParameter("price", price);
		List<Item> list=jpaquery.list();
		return list;
		
	}
	@GetMapping("/countbyname/{name}")
	public int countByName(@PathVariable("name") String itemName)
	{
		return dao.countByItemName(itemName);
	}
}
