package com.company;

import com.sun.org.omg.CORBA.OperationDescription;

public class Var {
    Variables variable = new Variables();
    public String lastValue = null;
    public String getVar(String var) {
        if (var.matches("^[0-9]*$")) {
            return var;
        } else {
            return this.variable.vars.get(var);
        }
    }
    public void setVar(String var, String value) {
        if (var.matches("^[0-9]*$")) {
            return;
        }

        if (this.variable.vars.get(var) != null) {
            this.variable.vars.replace(var, value);
        } else {
            this.variable.vars.put(var, value);
        }
    }
    public int[] getNums(String params) {
        String[] paramsParts = params.split(" ");
        String destination = paramsParts[0];
        String source = paramsParts[1];

        int destinationValue = Integer.parseInt(this.getVar(destination));
        int sValue = Integer.parseInt(this.getVar(source));
        return new int[]{destinationValue, sValue};
    }
    public void ids(String parametr, int i, int j, char asmd){
        variable.ints = this.getNums(parametr);
        variable.dValue = variable.ints[i];
        variable.sValue = variable.ints[j];
        switch (asmd){
            case '+':
                variable.result = Integer.toString(variable.dValue + variable.sValue);
                break;
            case '-':
                variable.result = Integer.toString(variable.dValue - variable.sValue);
                break;
            case '*':
                variable.result = Integer.toString(variable.dValue * variable.sValue);
                break;
            case '/':
                variable.result = Integer.toString(variable.dValue / variable.sValue);
                break;
            default: break;
        }
        variable.dest = parametr.substring(0, parametr.indexOf(" "));
        this.setVar(variable.dest,  variable.result);
        lastValue = variable.result;

    }

    public void me(String parametr, int i, int j, char c){
        variable.strings = parametr.split(" ");
        variable.dVarible = variable.strings[i];
        variable.sVariable = variable.strings[j];
        variable.dVaribleValue = this.getVar(variable.dVarible);
        variable.sVariableValue = this.getVar(variable.sVariable);
        this.setVar(variable.dVarible, variable.sVariableValue);
        if (c == 'e') {
            this.setVar(variable.sVariable, variable.dVaribleValue);
        } else if (c == ' ') {
            return;
        }
        this.lastValue = variable.sVariableValue;
    }
}
