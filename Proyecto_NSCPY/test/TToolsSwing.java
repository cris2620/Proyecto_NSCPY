/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexion.ToolsSwing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian
 */
public class TToolsSwing {
    
    public TToolsSwing() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TNumber(){
        assertTrue(ToolsSwing.isNumber("0123456789"));
        
        assertFalse(ToolsSwing.isNumber("012345678a"));
        assertFalse(ToolsSwing.isNumber("a123456789"));
        assertFalse(ToolsSwing.isNumber("01234a6789"));
        
        assertFalse(ToolsSwing.isNumber(" "));
        assertFalse(ToolsSwing.isNumber(""));
        assertFalse(ToolsSwing.isNumber("123!"));
        assertFalse(ToolsSwing.isNumber("123#"));
        assertFalse(ToolsSwing.isNumber("123 456"));
        assertFalse(ToolsSwing.isNumber("123.34")); // no acepta decimal
        assertFalse(ToolsSwing.isNumber("123,43")); // no acepta decimal
        
        assertFalse(ToolsSwing.isNumber("!"));
        assertFalse(ToolsSwing.isNumber("\"")); //simbolo "
        assertFalse(ToolsSwing.isNumber("#"));
        assertFalse(ToolsSwing.isNumber("$"));
        assertFalse(ToolsSwing.isNumber("%"));
        assertFalse(ToolsSwing.isNumber("&"));
        assertFalse(ToolsSwing.isNumber("/"));
        assertFalse(ToolsSwing.isNumber("("));
        assertFalse(ToolsSwing.isNumber(")"));
        assertFalse(ToolsSwing.isNumber("="));
        assertFalse(ToolsSwing.isNumber("?"));
        assertFalse(ToolsSwing.isNumber("¡"));
        assertFalse(ToolsSwing.isNumber("'"));
        assertFalse(ToolsSwing.isNumber("¿"));
        assertFalse(ToolsSwing.isNumber("\\")); // simbolo \
        assertFalse(ToolsSwing.isNumber("|"));
        assertFalse(ToolsSwing.isNumber("¬"));
        assertFalse(ToolsSwing.isNumber("°"));
        assertFalse(ToolsSwing.isNumber("@"));
        assertFalse(ToolsSwing.isNumber("´"));
        assertFalse(ToolsSwing.isNumber("¨"));
        assertFalse(ToolsSwing.isNumber("+"));
        assertFalse(ToolsSwing.isNumber("*"));
        assertFalse(ToolsSwing.isNumber("~"));
        assertFalse(ToolsSwing.isNumber("{"));
        assertFalse(ToolsSwing.isNumber("^"));
        assertFalse(ToolsSwing.isNumber("["));
        assertFalse(ToolsSwing.isNumber("}"));
        assertFalse(ToolsSwing.isNumber("`"));
        assertFalse(ToolsSwing.isNumber("]"));
        assertFalse(ToolsSwing.isNumber(","));
        assertFalse(ToolsSwing.isNumber(";"));
        assertFalse(ToolsSwing.isNumber("."));
        assertFalse(ToolsSwing.isNumber(":"));
        assertFalse(ToolsSwing.isNumber("-"));
        assertFalse(ToolsSwing.isNumber("_"));
        
        assertFalse(ToolsSwing.isNumber("a"));
        assertFalse(ToolsSwing.isNumber("b"));
        assertFalse(ToolsSwing.isNumber("c"));
        assertFalse(ToolsSwing.isNumber("d"));
        assertFalse(ToolsSwing.isNumber("e"));
        assertFalse(ToolsSwing.isNumber("f"));
        assertFalse(ToolsSwing.isNumber("g"));
        assertFalse(ToolsSwing.isNumber("h"));
        assertFalse(ToolsSwing.isNumber("i"));
        assertFalse(ToolsSwing.isNumber("j"));
        assertFalse(ToolsSwing.isNumber("k"));
        assertFalse(ToolsSwing.isNumber("l"));
        assertFalse(ToolsSwing.isNumber("m"));
        assertFalse(ToolsSwing.isNumber("n"));
        assertFalse(ToolsSwing.isNumber("o"));
        assertFalse(ToolsSwing.isNumber("p"));
        assertFalse(ToolsSwing.isNumber("q"));
        assertFalse(ToolsSwing.isNumber("r"));
        assertFalse(ToolsSwing.isNumber("s"));
        assertFalse(ToolsSwing.isNumber("t"));
        assertFalse(ToolsSwing.isNumber("u"));
        assertFalse(ToolsSwing.isNumber("v"));
        assertFalse(ToolsSwing.isNumber("w"));
        assertFalse(ToolsSwing.isNumber("x"));
        assertFalse(ToolsSwing.isNumber("y"));
        assertFalse(ToolsSwing.isNumber("z"));
        assertFalse(ToolsSwing.isNumber("ñ"));
        
        assertFalse(ToolsSwing.isNumber("A"));
        assertFalse(ToolsSwing.isNumber("B"));
        assertFalse(ToolsSwing.isNumber("C"));
        assertFalse(ToolsSwing.isNumber("D"));
        assertFalse(ToolsSwing.isNumber("E"));
        assertFalse(ToolsSwing.isNumber("F"));
        assertFalse(ToolsSwing.isNumber("G"));
        assertFalse(ToolsSwing.isNumber("H"));
        assertFalse(ToolsSwing.isNumber("I"));
        assertFalse(ToolsSwing.isNumber("J"));
        assertFalse(ToolsSwing.isNumber("K"));
        assertFalse(ToolsSwing.isNumber("L"));
        assertFalse(ToolsSwing.isNumber("M"));
        assertFalse(ToolsSwing.isNumber("N"));
        assertFalse(ToolsSwing.isNumber("O"));
        assertFalse(ToolsSwing.isNumber("P"));
        assertFalse(ToolsSwing.isNumber("Q"));
        assertFalse(ToolsSwing.isNumber("R"));
        assertFalse(ToolsSwing.isNumber("S"));
        assertFalse(ToolsSwing.isNumber("T"));
        assertFalse(ToolsSwing.isNumber("U"));
        assertFalse(ToolsSwing.isNumber("V"));
        assertFalse(ToolsSwing.isNumber("W"));
        assertFalse(ToolsSwing.isNumber("X"));
        assertFalse(ToolsSwing.isNumber("Y"));
        assertFalse(ToolsSwing.isNumber("Z"));
        assertFalse(ToolsSwing.isNumber("Ñ"));
    }
    
