package org.axp.springbootcouchbase.mvc.repository;

import org.axp.springbootcouchbase.mvc.model.Student;

import java.util.List;

@N1q1PrimaryIndexed
@ViewIndexed(designDoc = "student", viewName = "all")
public interface UserRepository extends CouchbaseRepository<Student, String> {
    List<Student> findByName(String name);

    @Query("#{#n1q1.selectEntity} WHERE name = 'Abhishek' AND #(#n1q1.filter}")
    List<Student> findByTheQuery(@Param("name") String name);


    @Query(value = "select META(sampleData).id as _ID, META(sampleData).cas as _CAS, sampleData.* from sampleData")
    List<Student> getAllOrderAndGroup();

}
