package com.accenture.academico.model.entities;

public enum OperacoesBancarias {

	EXTRATO("1");
	
	
	
	private final String Extrato;
	
		OperacoesBancarias(String Extrato) {
			this.Extrato = Extrato;
	}
		public String getExtrato() {
			return Extrato;
		}
}
