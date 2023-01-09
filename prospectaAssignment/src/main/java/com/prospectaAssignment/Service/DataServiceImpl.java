package com.prospectaAssignment.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.prospectaAssignment.model.Data;
import com.prospectaAssignment.model.Entry;
import com.prospectaAssignment.model.EntryDto;
import com.prospectaAssignment.repository.DataRepository;

@org.springframework.stereotype.Service
public class DataServiceImpl implements Service {

	@Autowired
	private RestTemplate template;
	
	private final String url = "https://api.publicapis.org/entries";
	
	@Autowired
	private DataRepository dRepo;
	
	
	@Override
	public List<EntryDto> getDetailsOfCategoty( String category) {
		
		
		Data data = template.getForObject(url, Data.class);
		
		List<EntryDto> list = new ArrayList<>();
		
		for(Entry e : data.getEntries()) {
			
			String[] cat = e.getCategory().split(" ");
			
			if(category.equalsIgnoreCase(cat[0])) {
				list.add( new EntryDto(e.getApi(), e.getDescription()));
			}
		}
		
		
		return list;
	}

	@Override
	public String saveEntryToData( Entry entry ) {
		List<Data> data = dRepo.findAll();
				
		if(data.isEmpty()) {
			Data en = template.getForObject(url, Data.class);
			en.getEntries().add(entry);
			dRepo.save(en);
			return "Count of saved data is " + en.getEntries().size();
		}else {
		
			data.get(0).getEntries().add(entry);
			dRepo.save(data.get(0));
			return "Count of saved data is " + data.size();
		}
		
	}
	
}
