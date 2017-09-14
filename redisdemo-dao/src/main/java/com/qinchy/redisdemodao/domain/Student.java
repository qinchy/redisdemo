package com.qinchy.redisdemodao.domain;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class Student implements Serializable {

    private Long studentId;
    private String studentName;

    public Student() {
    }

    public Student(Long studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;
        return studentName != null ? studentName.equals(student.studentName) : student.studentName == null;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }

/*
    public static void main(String[] args) {
        Student stu = new Student(999999999999999999L,"小明");
        String s = JSONObject.toJSONString(stu);
        System.out.println(s);

        Student t = JSONObject.parseObject("{\"studentId\":999999999999999999,\"studentName\":\"小明\"}",Student.class);
        System.out.println(t);
        System.out.println(t.getStudentId());
    }
*/
}
