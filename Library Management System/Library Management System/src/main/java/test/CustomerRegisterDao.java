package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerRegisterDao {

    public int addCustomer(CustomerBean cb) {
        Connection con = DBCon.getConnection();
        try {
            // Insert customer data into the database
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO customers (CUSTOMERNAME, DOB, GENDER, ADDRESS, PHONE, EMAIL) VALUES (?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, cb.getCustomerName());
            ps.setString(2, cb.getDob());
            ps.setString(3, cb.getGender());
            ps.setString(4, cb.getAddress());
            ps.setString(5, cb.getPhone());
            ps.setString(6, cb.getEmail());

            int k = ps.executeUpdate();

            if (k > 0) { // Check if insertion is successful
                // Retrieve the auto-generated customer ID
                PreparedStatement ps2 = con.prepareStatement(
                    "SELECT CUSTOMERID FROM customers WHERE PHONE = ?"
                );
                ps2.setString(1, cb.getPhone());
                ResultSet rs = ps2.executeQuery();

                if (rs.next()) {
                    int customerId = rs.getInt("CUSTOMERID");
                    cb.setCustomerId(customerId); // Set the customer ID in the object
                }

                rs.close();
                ps2.close();
            }

            ps.close();
            return k;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

/*

CREATE TABLE CUSTOMERS(
	CUSTOMERID NUMBER(7) PRIMARY KEY,
	CUSTOMERNAME VARCHAR2(20),
	DOB VARCHAR2(20),
	GENDER VARCHAR2(20),
	ADDRESS VARCHAR2(20),
	PHONE VARCHAR2(20),
	EMAIL VARCHAR2(20)	
);


CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER customer_id_trigger
BEFORE INSERT ON customers
FOR EACH ROW
BEGIN
    SELECT customer_seq.NEXTVAL INTO :NEW.CUSTOMERID FROM dual;
END;
/

*/