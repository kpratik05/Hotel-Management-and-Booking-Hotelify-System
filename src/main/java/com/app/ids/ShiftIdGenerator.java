package com.app.ids;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ShiftIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String prefix = "SHFT";
		
		String query = "select count(shift_id) as Id from shift_table";
		
		try(	Connection conn = session.connection();
				Statement cst = conn.createStatement();
				) {
			
			ResultSet rst = cst.executeQuery(query);
			
			if(rst.next())
            {
                int id=rst.getInt(1)+101;
                String generatedId = prefix + id;
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Id generation failed !");
			e.printStackTrace();
		}
		return null;
	}
	
//	@Override
//    public Serializable generate(SessionImplementor session, Object object)
//            throws HibernateException {
//
//        String prefix = "DEP";
//        Connection connection = session.connection();
//
//        try {
//            Statement statement=connection.createStatement();
//
//            ResultSet rs=statement.executeQuery("select count(Department_Id) as Id from demo.Department");
//
//            if(rs.next())
//            {
//                int id=rs.getInt(1)+101;
//                String generatedId = prefix + new Integer(id).toString();
//                System.out.println("Generated Id: " + generatedId);
//                return generatedId;
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }

}
