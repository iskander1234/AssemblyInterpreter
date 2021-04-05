package com.company;

import java.util.HashMap;

public class MainMethods  extends  Var{
    public MainMethods() {
        this.variable.vars = new HashMap<>();
    }
    public void execute(String command) {
        command = command.trim();
        String operation = command.substring(0, command.indexOf(" "));
        String param = command.substring(command.indexOf(" ") + 1);
        switch (operation) {
            case "ADD":
                add(param);
                break;
            case "SUB":
                sub(param);
                break;
            case "DIV":
                div(param);
                break;
            case "MUL":
                mpu(param);
                break;
            case "INC":
                add(param + " 1");
                break;
            case "DEC":
                sub(param + " 1");
                break;
            case "MOV":
                this.move(param);
                break;
            case "XCHG":
                this.exchange(param);
                break;
            default:
                this.addVariable(command);
                break;
        }
    }
    private void addVariable(String command) {
        String[] commandParts = command.split(" ");
        String var = commandParts[0];
        if (this.validateVarName(var)) {
            String value = commandParts[1];
            this.setVar(var, value);
            lastValue = value;
        } else {
            System.out.println("Invalid variable name");
        }
    }
    private boolean validateVarName(String var) {
        if (var.indexOf('.') > 0 || var.matches("[0-9].") || var.matches("\\W")) return false;
        return true;
    }
    public void add(String params) {
        ids(params, 0, 1, '+');
    }
    public void sub(String params) {
        ids(params, 0, 1, '-');
    }
    public void mpu(String params) {
        ids(params, 0, 1, '*');
    }
    public void div(String params) {
        ids(params, 0, 1, '/');
    }
    public void move(String params) {
        me(params, 0, 1, ' ');
        this.lastValue = variable.sVariableValue;
    }
    public void exchange(String params) {
        me(params, 0, 1, 'e');
        this.setVar(variable.sVariable, variable.dVaribleValue);
    }
    public String getLastValue() {
        return this.lastValue;
    }
}
