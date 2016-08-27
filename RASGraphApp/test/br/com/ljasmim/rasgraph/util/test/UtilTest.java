/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ljasmim.rasgraph.util.test;

import br.com.ljasmim.rasgraph.util.Util;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
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
    public void testParseLocalToDateSql() {
        String ts = "05/03/1984 00:00:00";
        Date d;
        d = Util.parseLocalToDateSql("");
        assertTrue(d == null);
        d = Util.parseLocalToDateSql(ts);
        assertTrue(d.toLocaleString().equals(ts));

    }

    @Test
    public void testParseLocalToTimestampSql() {
        System.out.println(Util.getNowSqlDateString());
        String ts = "05/03/1984 14:58:30";
        Timestamp t;
        t = Util.parseLocalToTimestampSql("");
        assertTrue(t == null);
        t = Util.parseLocalToTimestampSql(ts);
        assertTrue(t.toLocaleString().equals(ts));
        System.out.println(t.toLocaleString());
        System.out.println(Date.from(Instant.now()).toLocaleString());
        System.out.println(Util.getNowSqlDateString());
    }

    @Test
    public void testGetFilePath() {
        System.out.println(Util.getAbsolutePath("csv/ibge_municipios_2015.csv"));
    }

    @Test
    public void testRemoveExcessSpaces() {
        String a = "Leonardo       ";
        assertTrue(a.length() == 15);
        a = Util.removeExcessSpaces(a);
        assertTrue(a.length() == 8);
        assertTrue(a.equals("Leonardo"));

        a = "     ";
        assertTrue(a.length() == 5);
        a = Util.removeExcessSpaces(a);
        assertTrue(a.length() == 0);
        assertTrue(a.equals(""));

        a = null;
        a = Util.removeExcessSpaces(a);
        assertTrue(a.length() == 0);
        assertTrue(a.equals(""));
        
        a = "ABC DEF  ";
        assertTrue(a.length() == 9);
        a = Util.removeExcessSpaces(a);
        assertTrue(a.length() == 7);
        assertTrue(a.equals("ABC DEF"));
    }
    
}
