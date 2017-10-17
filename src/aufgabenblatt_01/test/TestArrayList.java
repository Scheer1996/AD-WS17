package aufgabenblatt_01.test;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt_01.ArrayList;
import aufgabenblatt_01.Elem;
import aufgabenblatt_01.Key;
import aufgabenblatt_01.Pos;


public class TestArrayList
{
	ArrayList<Elem<Integer>> _testSet;
	
	public TestArrayList()
	{
		_testSet = new ArrayList<Elem<Integer>>();
	}
	
	@Test
	public void testeSize()
	{
		assertEquals(0, _testSet.size());
		
		_testSet.add(new Elem<Integer>(10, new Key(1)));
		
		assertEquals(1, _testSet.size());
		
		_testSet.add(new Elem<Integer>(11, new Key(2)));
		assertEquals(2, _testSet.size());
		_testSet.add(new Elem<Integer>(12, new Key(3)));
		_testSet.add(new Elem<Integer>(13, new Key(4)));
		_testSet.add(new Elem<Integer>(14, new Key(5)));
		_testSet.add(new Elem<Integer>(15, new Key(6)));
		_testSet.add(new Elem<Integer>(16, new Key(7)));
		_testSet.add(new Elem<Integer>(17, new Key(8)));
		_testSet.add(new Elem<Integer>(18, new Key(9)));
		_testSet.add(new Elem<Integer>(19, new Key(10)));
		_testSet.add(new Elem<Integer>(20, new Key(11)));
		assertEquals(11, _testSet.size());
		
		_testSet.deleteKey(new Key(11));
		assertEquals(10, _testSet.size());
	}
	
	@Test
	public void testeAddAndFind()
	{
		_testSet.add(new Elem<Integer>(500 ,new Key(100)));
		
		Pos<Integer> p1 = new Pos<Integer>(0, true);
		assertEquals(p1, _testSet.find(new Key(100)));
		assertNotEquals(p1, _testSet.find(new Key(101)));
	}
	
	@Test
	public void testeAddAndDeletePos()
	{
		Pos<Integer> invalidPos = new Pos<Integer>(999, false);
		_testSet.add(new Elem<Integer>(10, new Key(100)));
		assertNotEquals(0, _testSet.find(new Key(100)));
		
		_testSet.deletePos(_testSet.find(new Key(100)));
		assertEquals(invalidPos, _testSet.find(new Key(100)));
		
		_testSet.add(new Elem<Integer>(13, new Key(100)));
		_testSet.add(new Elem<Integer>(14, new Key(101)));
		_testSet.add(new Elem<Integer>(15, new Key(102)));
		_testSet.add(new Elem<Integer>(16, new Key(104)));
		
		_testSet.deletePos(_testSet.find(new Key(101)));
		assertEquals(invalidPos, _testSet.find(new Key(101)));
	}
	
	@Test
	public void testeAddAndDeleteKey()
	{
		Pos<Integer> invalidPos = new Pos<Integer>(999, false);
		_testSet.add(new Elem<Integer>(10, new Key(100)));
		assertNotEquals(invalidPos, _testSet.find(new Key(100)));
		
		_testSet.deleteKey(new Key(100));
		assertEquals(invalidPos, _testSet.find(new Key(100)));
		
		_testSet.add(new Elem<Integer>(13, new Key(100)));
		_testSet.add(new Elem<Integer>(14, new Key(101)));
		_testSet.add(new Elem<Integer>(15, new Key(102)));
		_testSet.add(new Elem<Integer>(16, new Key(104)));
		
		_testSet.deleteKey(new Key(101));
		assertEquals(invalidPos, _testSet.find(new Key(101)));
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testeAddAndRetrieve()
	{
		Elem<Integer> e = new Elem<Integer>(10, new Key(100));
		_testSet.add(e);
		
		@SuppressWarnings("unchecked")
		Elem<Integer> e2 = (Elem<Integer>) _testSet.retrieve(_testSet.find(new Key(100)));
		@SuppressWarnings("unchecked")
		Elem<Integer> e3 = (Elem<Integer>) _testSet.retrieve(new Pos(100, false));
		assertEquals(e.getKey(), e2.getKey());
		assertNotEquals(e.getKey(), e3.getKey());
	}
	
	@Test
	public void testeUnify() {
		
		_testSet.add(new Elem<Integer>(10, new Key(1)));
		_testSet.add(new Elem<Integer>(11, new Key(2)));
		_testSet.add(new Elem<Integer>(12, new Key(3)));
		_testSet.add(new Elem<Integer>(13, new Key(4)));
		_testSet.add(new Elem<Integer>(14, new Key(5)));
		_testSet.add(new Elem<Integer>(15, new Key(6)));
		_testSet.add(new Elem<Integer>(16, new Key(7)));

		ArrayList<Elem<Integer>> _testSetZwei = new ArrayList<Elem<Integer>>();
		
		_testSetZwei.add(new Elem<Integer>(10, new Key(1)));
		_testSetZwei.add(new Elem<Integer>(11, new Key(2)));
		_testSetZwei.add(new Elem<Integer>(12, new Key(3)));
		_testSetZwei.add(new Elem<Integer>(13, new Key(4)));
		_testSetZwei.add(new Elem<Integer>(14, new Key(5)));
		_testSetZwei.add(new Elem<Integer>(15, new Key(6)));
		_testSetZwei.add(new Elem<Integer>(16, new Key(7)));
		_testSetZwei.add(new Elem<Integer>(17, new Key(8)));
		_testSetZwei.add(new Elem<Integer>(18, new Key(9)));
		_testSetZwei.add(new Elem<Integer>(19, new Key(10)));
		_testSetZwei.add(new Elem<Integer>(20, new Key(11)));
		_testSetZwei.add(new Elem<Integer>(20, new Key(12)));
		_testSetZwei.add(new Elem<Integer>(20, new Key(13)));
		_testSetZwei.add(new Elem<Integer>(20, new Key(14)));
		_testSetZwei.add(new Elem<Integer>(20, new Key(15)));

		ArrayList<Elem<Integer>> _testSetDrei = new ArrayList<Elem<Integer>>();
		_testSetDrei = (ArrayList<Elem<Integer>>) _testSetDrei.unify(_testSet, _testSetZwei);
		
		assertEquals(15, _testSetDrei.size());
	}
}
