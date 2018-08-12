package com.example.process;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.activiti.rest.service.api.engine.variable.RestVariable;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessInstanceResponse extends BaseResponse {
    private String id;
    private String url;
    private String businessKey;
    private boolean suspended;
    private boolean ended;
    private String processDefinitionId;
    private String processDefinitionUrl;
    private String activityId;
    private List<RestVariable> variables = new ArrayList<RestVariable>();
    private String tenantId;
    private boolean completed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessDefinitionUrl() {
        return processDefinitionUrl;
    }

    public void setProcessDefinitionUrl(String processDefinitionUrl) {
        this.processDefinitionUrl = processDefinitionUrl;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public List<RestVariable> getVariables() {
        return variables;
    }

    public void setVariables(List<RestVariable> variables) {
        this.variables = variables;
    }

    public void addVariable(RestVariable variable) {
        variables.add(variable);
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("message", getMessage())
                .append("exception", getException())
                .append("id", id)
                .append("url", url)
                .append("businessKey", businessKey)
                .append("suspended", suspended)
                .append("ended", ended)
                .append("processDefinitionId", processDefinitionId)
                .append("processDefinitionUrl", processDefinitionUrl)
                .append("activityId", activityId)
                .append("variables", variables)
                .append("tenantId", tenantId)
                .append("completed", completed)
                .toString();
    }
}
