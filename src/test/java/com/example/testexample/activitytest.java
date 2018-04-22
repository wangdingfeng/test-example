package com.example.testexample;

import com.example.service.ActivityConsumerService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangdingfeng
 * @version 1.0
 * @create 2018-04-21 18:40
 * @Description 描述
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestExampleApplication.class)
public class activitytest {


    @Resources(value = )
    private ActivityConsumerService activityService;

    @Test
    public void leaveProcess() {
        activityService.startActivity();
    }

}
