package enums;

public enum Orden {
	ALEATORIO {
		@Override
		public String toString() {
			return "Aleatorio";
		}
	},
	ORDENADO {
		@Override
		public String toString() {
			return "Ordenado";
		}
	},
	CASI_ORDENADO {
		@Override
		public String toString() {
			return "Casi Ordenado";
		}
	},
	INVERTIDO {
		@Override
		public String toString() {
			return "Invertido";
		}
	},
	CASI_INVERTIDO {
		@Override
		public String toString() {
			return "Casi Invertido";
		}
	}
}
