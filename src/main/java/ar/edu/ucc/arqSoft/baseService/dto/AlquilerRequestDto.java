package ar.edu.ucc.arqSoft.baseService.dto;

public class AlquilerRequestDto {

		private Long socioId;
		
		private Long peliculaId;
	

		public Long getSocioId() {
			return socioId;
		}

		public void setSocioId(Long socioId) {
			this.socioId = socioId;
		}

		public Long getPeliculaId() {
			return peliculaId;
		}

		public void setPeliculaId(Long peliculaId) {
			this.peliculaId = peliculaId;
		}
		
}
