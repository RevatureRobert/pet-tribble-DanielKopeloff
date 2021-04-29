import DB.DAO.LabDAO;
import DB.DAO.TribbleDAO;
import DB.DAO.TribbleXLabDAO;
import DB.DB_Connection;
import Model.Lab;
import Model.Tribble;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {

    public static void main(String[] args) throws SQLException {
        Tribble t1 = new Tribble("T1", 35, "Red",43, 423423);

        Lab l1 = new Lab("A" ,"Real" ,"Place");

        TribbleDAO tribbleDAO = TribbleDAO.getInstance();

        LabDAO labDAO = LabDAO.getInstance();

        //System.out.println(labDAO.add(l1));

       // System.out.println(labDAO.readAll());

        //tribbleDAO.add(t1);
//        System.out.println("Did it break???");
//
//        System.out.println(tribbleDAO.readAll());

//        t1.setId(4);
//        System.out.println(tribbleDAO.delete(t1));

//        t1.setId(8);
//        t1.setAge(423);
//        t1.setName("One Meticalla");
//        System.out.println(tribbleDAO.update(t1));

//        l1.setAddress("Maybe");
//        l1.setZip("Not");
//       l1.setId(4);
        System.out.println(new TribbleXLabDAO().readAll());



    }
}
