//package intergrative.mit.codebusters.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//import intergrative.mit.codebusters.model.DatabaseSequence;
//
//import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//import static org.springframework.data.mongodb.core.query.Query.query;
//@Service
//public class SequenceGenerator {
//    @Autowired
//    private MongoOperations mongoOperations;
//
//    @Autowired
//    public SequenceGeneratorService(MongoOperations mongoOperations) {
//        this.mongoOperations = mongoOperations;
//    }
//
//    public  long generateSequence(String seqName) {
//
//        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
//                new Update().inc("seq",1), options().returnNew(true).upsert(true),
//                DatabaseSequence.class);
//        return !Objects.isNull(counter) ? counter.getSeq() : 1;
//}
