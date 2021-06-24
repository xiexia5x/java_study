package com.heima.antivejdbc;

import java.sql.*;

/**
 * @author laofang
 * @description
 * @date 2021-06-10
 */
public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
         Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        String url="jdbc:mysql://192.168.36.128:3306/day06";
        String user="root";
        String pwd="1234";
        Connection conn = DriverManager.getConnection(url, user, pwd);
        //2.获取预编译对象
        String model="select * from account where id=?";
        PreparedStatement pstm = conn.prepareStatement(model);
        //3.设置参数
        pstm.setInt(1,2);
        //4.执行
        ResultSet rs = pstm.executeQuery();
        //5.解析结果集
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            float money = rs.getFloat("money");
            System.out.println(id+"---"+name+"---"+money);
        }
        //释放资源，关闭连接
        rs.close();
        pstm.close();
        conn.close();
    }
}
