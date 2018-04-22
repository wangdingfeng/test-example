package com.example.process;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author: wangdingfeng
 * @Description:
 * @Date: 2018/4/22 21:39
 */
public class TaskQueryRequest extends PaginateRequest {


    private String processInstanceId; // 流程实例
    private String candidateOrAssigned; //任务用户

    private Boolean includeProcessVariables = false; //是否返回全局附加数据标示

    private Boolean includeTaskLocalVariables = false; //是否返回局部附加数据标示

    private String processDefinitionKeyLike = "pre-nwm-%"; //只选投前的待办

    public String getProcessDefinitionKeyLike() {
        return processDefinitionKeyLike;
    }

    public void setProcessDefinitionKeyLike(String processDefinitionKeyLike) {
        this.processDefinitionKeyLike = processDefinitionKeyLike;
    }

    private Boolean active = true; //是否显示暂停任务  true：不显示暂停流程任务  false：只显示暂停流程任务

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIncludeTaskLocalVariables() {
        return includeTaskLocalVariables;
    }

    public void setIncludeTaskLocalVariables(Boolean includeTaskLocalVariables) {
        this.includeTaskLocalVariables = includeTaskLocalVariables;
    }

    private String[] candidateGroupIn;//获取任务角色组

    @JsonIgnore
    private String candidateGroupInToString;//获取任务角色组

    public String getCandidateGroupInToString() {
        return candidateGroupInToString;
    }

    public String[] getCandidateGroupIn() {
        return candidateGroupIn;
    }

    public void setCandidateGroupIn(String[] candidateGroupIn) {
        this.candidateGroupIn = candidateGroupIn;

        if(candidateGroupIn != null){
            StringBuffer roles = new StringBuffer();
            for(int i = 0 ; i < candidateGroupIn.length ; i++){

                String role = candidateGroupIn[i];
                roles.append(role);
                if(i != candidateGroupIn.length - 1){

                    roles.append(",");

                }

            }
            candidateGroupInToString = roles.toString();
        }

    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
    public Boolean getIncludeProcessVariables() {
        return includeProcessVariables;
    }

    public void setIncludeProcessVariables(Boolean includeProcessVariables) {
        this.includeProcessVariables = includeProcessVariables;
    }
    public String getCandidateOrAssigned() {
        return candidateOrAssigned;
    }

    public void setCandidateOrAssigned(String candidateOrAssigned) {
        this.candidateOrAssigned = candidateOrAssigned;
    }
}
