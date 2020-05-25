package com.bbz.jdbc.repository;

import com.bbz.jdbc.model.Student;
import com.bbz.jdbc.util.IRowMapper;
import com.bbz.jdbc.util.JdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 */
public class StudentRepository {


    public void save(Student student) {
        String sql = "insert into t_student(name,age) values (?,?)";
        Object[] params = {student.getName(), student.getName()};
        JdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE  t_student from where id=?";
        Object[] params = {id};
        JdbcTemplate.update(sql, params);

    }

    public void update(Student student) {
        String sql = "update t_student set name=?,age=? where id=?";
        Object[] params = {student.getName(), student.getName()};
        JdbcTemplate.update(sql, params);
    }

    public Student get(Long id) {
        String sql = "SELECT * FROM t_student WHERE id=?";
        Object[] params = {id};
        List<Student> list = JdbcTemplate.query(sql, new StudentRowMapper(), params);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Student> list() {
        String sql = "”SELECT * FROM t_student ";
        List<Student> list = JdbcTemplate.query(sql, new StudentRowMapper());
        return list;
    }

    public Long getTotal() {
        String sql = "SELECT COUNT( *) total FROM t_student";
        Long total = JdbcTemplate.query(sql, new IRowMapper<Long>() {
            @Override
            public Long mapping(ResultSet rs) throws Exception {
                return rs.getLong("total");
            }
        });
        return total;
    }

    class StudentRowMapper implements IRowMapper<List<Student>> {
        @Override
        public List<Student> mapping(ResultSet rs) throws Exception {
            List<Student> list = new ArrayList<>();
            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                int id = rs.getInt("id");
                Student stu = new Student(id, name, age);
                list.add(stu);
            }
            return list;
        }
    }
}