    @Test
    public void TLetter(){
        assertTrue(ToolsSwing.isLetter("abcdefghijklmnopqrstuvwxyzñ"));
        assertTrue(ToolsSwing.isLetter("ABCDEFGHIJKLMNOPQRSTUVWXYZÑ"));
        assertTrue(ToolsSwing.isLetter(" "));
        assertTrue(ToolsSwing.isLetter(""));
        assertTrue(ToolsSwing.isLetter("texto con espacio"));
        
        assertFalse(ToolsSwing.isLetter("ABC!"));
        assertFalse(ToolsSwing.isLetter("abc#"));
        assertFalse(ToolsSwing.isLetter("abc123"));
        assertFalse(ToolsSwing.isLetter("abc."));
        assertFalse(ToolsSwing.isLetter("texto, tiene coma"));
        
        assertFalse(ToolsSwing.isLetter("!"));
        assertFalse(ToolsSwing.isLetter("\"")); //simbolo "
        assertFalse(ToolsSwing.isLetter("#"));
        assertFalse(ToolsSwing.isLetter("$"));
        assertFalse(ToolsSwing.isLetter("%"));
        assertFalse(ToolsSwing.isLetter("&"));
        assertFalse(ToolsSwing.isLetter("/"));
        assertFalse(ToolsSwing.isLetter("("));
        assertFalse(ToolsSwing.isLetter(")"));
        assertFalse(ToolsSwing.isLetter("="));
        assertFalse(ToolsSwing.isLetter("?"));
        assertFalse(ToolsSwing.isLetter("¡"));
        assertFalse(ToolsSwing.isLetter("'"));
        assertFalse(ToolsSwing.isLetter("¿"));
        assertFalse(ToolsSwing.isLetter("\\")); // simbolo \
        assertFalse(ToolsSwing.isLetter("|"));
        assertFalse(ToolsSwing.isLetter("¬"));
        assertFalse(ToolsSwing.isLetter("°"));
        assertFalse(ToolsSwing.isLetter("@"));
        assertFalse(ToolsSwing.isLetter("´"));
        assertFalse(ToolsSwing.isLetter("¨"));
        assertFalse(ToolsSwing.isLetter("+"));
        assertFalse(ToolsSwing.isLetter("*"));
        assertFalse(ToolsSwing.isLetter("~"));
        assertFalse(ToolsSwing.isLetter("{"));
        assertFalse(ToolsSwing.isLetter("^"));
        assertFalse(ToolsSwing.isLetter("["));
        assertFalse(ToolsSwing.isLetter("}"));
        assertFalse(ToolsSwing.isLetter("`"));
        assertFalse(ToolsSwing.isLetter("]"));
        assertFalse(ToolsSwing.isLetter(","));
        assertFalse(ToolsSwing.isLetter(";"));
        assertFalse(ToolsSwing.isLetter("."));
        assertFalse(ToolsSwing.isLetter(":"));
        assertFalse(ToolsSwing.isLetter("-"));
        assertFalse(ToolsSwing.isLetter("_"));
        
        assertFalse(ToolsSwing.isLetter("0"));
        assertFalse(ToolsSwing.isLetter("1"));
        assertFalse(ToolsSwing.isLetter("2"));
        assertFalse(ToolsSwing.isLetter("3"));
        assertFalse(ToolsSwing.isLetter("4"));
        assertFalse(ToolsSwing.isLetter("5"));
        assertFalse(ToolsSwing.isLetter("6"));
        assertFalse(ToolsSwing.isLetter("7"));
        assertFalse(ToolsSwing.isLetter("8"));
        assertFalse(ToolsSwing.isLetter("9"));
    }
    
