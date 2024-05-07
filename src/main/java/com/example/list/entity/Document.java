package com.example.list.entity;


import java.util.ArrayList; 
import java.util.List;
import com.example.list.enumeration.DocumentStatus;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="document")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="department")
	private String department;
	
	@Type(name = "list_array", value = Integer.class)
	@Column(columnDefinition = "bigint[]")
	private List<Integer> idlist = new ArrayList<Integer>();
	
	@Enumerated(EnumType.STRING)
	private DocumentStatus status;
		
}





