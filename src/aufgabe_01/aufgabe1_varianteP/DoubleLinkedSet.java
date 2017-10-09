package aufgabe1;

import java.util.Arrays;

/**
 * Implementation 1 (AUSZUG AUFGABENBLATT AD)
 * Speichern Sie die Elemente in einem Array von Container-Klassen. Die Container-
 * Klasse enthält je einen next- und previous-Index (Integer-Index im Array), sowie
 * das eigentliche Element vom Grundtyp. Die Reihenfolge der Elemente sollen durch
 * den next- und previous-Index sortiert sein. Für den Abbruch der Suche verwenden
 * Sie ein Stop-Element. Wird beim Hinzufügen die Array-Größe überschritten, muss
 * entsprechend vergrößert werden.
 * 
 * @author Paul Mathia
 * @param <T>
 */

public class DoubleLinkedSet<T> implements Set
{
    // refers to the actual free position
    private int actualPosition; 

    /*
     * start size of the array
     */
    private final int START_SIZE = 3;

    /*
     * extension factor
     */
    private final int EXTENSION_FACTOR = 2;

    /*
     * array for storing the data
     */
    private ElemPrevNext[] data;

    /*
     * Number of elements stored
     */
    protected int setSize = 0;
    
    private int arrayLength; 
    

    /*
     * constructor
     */
    public DoubleLinkedSet()
    {
        setSize = 0;
        actualPosition = 1; 
        data = new ElemPrevNext[START_SIZE];
        arrayLength = data.length; 

    }

    @Override
    public int add(Elem<?> e) {
      
            if (actualPosition < data.length)
            {
                data[actualPosition] = (ElemPrevNext) e;
                data[actualPosition].setPreviousIndex(actualPosition - 1);
                data[actualPosition].setNextIndex(actualPosition++);
                setSize++;

            } 
            else if (actualPosition >= data.length)
            {
                Elem<?>[] neuesArray;
                neuesArray = Arrays.copyOf(data, data.length *EXTENSION_FACTOR );
                data = (ElemPrevNext[]) neuesArray;
                data[actualPosition] = (ElemPrevNext)e;
                data[actualPosition].setPreviousIndex(actualPosition-1);
                data[actualPosition].setNextIndex(actualPosition++);
                setSize++;
   
            }
        return actualPosition-1; 
    }

    @Override
    public void deletePos(int index) 
    {
        assert data[index] != null : "Vorbedingung verletzt data[index] != null";
        assert (index >= 1) : "Vorbedingung verletzt index >= 1";

        if (data[index - 1] != null)
        {
            data[index - 1].setNextIndex(index);
        }

        if (data[index + 1] != null)
        {
            data[index + 1].setPreviousIndex(index-1);
        }
        data[index].setElement(null);
        data[index] = null;
        setSize--;

    }

    @Override
    public void deleteKey(Key key) {
        // TODO Auto-generated method stub
        int index = find(key);
        deletePos(index);
    }

    @Override
    public int find(Key key) {
        int index = actualPosition - 1;
        data[0] = new ElemPrevNext<String>("stopper", new Key(0)); 
        data[0].setKey(key);
        while ((data[index] == null) || (data[index].getKey() != key))
        {
            index--;
        }
        return index;
    }

    @Override
    public Elem<?> retrieve(int index) 
    {
        Elem<?> retrieve = null;
        if (isValidIndex(index))
        {
            retrieve = data[index];
        }
        return retrieve;
    }

    @Override
    public void showall() {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() 
    {
        return setSize;
    }

    @Override
    public Set unify(Set s, Set t) {
        Set unified = new DoubleLinkedSet();

        for (int i = s.getActualPos(); i > 0; i--)
        {
            if (s.retrieve(i) != null)
            {
                unified.add(s.retrieve(i));
            }
        }
        for (int i = t.getActualPos(); i > 0; i--)
        {
            if (t.retrieve(i) != null)
            {
                unified.add(t.retrieve(i));
            }
        }
        return unified;
    }

    /**
     * 
     * @return actualPosition
     */
    @Override
    public int getActualPos()
    {
        return actualPosition;
    }

    /**
     * checks if the index is a valid position
     * 
     * @return true when the index is a valid position, otherwise false.
     */
    private boolean isValidIndex(int index)
    {
        return index >= 0 && index < actualPosition;
    }

}
