package zh.controller;

import com.zh.pojo.Dept;
import com.zh.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/13 17:39
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService = null;

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        System.out.println("list");
        return this.deptClientService.findAll();
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.findById(id);
    }
}
