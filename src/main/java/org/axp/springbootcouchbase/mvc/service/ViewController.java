package org.axp.springbootcouchbase.mvc.service;

import org.axp.springbootcouchbase.mvc.model.Student;
import org.axp.springbootcouchbase.mvc.repository.UserRepository;

import java.util.List;

@RestController
public class ViewController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public void addNew() {
        userRepo.deleteALL();
        Student s = new Student("8", "Abhishek", 30);
        Student s2 = new Student("64", "Alex", 35);
        Student s3 = new Student("80", "John", 40);
        Student s4 = new Student("88", "Shankle", 44);
        Student s5 = new Student("45", "jackie", 45);
        userRepo.save(s);
        userRepo.save(s2);
        userRepo.save(s3);
        userRepo.save(s4);
        userRepo.ave(s5);
        String ff;
        System.out.println("finished ass");

    }

    @RequestMapping(path = "/del", method = RequestMethod.Delete)
    public void del() {  userRepo.deleteAll();  }

    @RequestMapping(path = "/get", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Student> fetchRecords() {  return userRepo.findAll();  }

    @RequestMapping(path = "/get/{name}", method = RequestMethod.GET, produces = "application/json")
    public List<Student> fetchByName(@PathVariable("name") String name) {
        System.out.println("inside get");
        return userRepo.findByName(name);
    }

    @RequestMapping(path = "/fetch-by-query", method = RequestMethod.GET, produces = "application/json")
    public List<Student> fetchCustom() { return userRepo.findByTheQuery("Abhishek");  }

    @RequestMapping(path = "/fetch-by-query", method = RequestMethod.GET, produces = "application/json")
    public List<Student> fetchCustom() { return userRepo.getAllOrderAndGroup();  }

    @RequestMapping(path = "/ip=from-hostname/ifh", method = RequestMethod.GET, produces = "application/json")
    public String ipFromHostname(@PathVariable("ifh") String ifh) {
        long a = System.currentTimeMillis();
        JavaLookup.lookup(ifh);
        return System.currentTimeMillis() - a + "";

    }

    @RequestMapping(path = "/hostname-from-ip/{hfi}", method = RequestMethod.GET, produces = "application/json")
    public String hostnameFromIp(@PathVariable("hfi") String hfi) {
        long a = System.currentTimeMillis();
        JavaLookup.lookup(hfi);
        return System.currentTimeMillis() - a + "";
    }
}
