package com.example.process;

public class RestVariable {
    public static final String GLOBAL = "global";
    public static final String LOCAL = "local";
    private String name;//参数名
    private Object value;//参数内容
    private String scope;//参数类型-global共有参数   local-私有参数

    public RestVariable(String infoName,String... infoValue){
        this.name = infoName;
        this.value = infoValue;
        this.scope = GLOBAL;
    }

    public RestVariable(String infoName,String infoValue){
        this.name = infoName;
        this.value = infoValue;
        this.scope = GLOBAL;
    }

    public RestVariable(String infoName,String scope, String infoValue){
        this.name = infoName;
        this.value = infoValue;
        this.scope = scope;
    }

    public RestVariable(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
