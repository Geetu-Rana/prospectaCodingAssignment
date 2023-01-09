package com.prospectaAssignment.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@lombok.Data
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entryID;
	
	private Integer count;
	
	@ElementCollection
	@Embedded
	@JoinTable(name = "entryData", joinColumns = @JoinColumn(name = "entryID") )
	private List<Entry> entries;
	
}
