package sampleQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class QueueTest {

	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;


	@Test
	@Disabled
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}

	//Example of Wrong Test! 
	@Test
	@Disabled
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}
	

	@Test
	void constructorsShouldCreateEmptyQueue() {
		assertTrue(q.isEmpty());
	}
	
	@Test
	void enqueueShouldIncreaseSize() {
		int oldSize=q.size();
		q.enqueue("new node");
		int newSize=q.size();
		assertEquals(oldSize+1, newSize);
	}
	
	@Test
	void enqueueMakesNewItemLastItem() {
		String newItem="An item";
		q.enqueue(newItem);
		Iterator<String> it=q.iterator();
		String item="";
		while(it.hasNext())
			item=it.next();
		assertEquals(newItem,item);				
	}
	
	@Test
    @Disabled
	void enqueueShouldThrowException() {
		Queue<String> queue=new Queue<>(10);
		for(int i=0;i<10;i++) {
			q.enqueue(SOME_ITEM);
		}
		assertThrows(Exception.class, ()-> queue.enqueue("Last item"));
	}
	
	@Test
	void dequeueShouldDeccreaseSize() {
		for(int i=0;i<10;i++) {
			q.enqueue(SOME_ITEM);
		}		
		int oldSize=q.size();
		q.dequeue();
		int newSize=q.size();
		assertEquals(oldSize-1, newSize);
	}
	
	@Test
	void dequeueMakesSecondItemTheFirstItem() {
		String firstItem=SOME_ITEM;
		String secondItem="Item 2";
		q.enqueue(firstItem);
		q.enqueue(secondItem);
		for(int i=2;i<10;i++) {
			q.enqueue(SOME_ITEM);
		}
		q.dequeue();
		assertEquals(q.dequeue(), secondItem);
	}
	
	@Test
	void dequeueShouldThrowException() {
		assertThrows(NoSuchElementException.class,()->q.dequeue());
	}
	
	@Test
	void peekShouldThrowException() {
		assertThrows(NoSuchElementException.class, () -> q.peek());
	}
	
	@Test
	void peekGivesFirst() {
		String firstItem="Item 1";
		String secondItem=SOME_ITEM;
		q.enqueue(firstItem);
		q.enqueue(secondItem);
		assertEquals(q.peek(),firstItem);
	}
	
	@Test
	void sizeShouldGiveNumberOfItems() {
		for(int i=0;i<10;i++) {
			q.enqueue(SOME_ITEM);
		}
		assertEquals(10, q.size());
	}
	
	@Test
	void isEmptyReportsEmptiness() {
		assertTrue(q.isEmpty());
		for(int i=0;i<10;i++) {
			q.enqueue(SOME_ITEM);
		}
		q.removeAll();
		assertTrue(q.isEmpty());
	}
	
	@Test
	void removeAllShouldRemoveAll() {
		for(int i=0;i<10;i++) {
			q.enqueue(SOME_ITEM);
		}
		q.removeAll();
		assertTrue(q.isEmpty());
	}
}
