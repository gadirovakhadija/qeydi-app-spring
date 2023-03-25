package org.example.form;

public class TeachwayForm {
    private int id;

    private String teachway;

    public TeachwayForm() {
    }

    public TeachwayForm(int id, String teachway) {
        this.id = id;
        this.teachway = teachway;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeachway() {
        return teachway;
    }

    public void setTeachway(String teachway) {
        this.teachway = teachway;
    }
}
