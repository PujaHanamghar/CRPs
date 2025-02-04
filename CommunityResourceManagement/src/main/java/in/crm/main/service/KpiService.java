package in.crm.main.service;

import in.crm.main.master.KpiMaster;

import java.util.List;



public interface KpiService {

	public List<KpiMaster> getAllKpiService();
	public KpiMaster getKpiServiceById(Integer kpiId);
	public Boolean addKpiService(KpiMaster kpiMaster);
	public Boolean updateKpiService(KpiMaster kpiMaster);
	public Boolean deleteKpi(KpiMaster kpiMaster);
}
