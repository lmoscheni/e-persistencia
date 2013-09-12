package main;

public enum Resultado {
	
	LOCAL {
		@Override
		public Resultado getResult(Team teamLocal) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	VISITANTE {
		@Override
		public Resultado getResult(Team teamLocal) {
			// TODO Auto-generated method stub
			return null;
		}
	},
	EMPATE {
		@Override
		public Resultado getResult(Team teamLocal) {
			// TODO Auto-generated method stub
			return null;
		}
	};

	abstract public Resultado getResult(Team teamLocal);
	
}
