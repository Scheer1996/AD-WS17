package aufgabe_01.b;

import static org.junit.Assert.*;

import org.junit.Test;


public class SetTest
{
	ArraySet<Elem> _testSet;
	
	public SetTest()
	{
		_testSet = new ArraySet<Elem>();
	}
	
	@Test
	public void testeSize()
	{
		assertEquals(0, _testSet.size());
		
		_testSet.add(new Elem(new Key(1)));
		
		assertEquals(1, _testSet.size());
		
		_testSet.add(new Elem(new Key(2)));
		assertEquals(2, _testSet.size());
		_testSet.add(new Elem(new Key(3)));
		_testSet.add(new Elem(new Key(4)));
		_testSet.add(new Elem(new Key(5)));
		_testSet.add(new Elem(new Key(6)));
		_testSet.add(new Elem(new Key(7)));
		_testSet.add(new Elem(new Key(8)));
		_testSet.add(new Elem(new Key(9)));
		_testSet.add(new Elem(new Key(10)));
		_testSet.add(new Elem(new Key(11)));
		assertEquals(11, _testSet.size());
		
		_testSet.delete(new Key(11));
		assertEquals(10, _testSet.size());
	}
	
	@Test
	public void testeAddAndFind()
	{
		_testSet.add(new Elem(new Key(100)));
		
		assertNotEquals(0, _testSet.find(new Key(100)));
		assertEquals(0, _testSet.find(new Key(101)));
	}
	
	@Test
	public void testeAddAndDeleteIndex()
	{
		_testSet.add(new Elem(new Key(100)));
		assertNotEquals(0, _testSet.find(new Key(100)));
		
		_testSet.delete(_testSet.find(new Key(100)));
		assertEquals(0, _testSet.find(new Key(100)));
		
		_testSet.add(new Elem(new Key(100)));
		_testSet.add(new Elem(new Key(101)));
		_testSet.add(new Elem(new Key(102)));
		_testSet.add(new Elem(new Key(104)));
		
		_testSet.delete(_testSet.find(new Key(101)));
		assertEquals(0, _testSet.find(new Key(101)));
	}
	
	@Test
	public void testeAddAndDeleteKey()
	{
		_testSet.add(new Elem(new Key(100)));
		assertNotEquals(0, _testSet.find(new Key(100)));
		
		_testSet.delete(new Key(100));
		assertEquals(0, _testSet.find(new Key(100)));
		
		_testSet.add(new Elem(new Key(100)));
		_testSet.add(new Elem(new Key(101)));
		_testSet.add(new Elem(new Key(102)));
		_testSet.add(new Elem(new Key(104)));
		
		_testSet.delete(new Key(101));
		assertEquals(0, _testSet.find(new Key(101)));
	}
	
	@Test
	public void testeAddAndRetrieve()
	{
		Elem e = new Elem(new Key(100));
		_testSet.add(e);
		Elem e2 = _testSet.retrieve(_testSet.find(new Key(100)));
		Elem e3 = _testSet.retrieve(3);
		assertEquals(e, e2);
		assertNotEquals(e, e3);
	}
}
