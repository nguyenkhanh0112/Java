package model;

public class MiniCalculatorModel {
    private double frist_value;
    private double second_value;
    private double answer;
    public MiniCalculatorModel(){

    }

    public double getSecond_value() {
        return second_value;
    }

    public void setSecond_value(double second_value) {
        this.second_value = second_value;
    }

    public double getFrist_value() {
        return frist_value;
    }

    public void setFrist_value(double frist_value) {
        this.frist_value = frist_value;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }
    public void plus(){
        this.answer=this.frist_value+this.second_value;
    }
    public void minus(){
        this.answer=this.frist_value-this.second_value;
    }
    public void multiply(){
        this.answer= this.frist_value*this.second_value;
    }
    public void divide(){
        this.answer = this.frist_value/this.second_value;
    }
    public void pow(){
        this.answer=Math.pow(this.frist_value,this.second_value);
    }
    public void mod(){
        this.answer=this.frist_value%this.second_value;
    }
}
