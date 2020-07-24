import java.util.Comparator;

public class ComparatorPoderDescendente implements Comparator<Monstruo> {

	@Override
	public int compare(Monstruo o1, Monstruo o2) {
		return o2.getPoder() - o1.getPoder();
	}

}
