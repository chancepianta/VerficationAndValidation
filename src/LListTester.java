import org.junit.Assert;
import org.junit.Test;

// JUnit Test Suite for full test coverage of LList's addLast method
public class LListTester {
	// Test with LList with no entries
	@Test
	public void test0() {
		LList llist = new LList();
		Assert.assertTrue(llist.size == 0);
		llist.addLast(1);
		Assert.assertTrue(llist.size == 1);
		Assert.assertNotNull(llist.header);
		Assert.assertTrue(llist.header.elem == 1);
		Assert.assertTrue(llist.header.next == llist.header);
	}
	
	@Test
	public void test1() {
		LList llist = new LList();
		llist.addFirst(1);
		Assert.assertTrue(llist.size == 1);
		llist.addLast(2);
		Assert.assertTrue(llist.size == 2);
		Assert.assertNotNull(llist.header.next);
		Assert.assertTrue(llist.header.next.elem == 2);
		Assert.assertTrue(llist.header.next.next == llist.header.next);
	}
}
