package com.example.list.service;


import java.util.List ;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.list.entity.Document;
import com.example.list.enumeration.DocumentStatus;
import com.example.list.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository repo;

	public Document createDoc(Document doc) {
		return repo.save(doc);
	}

	public Optional<Document> getById(Integer id) {
		return repo.findById(id);
	}
	
	public List<Document> getAll() {
		return repo.findAll();
	}
	
	public Document update(Document update) {
		return repo.save(update);
	}


	public List<Document> filter(int idlist, String status) {
		List<Document> list = repo.findByCriteria(idlist,status);
		return list;
	}

	public List<Document> filterByParam(Integer id, String searchKey, String name) {
		List<Document> doc;
		if(id!=null && searchKey!=null && name!=null) {
			return doc=repo.findParamByCriteria(id,searchKey,name);
		}
		else if(id!=null && searchKey!=null) {
			return doc=repo.findIdAndSearhKey(id,searchKey);
		}
		else if(id!=null && name!=null) {
			return doc=repo.findIdAndName(id,name);
			
		}
		else if(id==null && name!=null) {
			return doc=repo.findByName(id,name);
		}
		else {
			doc=repo.findAll();		
		}
		return doc;
	}






}
