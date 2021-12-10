/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import javax.swing.JPanel;
import javax.swing.border.Border;
import static org.testng.Assert.*;

/**
 *
 * @author OSIOKE
 */
public class BordersNGTest {
    
    public BordersNGTest() {
    }

//    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

//    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of showBorder method, of class Borders.
     */
    @org.testng.annotations.Test
    public void testShowBorder() {
        System.out.println("showBorder");
        Border b = null;
        JPanel expResult = null;
        JPanel result = Borders.showBorder(b);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Borders.
     */
    @org.testng.annotations.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Borders.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
