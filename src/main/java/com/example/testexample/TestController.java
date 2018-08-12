package com.example.testexample;

import com.alibaba.fastjson.JSONObject;
import com.example.process.ProcessInstanceResponse;
import com.example.process.RestProLaumchRequest;
import com.example.process.RestVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangdingfeng
 * @version 1.0
 * @create 2018-04-19 18:35
 * @Description 描述
 **/
@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Object test(){
        System.out.println("234234");

//        HttpEntity<TaskQueryRequest> taskSubmitRequestEntity = new HttpEntity<>(new TaskQueryRequest());

//        ResponseEntity<TaskQueryResponse> responseEntity = restTemplate.exchange(
//                "http://39.107.110.75:8088//activiti-rest/service/repository/process-definitions",
////                HttpMethod.POST,
////                taskSubmitRequestEntity,
//                TaskQueryResponse.class
//        );
        //获取所有任务    `
        JSONObject json = restTemplate.getForEntity("http://39.107.110.75:8088//activiti-rest/service/repository/process-definitions", JSONObject.class).getBody();
        System.out.printf(json.toJSONString());
        return json;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/sponsorWorkFlow",method = RequestMethod.GET)
    public Object sponsorWorkFlow(){

        List<RestVariable> restVariableList =new ArrayList<>();

        RestVariable restVariable =new RestVariable("apply","fozzie");
        restVariableList.add(restVariable);
        RestVariable restVariable1 =new RestVariable("approve","wangdingfeng");
        restVariableList.add(restVariable1);

        RestProLaumchRequest laumchRequest = new RestProLaumchRequest();
        laumchRequest.setProcessDefinitionKey("leave");

        laumchRequest.setVariables(restVariableList);

        HttpEntity<RestProLaumchRequest> requestHttpEntity = new HttpEntity<RestProLaumchRequest>(laumchRequest);


        ResponseEntity<ProcessInstanceResponse> launchResponse = null;
        try {
            launchResponse = restTemplate.exchange("http://39.107.110.75:8088/activiti-rest/service/runtime/process-instances",HttpMethod.POST,requestHttpEntity,ProcessInstanceResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return launchResponse;
    }
}
