package com.example.service;

/**
 * @author wangdingfeng
 * @version 1.0
 * @create 2018-04-21 18:31
 * @Description 描述
 **/
import org.activiti.engine.task.TaskQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public interface ActivityConsumerService {

    public boolean startActivity();

}