package com.demo.Mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface LabRecordRepository extends MongoRepository<LabRecord, BigInteger> {
    @Query("{'patientObj._id' : ?0}")
    List<LabRecord> findByPatient(BigInteger pid);
}
