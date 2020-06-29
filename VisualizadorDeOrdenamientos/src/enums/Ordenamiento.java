package enums;

public enum Ordenamiento {
	BURBUJEO {
		@Override
		public String toString() {
			return "Burbujeo";
		}
	},
	SELECCION {
		@Override
		public String toString() {
			return "Selección";
		}
	},
	INSERCION {
		@Override
		public String toString() {
			return "Inserción";
		}
	},
	MERGE_SORT {
		@Override
		public String toString() {
			return "Merge Sort";
		}
	},
	QUICK_SORT {
		@Override
		public String toString() {
			return "Quick Sort";
		}
	},
	SHELL_SORT {
		@Override
		public String toString() {
			return "Shell Sort";
		}
	}
}
