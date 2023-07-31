
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public final class Contrat {
	private String debutContrat;
	private String finContrat;
	private Vendeur vendeur;
	
	
	public String getDebutContrat() {
		return debutContrat;
	}
	public String getFinContrat() {
		return finContrat;
	}
	public void setFinContrat(TemporalAccessor finContrat) {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.finContrat = dtf2.format(finContrat);
	}
	@Override
	public String toString() {
		return "Contrat [debutContrat=" + debutContrat + ", finContrat=" + finContrat + "]";
	}
	public Contrat(TemporalAccessor finContrat, Vendeur vendeur) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.debutContrat = dtf.format(LocalDateTime.now());
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.finContrat = dtf2.format(finContrat);
		this.vendeur = vendeur;
	}
	public Vendeur getVendeur() {
		return vendeur;
	}

		
}
