package com.umc.api;

import com.umc.api.model.GetUserRes;
import com.umc.api.model.PostUserReq;
import java.util.List;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDao {

    private JdbcTemplate jdbctemplate;

    @Autowired
    public void serDataSource(DataSource dataSource) {

        this.jdbctemplate = new JdbcTemplate(dataSource);
    }

    public List<GetUserRes> userRes() {
        return this.jdbctemplate.query("Select * from test_schema.test_table",
                (rs, rowNum) -> new GetUserRes(
                        rs.getInt("userIdx"),
                        rs.getString("userName"),
                        rs.getString("Id"),
                        rs.getString("password"),
                        rs.getString("email")
                )
        );
    }

    public int addUser(PostUserReq postUserReq) {
        String createUserQuery = "insert into test_schema.test_table (userName, ID, password, email) VALUES (?,?,?,?)";
        Object[] createUserParams = new Object[]{
                postUserReq.getUserName(), postUserReq.getID(), postUserReq.getPassword(), postUserReq.getEmail()
        };
        this.jdbctemplate.update(createUserQuery, createUserParams);

        return this.jdbctemplate.queryForObject("select last_insert_id()", int.class);
    }

}
