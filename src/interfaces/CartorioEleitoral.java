package interfaces;

import java.util.List;

public interface CartorioEleitoral {

	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao) throws Exception;

	public int numeroDeZonasEleitorais();

	public void cadastraSecaoEleitoral(int numeroZonaEleitoral) throws Exception;

	public IZonaEleitoral getZona(int numeroZonaEleitoral) throws Exception;

	public List<? extends ISecao> getSecoesDeUmaZona(int numeroZonaEleitoral) throws Exception;

	public int numeroDeSecoesDeUmaZona(int numeroZonaEleitoral);

}
