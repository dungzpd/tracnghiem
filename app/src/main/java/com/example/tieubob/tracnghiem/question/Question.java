package com.example.tieubob.tracnghiem.question;

public class Question {
    private int id;
    private String question;
    private String anser_a;
    private String anser_b;
    private String anser_c;
    private String anser_d;
    private String result;
    private String image;
    private String num_test;
    private String type;
    private String traloi = "";

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public Question(int id, String question, String anser_a, String anser_b, String anser_c, String anser_d, String result, String image, String num_test, String type, String traloi) {
        this.id = id;
        this.question = question;
        this.anser_a = anser_a;
        this.anser_b = anser_b;
        this.anser_c = anser_c;
        this.anser_d = anser_d;
        this.result = result;
        this.image = image;
        this.num_test = num_test;
        this.type = type;
        this.traloi = traloi;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnser_a() {
        return anser_a;
    }

    public void setAnser_a(String anser_a) {
        this.anser_a = anser_a;
    }

    public String getAnser_b() {
        return anser_b;
    }

    public void setAnser_b(String anser_b) {
        this.anser_b = anser_b;
    }

    public String getAnser_c() {
        return anser_c;
    }

    public void setAnser_c(String anser_c) {
        this.anser_c = anser_c;
    }

    public String getAnser_d() {
        return anser_d;
    }

    public void setAnser_d(String anser_d) {
        this.anser_d = anser_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNum_test() {
        return num_test;
    }

    public void setNum_test(String num_test) {
        this.num_test = num_test;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
