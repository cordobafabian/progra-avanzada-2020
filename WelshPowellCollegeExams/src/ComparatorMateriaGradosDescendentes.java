import java.util.Comparator;

public class ComparatorMateriaGradosDescendentes implements Comparator<Materia> {

	@Override
	public int compare(Materia o1, Materia o2) {
		return o2.getGrado() - o1.getGrado();
	}
	
}
