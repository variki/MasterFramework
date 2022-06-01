package com.api.tests.Builder;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Student {

    private int  id;
    private String fname;
    private String lname;
    private String email;

    public static class StudentBuild{
        private int  id;
        private String fname;
        private String lname;
        private String email;

        public StudentBuild setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuild setFname(String fname) {
            this.fname = fname;
            return this;
        }

        public StudentBuild setLname(String lname) {
            this.lname = lname;
            return this;
        }

        public StudentBuild setEmail(String email) {
            this.email = email;
            return this;
        }

        public static StudentBuilder builder(){
            return new StudentBuilder();
        }

        public Student build(){
            return new Student(this.id,this.fname,this.lname,this.email);
        }
    }
}
