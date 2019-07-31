package sort;

import java.util.Random;

public class Student implements Comparable<Student>{
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    public static Student[] genRandomStu(int size){
        Student[] s = new Student[size];
        Random random = new Random();
        int i=0;
        while (i < size){
            s[i] = new Student("stu:" + (i+1), random.nextInt(100));
            ++i;
        }
        return s;
    }
}
