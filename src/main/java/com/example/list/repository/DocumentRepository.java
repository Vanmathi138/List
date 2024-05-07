package com.example.list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.list.entity.Document;
import com.example.list.enumeration.DocumentStatus;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{

	@Query(value="SELECT d.* FROM document d "
			+ "WHERE (:idlistparam is null or :idlistparam =ANY(d.idlist))"
			+ "OR (:status is null or d.status =:status)", nativeQuery = true)
	List<Document> findByCriteria(@Param("idlistparam") int idlist, @Param("status") String status);

	@Query(value="SELECT * FROM document d "
	        + "WHERE (:idparam is null or :idparam=ANY(d.id)) "
	        + "AND (:searchKey is null or d.department like %:searchKey% OR d.status like %:searchKey%) "
	        + "AND (:nameparam is null or d.name = :nameparam)", nativeQuery = true)
	List<Document> findParamByCriteria(@Param("idparam") Integer id, @Param("searchKey") String searchKey, @Param("nameparam") String name);

	@Query(value = "SELECT * FROM document WHERE id = :id "
			+ "AND (:searchKey is null or d.status like %?1% OR d.name like %?1%)", nativeQuery = true)
	List<Document> findIdAndSearhKey(Integer id, String searchKey);

    @Query(value = "SELECT * FROM document WHERE id = :id "
    		+ "OR name = :name", nativeQuery = true)
	List<Document> findIdAndName(Integer id, String name);

    @Query(value = "SELECT d FROM Document d "
    		+ "WHERE :id is null AND :name IS NOT NULL AND d.name = :name")
    List<Document> findByName(Integer id,String name);
    
  
   

}



/*@Query(value="select * from customer s where s.name like %?1%"
+" Or s.place like %?1%"
+" Or s.id  like %?1%",nativeQuery=true)
List<Customer> findByNameContaining(String searchKey);*/