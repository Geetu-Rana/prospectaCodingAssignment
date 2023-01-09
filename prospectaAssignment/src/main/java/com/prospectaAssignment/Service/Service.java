package com.prospectaAssignment.Service;

import java.util.List;


import com.prospectaAssignment.model.Entry;
import com.prospectaAssignment.model.EntryDto;

public interface Service {
	
	public List<EntryDto> getDetailsOfCategoty(String category );
	
	public String saveEntryToData(Entry data );
	
}
