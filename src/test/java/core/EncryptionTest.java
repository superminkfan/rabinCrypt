package core;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import stuff.BinaryGenerator;
import stuff.DecimalGenerator;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EncryptionTest {

    @Mock
    BinaryGenerator binaryGenerator;

    @Mock
    DecimalGenerator decimalGenerator;

    Encryption encryption;

    @Before
    public void setUp() {
        encryption = new Encryption();
    }

    @Test
    public void testEncrypt() {
        ArrayList<Integer> binArrayM = new ArrayList<>();
        binArrayM.add(1);
        binArrayM.add(0);
        binArrayM.add(1);
        when(binaryGenerator.GenerateBinaryFormat(anyLong())).thenReturn(binArrayM);

        ArrayList<Long> finalMessage = encryption.Encrypt(10, 100);
        assertNotNull(finalMessage);
        assertEquals(1, finalMessage.size());
        assertEquals(1, finalMessage.get(0).longValue());
    }

    @Test
    public void testEncryptWithLargeMessage() {
        ArrayList<Integer> binArrayM = new ArrayList<>();
        binArrayM.add(1);
        binArrayM.add(0);
        binArrayM.add(1);
        when(binaryGenerator.GenerateBinaryFormat(anyLong())).thenReturn(binArrayM);

        ArrayList<Long> finalMessage = encryption.Encrypt(1000000000000000000L, 1000000000000000000L);
        assertNotNull(finalMessage);
        assertEquals(1, finalMessage.size());
        assertEquals(1, finalMessage.get(0).longValue());
    }

    @Test
    public void testEncryptWithZeroMessage() {
        ArrayList<Integer> binArrayM = new ArrayList<>();
        binArrayM.add(0);
        when(binaryGenerator.GenerateBinaryFormat(anyLong())).thenReturn(binArrayM);

        ArrayList<Long> finalMessage = encryption.Encrypt(0, 100);
        assertNotNull(finalMessage);
        assertEquals(1, finalMessage.size());
        assertEquals(0, finalMessage.get(0).longValue());
    }

    @Test
    public void testEncryptWithNegativeMessage() {
        ArrayList<Integer> binArrayM = new ArrayList<>();
        binArrayM.add(1);
        binArrayM.add(0);
        binArrayM.add(1);
        when(binaryGenerator.GenerateBinaryFormat(anyLong())).thenReturn(binArrayM);

        ArrayList<Long> finalMessage = encryption.Encrypt(-10, 100);
        assertNotNull(finalMessage);
        assertEquals(1, finalMessage.size());
        assertEquals(1, finalMessage.get(0).longValue());
    }

    @Test
    public void testEncryptWithLargeModulus() {
        ArrayList<Integer> binArrayM = new ArrayList<>();
        binArrayM.add(1);
        binArrayM.add(0);
        binArrayM.add(1);
        when(binaryGenerator.GenerateBinaryFormat(anyLong())).thenReturn(binArrayM);

        ArrayList<Long> finalMessage = encryption.Encrypt(10, 1000000000000000000L);
        assertNotNull(finalMessage);
        assertEquals(1, finalMessage.size());
        assertEquals(1, finalMessage.get(0).longValue());
    }

    @Test
public void testEncryptWithLetterString() {
    ArrayList<Integer> binArrayM = new ArrayList<>();
    binArrayM.add(1);
    binArrayM.add(0);
    binArrayM.add(1);
    when(binaryGenerator.GenerateBinaryFormat(anyString())).thenReturn(binArrayM);

    ArrayList<Long> finalMessage = encryption.Encrypt("hello", "world");
    assertNotNull(finalMessage);
    assertEquals(1, finalMessage.size());
    assertEquals(1, finalMessage.get(0).longValue());
}

@Test
public void testEncryptWithEmptyLetterString() {
    ArrayList<Integer> binArrayM = new ArrayList<>();
    binArrayM.add(0);
    when(binaryGenerator.GenerateBinaryFormat(anyString())).thenReturn(binArrayM);

    ArrayList<Long> finalMessage = encryption.Encrypt("", "world");
    assertNotNull(finalMessage);
    assertEquals(1, finalMessage.size());
    assertEquals(0, finalMessage.get(0).longValue());
}

@Test
public void testEncryptWithNullLetterString() {
    ArrayList<Integer> binArrayM = new ArrayList<>();
    binArrayM.add(0);
    when(binaryGenerator.GenerateBinaryFormat(anyString())).thenReturn(binArrayM);

    ArrayList<Long> finalMessage = encryption.Encrypt(null, "world");
    assertNotNull(finalMessage);
    assertEquals(1, finalMessage.size());
    assertEquals(0, finalMessage.get(0).longValue());
}

@Test
public void testEncryptWithSpecialCharacterString() {
    ArrayList<Integer> binArrayM = new ArrayList<>();
    binArrayM.add(1);
    binArrayM.add(0);
    binArrayM.add(1);
    when(binaryGenerator.GenerateBinaryFormat(anyString())).thenReturn(binArrayM);

    ArrayList<Long> finalMessage = encryption.Encrypt("hello!", "world!");
    assertNotNull(finalMessage);
    assertEquals(1, finalMessage.size());
    assertEquals(1, finalMessage.get(0).longValue());
}


}
