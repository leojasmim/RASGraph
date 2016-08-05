/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ljasmim.rasgraph.util.test;

import br.com.ljasmim.rasgraph.util.Util;
import java.sql.Date;
import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LeonardoJasmim
 */
public class UtilTest {
    
    public UtilTest() {
    }

    @Test
    public void testParseLocalToDateSql(){
        String ts = "05/03/1984 00:00:00";
        Date d;
        d = Util.parseLocalToDateSql("");
        assertTrue(d == null);
        d = Util.parseLocalToDateSql(ts);
        assertTrue(d.toLocaleString().equals(ts));
        
    }
    
    @Test
    public void testParseLocalToTimestampSql(){
        String ts = "05/03/1984 14:58:30";
        Timestamp t;
        t = Util.parseLocalToTimestampSql("");
        assertTrue(t == null);
        t = Util.parseLocalToTimestampSql(ts);
        assertTrue(t.toLocaleString().equals(ts));
        System.out.println(t.toLocaleString());
    }
    
}
