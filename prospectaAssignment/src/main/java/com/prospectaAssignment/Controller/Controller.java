package com.prospectaAssignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospectaAssignment.Service.Service;
import com.prospectaAssignment.model.Entry;
import com.prospectaAssignment.model.EntryDto;

@RestController

public class Controller {
	
	@Autowired
	private Service serv;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<EntryDto>>  getCategoryDetails(@PathVariable("category") String category){
		
		List<EntryDto> list = serv.getDetailsOfCategoty(category);
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveData(@RequestBody Entry data ){
		
		String ans = serv.saveEntryToData(data);
		
		return new ResponseEntity<>(ans, HttpStatus.OK);
	}
	
}
