import gov.nasa.jpf.vm.Verify;

public class LListJPFAddFirstTester {
	public static void main(String[] args) {
		if (args.length != 2) throw new IllegalArgumentException();
		final int SEQUENCE_LENGTH = Integer.parseInt(args[0]);
		final int ELEM_UPPER_BOUND = Integer.parseInt(args[1]);
		
		int seqLength = Verify.getInt(0, SEQUENCE_LENGTH);
		int elemBound = Verify.getInt(0, ELEM_UPPER_BOUND);
		
		LList llist = new LList();
		for (int i = 0; i < seqLength; i++) {
			llist.addFirst(elemBound);
		}
	}
}