    @Test
    public void TDecimalNumber(){
        assertTrue(ToolsSwing.isDecimalNumber("0123456789"));
        assertTrue(ToolsSwing.isDecimalNumber("0123456789.012345789"));
        assertTrue(ToolsSwing.isDecimalNumber("0.1"));
        assertTrue(ToolsSwing.isDecimalNumber("1.0"));
        
        assertFalse(ToolsSwing.isDecimalNumber("012345678a"));
        assertFalse(ToolsSwing.isDecimalNumber("a123456789"));
        assertFalse(ToolsSwing.isDecimalNumber("01234a6789"));
        
        assertFalse(ToolsSwing.isDecimalNumber(" "));
        assertFalse(ToolsSwing.isDecimalNumber(""));
        assertFalse(ToolsSwing.isDecimalNumber("123!"));
        assertFalse(ToolsSwing.isDecimalNumber("123#"));
        assertFalse(ToolsSwing.isDecimalNumber("123 456"));
        assertFalse(ToolsSwing.isDecimalNumber("123.34.0")); 
        assertFalse(ToolsSwing.isDecimalNumber("123,43")); // no acepta coma
        assertFalse(ToolsSwing.isDecimalNumber(".43"));
        assertFalse(ToolsSwing.isDecimalNumber("43."));
        
        assertFalse(ToolsSwing.isDecimalNumber("!"));
        assertFalse(ToolsSwing.isDecimalNumber("\"")); //simbolo "
        assertFalse(ToolsSwing.isDecimalNumber("#"));
        assertFalse(ToolsSwing.isDecimalNumber("$"));
        assertFalse(ToolsSwing.isDecimalNumber("%"));
        assertFalse(ToolsSwing.isDecimalNumber("&"));
        assertFalse(ToolsSwing.isDecimalNumber("/"));
        assertFalse(ToolsSwing.isDecimalNumber("("));
        assertFalse(ToolsSwing.isDecimalNumber(")"));
        assertFalse(ToolsSwing.isDecimalNumber("="));
        assertFalse(ToolsSwing.isDecimalNumber("?"));
        assertFalse(ToolsSwing.isDecimalNumber("¡"));
        assertFalse(ToolsSwing.isDecimalNumber("'"));
        assertFalse(ToolsSwing.isDecimalNumber("¿"));
        assertFalse(ToolsSwing.isDecimalNumber("\\")); // simbolo \
        assertFalse(ToolsSwing.isDecimalNumber("|"));
        assertFalse(ToolsSwing.isDecimalNumber("¬"));
        assertFalse(ToolsSwing.isDecimalNumber("°"));
        assertFalse(ToolsSwing.isDecimalNumber("@"));
        assertFalse(ToolsSwing.isDecimalNumber("´"));
        assertFalse(ToolsSwing.isDecimalNumber("¨"));
        assertFalse(ToolsSwing.isDecimalNumber("+"));
        assertFalse(ToolsSwing.isDecimalNumber("*"));
        assertFalse(ToolsSwing.isDecimalNumber("~"));
        assertFalse(ToolsSwing.isDecimalNumber("{"));
        assertFalse(ToolsSwing.isDecimalNumber("^"));
        assertFalse(ToolsSwing.isDecimalNumber("["));
        assertFalse(ToolsSwing.isDecimalNumber("}"));
        assertFalse(ToolsSwing.isDecimalNumber("`"));
        assertFalse(ToolsSwing.isDecimalNumber("]"));
        assertFalse(ToolsSwing.isDecimalNumber(","));
        assertFalse(ToolsSwing.isDecimalNumber(";"));
        assertFalse(ToolsSwing.isDecimalNumber("."));
        assertFalse(ToolsSwing.isDecimalNumber(":"));
        assertFalse(ToolsSwing.isDecimalNumber("-"));
        assertFalse(ToolsSwing.isDecimalNumber("_"));
        
        assertFalse(ToolsSwing.isDecimalNumber("a"));
        assertFalse(ToolsSwing.isDecimalNumber("b"));
        assertFalse(ToolsSwing.isDecimalNumber("c"));
        assertFalse(ToolsSwing.isDecimalNumber("d"));
        assertFalse(ToolsSwing.isDecimalNumber("e"));
        assertFalse(ToolsSwing.isDecimalNumber("f"));
        assertFalse(ToolsSwing.isDecimalNumber("g"));
        assertFalse(ToolsSwing.isDecimalNumber("h"));
        assertFalse(ToolsSwing.isDecimalNumber("i"));
        assertFalse(ToolsSwing.isDecimalNumber("j"));
        assertFalse(ToolsSwing.isDecimalNumber("k"));
        assertFalse(ToolsSwing.isDecimalNumber("l"));
        assertFalse(ToolsSwing.isDecimalNumber("m"));
        assertFalse(ToolsSwing.isDecimalNumber("n"));
        assertFalse(ToolsSwing.isDecimalNumber("o"));
        assertFalse(ToolsSwing.isDecimalNumber("p"));
        assertFalse(ToolsSwing.isDecimalNumber("q"));
        assertFalse(ToolsSwing.isDecimalNumber("r"));
        assertFalse(ToolsSwing.isDecimalNumber("s"));
        assertFalse(ToolsSwing.isDecimalNumber("t"));
        assertFalse(ToolsSwing.isDecimalNumber("u"));
        assertFalse(ToolsSwing.isDecimalNumber("v"));
        assertFalse(ToolsSwing.isDecimalNumber("w"));
        assertFalse(ToolsSwing.isDecimalNumber("x"));
        assertFalse(ToolsSwing.isDecimalNumber("y"));
        assertFalse(ToolsSwing.isDecimalNumber("z"));
        assertFalse(ToolsSwing.isDecimalNumber("ñ"));
        
        assertFalse(ToolsSwing.isDecimalNumber("A"));
        assertFalse(ToolsSwing.isDecimalNumber("B"));
        assertFalse(ToolsSwing.isDecimalNumber("C"));
        assertFalse(ToolsSwing.isDecimalNumber("D"));
        assertFalse(ToolsSwing.isDecimalNumber("E"));
        assertFalse(ToolsSwing.isDecimalNumber("F"));
        assertFalse(ToolsSwing.isDecimalNumber("G"));
        assertFalse(ToolsSwing.isDecimalNumber("H"));
        assertFalse(ToolsSwing.isDecimalNumber("I"));
        assertFalse(ToolsSwing.isDecimalNumber("J"));
        assertFalse(ToolsSwing.isDecimalNumber("K"));
        assertFalse(ToolsSwing.isDecimalNumber("L"));
        assertFalse(ToolsSwing.isDecimalNumber("M"));
        assertFalse(ToolsSwing.isDecimalNumber("N"));
        assertFalse(ToolsSwing.isDecimalNumber("O"));
        assertFalse(ToolsSwing.isDecimalNumber("P"));
        assertFalse(ToolsSwing.isDecimalNumber("Q"));
        assertFalse(ToolsSwing.isDecimalNumber("R"));
        assertFalse(ToolsSwing.isDecimalNumber("S"));
        assertFalse(ToolsSwing.isDecimalNumber("T"));
        assertFalse(ToolsSwing.isDecimalNumber("U"));
        assertFalse(ToolsSwing.isDecimalNumber("V"));
        assertFalse(ToolsSwing.isDecimalNumber("W"));
        assertFalse(ToolsSwing.isDecimalNumber("X"));
        assertFalse(ToolsSwing.isDecimalNumber("Y"));
        assertFalse(ToolsSwing.isDecimalNumber("Z"));
        assertFalse(ToolsSwing.isDecimalNumber("Ñ"));
    }
    
