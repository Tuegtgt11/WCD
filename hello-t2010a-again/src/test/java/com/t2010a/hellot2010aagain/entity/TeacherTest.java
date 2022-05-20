package com.t2010a.hellot2010aagain.entity;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

class Teacher {
    private String id;
    private String name;
    private String date;
    private int qty;

    public Teacher(String id, String name, String date, int qty) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
class TeacherTest {
    @Test
    public void countCakeByTeacher() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream is = classLoader.getResourceAsStream("teacher");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        HashMap<String, Teacher> mapTeacher = new HashMap<>();
        for (String line; (line = reader.readLine())!= null; ){
            System.out.println(line);
            String[] sqlitedLine = line.split(" ");
            if (sqlitedLine.length == 4){
                String id = sqlitedLine[0];
                String name = sqlitedLine[1];
                String date = sqlitedLine[2];
                int qty = Integer.parseInt(sqlitedLine[3]);
                Teacher teacher = new Teacher(id,name,date,qty);
                //nếu như tồn tại giáo viên cùng với key, thì lấy giá trị cũ ra
                if (mapTeacher.containsKey(teacher.getId())){
                    Teacher oldTeacher = mapTeacher.get(teacher.getId());
                    //update số lượng bánh mới
                    oldTeacher.setQty(oldTeacher.getQty() + teacher.getQty());
                    //đưa lại vào map (bản chất k cần)
                    mapTeacher.put(oldTeacher.getId(),oldTeacher);
                }else {
                    mapTeacher.put(teacher.getId(),teacher);
                }
            }
        }
        ArrayList<Teacher> listTeacher = new ArrayList<>(mapTeacher.values());
        for (Teacher teacher :
                listTeacher){
            System.out.println(teacher.toString());
        }
    }

}
