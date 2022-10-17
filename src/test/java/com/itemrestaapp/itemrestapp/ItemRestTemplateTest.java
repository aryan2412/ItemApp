package com.itemrestaapp.itemrestapp;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDAO;
import com.model.Item;

@SpringBootTest
class ItemRestTemplateTest {

	@Autowired
	ItemDAO dao;
	int port=8900;
	@Test
	void testGetAllItemSuccess() throws URISyntaxException {
		Item i=new Item("Coffee",40,10);
		dao.save(i);
		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + port + "/getallitem";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    System.out.println(result.getBody());
	    assertEquals(200, result.getStatusCodeValue());
	}

}
