package com.example.list.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.list.entity.Document;
import com.example.list.service.DocumentService;

@RestController
@RequestMapping("/api/docs")
public class DocumentController {
	@Autowired
	private DocumentService serv;
	
	@PostMapping("/post")
	public Document createDoc(@RequestBody Document doc) {
		return serv.createDoc(doc);
	}

	@GetMapping("getById/{id}")
	public Optional<Document> getbyId(@PathVariable Integer id){
		return serv.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<Document> getAll(){
		return serv.getAll();
	}
	
	 @PutMapping("/update")
	    public Document update(@RequestBody Document update) {
	    	return serv.update(update);
	}	

    @GetMapping("/filter")
    public List<Document> filter(@RequestParam(required = false) int idlist,
    		@RequestParam(value="status",required = false) String status) {
        return serv.filter(idlist, status);
    }
    
    @GetMapping("/filterByParam")
    public List<Document> filterByParam(@RequestParam(name="id",required = false)Integer id,
    		@RequestParam(name="searchKey",required = false)String searchKey,
    		@RequestParam(name="name",required = false)String name){
    	return serv.filterByParam(id,searchKey,name);
    }
   
    
}




//searchkey, id, name 