    @Test
    public void TAgrupar(){
        char[] a = {'1','2','3','4','5'};
        char[] b = {'a','b','c','d','e'};
        char[] c = {};
        char[] ab = {'1','2','3','4','5','a','b','c','d','e'};
        char[] ba = {'a','b','c','d','e','1','2','3','4','5'};
        
        assertArrayEquals(a, ToolsSwing.Agrupar(a, c));
        assertArrayEquals(b, ToolsSwing.Agrupar(b, c));
        assertArrayEquals(c, ToolsSwing.Agrupar(c, c));
        
        assertArrayEquals(ab, ToolsSwing.Agrupar(a, b));
        assertArrayEquals(ba, ToolsSwing.Agrupar(b, a));
    }
    
    @Test
    public void TLimitCharacters(){
        char[] a = {'1','2','3'};
        char[] b = {'a','b','c'};
        char[] c = {};
        char[] ab = {'1','2','3','a','b','c'};
        
        assertTrue(ToolsSwing.limitCharacters(a,"1"));
        assertTrue(ToolsSwing.limitCharacters(a,"2"));
        assertTrue(ToolsSwing.limitCharacters(a,"3"));
        assertTrue(ToolsSwing.limitCharacters(b,"a"));
        assertTrue(ToolsSwing.limitCharacters(b,"b"));
        assertTrue(ToolsSwing.limitCharacters(b,"c"));
        assertTrue(ToolsSwing.limitCharacters(new char[]{'H','O','L','A','_'},"_HOLA_"));
        
        assertTrue(ToolsSwing.limitCharacters(ToolsSwing.LETTERS_MAYUS,"ABCDEFGHIJKLMNOPQRSTUVWXYZÑ"));
        assertTrue(ToolsSwing.limitCharacters(ToolsSwing.LETTERS_MINUS,"abcdefghijklmnopqrstuvwxyzñ"));
        assertTrue(ToolsSwing.limitCharacters(ToolsSwing.NUMBERS,"0123456789"));
        assertTrue(ToolsSwing.limitCharacters(ToolsSwing.SIMBOLS,"!#$%&/()=?¡+-*_{}[].;:@"));
        
        assertTrue(ToolsSwing.limitCharacters(ToolsSwing.Agrupar(ToolsSwing.NUMBERS, new char[]{'_','.'}),"_.12345.67890._"));
        
        assertTrue(ToolsSwing.limitCharacters(ab,"abc123"));
        assertTrue(ToolsSwing.limitCharacters(ab,"123abc"));
        
        assertFalse(ToolsSwing.limitCharacters(a,"abc"));
        assertFalse(ToolsSwing.limitCharacters(b,"123"));
    }
}
