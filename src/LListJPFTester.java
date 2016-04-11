import gov.nasa.jpf.vm.Verify;


public class LListJPFTester {
	public static void main(String[] args) {
		if (args.length != 2) throw new IllegalArgumentException();
		final int SEQUENCE_LENGTH = Integer.parseInt(args[0]);
		final int ELEM_UPPER_BOUND = Integer.parseInt(args[1]);
		
		int seqLength = Verify.getInt(1, SEQUENCE_LENGTH);
		
		Verify.getCounter(0);
		LList llist = new LList();
		for (int i = 0; i < seqLength - 1; i++) {
			int method = Verify.getInt(2, SEQUENCE_LENGTH);
			int element = Verify.getInt(0, ELEM_UPPER_BOUND);
			switch (method) {
				case 2:
					System.out.println("addFirst(" + element + ")");
					llist.addFirst(element);
					break;
				case 3:
					System.out.println("addLast(" + element + ")");
					llist.addLast(element);
					break;
			}
		}	
		Verify.incrementCounter(0);
	}
}
