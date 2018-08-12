package com.example.process;

import java.util.ArrayList;
import java.util.List;

/**
 * 流程请求参数
 */
public class RestProLaumchRequest {
    private String processDefinitionKey;//流程KEY
    private List<RestVariable> variables = new ArrayList<RestVariable>();//业务数据，当前只需要决议名称，类型，编号
    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }
    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }
    public List<RestVariable> getVariables() {
        return variables;
    }
    public void setVariables(List<RestVariable> variables) {
        this.variables = variables;
    }
    public void addVariables(List<RestVariable> variables) {

        if(variables == null){

            variables = new ArrayList<RestVariable>();

        }

        this.variables.addAll(variables);
    }
    public void addVariable(RestVariable variable) {
        if(variables == null){

            variables = new ArrayList<RestVariable>();

        }
        this.variables.add(variable);
    }

    public RestProLaumchRequest addVariable(String code,String value) {
        RestVariable rv = new RestVariable(code,value);
        this.variables.add(rv);

        return this;
    }

}
