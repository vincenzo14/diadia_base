package it.uniroma3.diadia.direzioni;

public enum Direzione {

	nord(0) {
		@Override
		public Direzione getDirezioneOpposta() {
			return sud;
		}
	},
	est(90){
		@Override
		public Direzione getDirezioneOpposta() {
			return ovest;
		}
	},
	sud(180) {
		@Override
		public Direzione getDirezioneOpposta() {
			return nord;
		}
	},
	ovest(270) {
		@Override
		public Direzione getDirezioneOpposta() {
			return est;
		}
	};
	
	private final int gradi;
	
	private Direzione(int gradi) {
		this.gradi = gradi;
	}
	
	/**
	 * @return the gradi
	 */
	
	public int getGradi() {
		return gradi;
	}
	
	public abstract Direzione getDirezioneOpposta();

}
