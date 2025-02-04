package in.crm.main.controller;

import java.util.List;

import in.crm.main.master.KpiMaster;
import in.crm.main.service.KpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/kpi")
public class KpiController {

	@Autowired
	private KpiService kpiService;
	

	@GetMapping("/getAllKpis")
	public ResponseEntity<List<KpiMaster>> getAllKpis() {
		List<KpiMaster> allKpis = kpiService.getAllKpiService();
		return new ResponseEntity<>(allKpis, HttpStatus.OK);
	}

	@GetMapping("/getKpi/{kpiId}")
	public ResponseEntity<KpiMaster> getKpi(
			@PathVariable("kpiId") @Positive(message = "KPI Id must be positive") Integer kpiId) {
		KpiMaster kpi = kpiService.getKpiServiceById(kpiId);
		if (kpi != null) {
			return new ResponseEntity<>(kpi, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addKpi")
	public ResponseEntity<String> addKpi(@RequestBody @Valid KpiMaster kpiMaster) {
		Boolean isAdded = kpiService.addKpiService(kpiMaster);
		if (isAdded) {
			return new ResponseEntity<>("KPI added Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to add KPI", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateKpi/{kpiId}")
	public ResponseEntity<String> updateKpi(
			@PathVariable("kpiId") @Positive(message = "KPI ID must be positive") Integer kpiId,
			@RequestBody @Valid KpiMaster kpiMaster) {
		kpiMaster.setKpiId(kpiId);

		Boolean isUpdated = kpiService.updateKpiService(kpiMaster);
		if (isUpdated) {
			return new ResponseEntity<>("KPI updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update KPI", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteKpi/{kpiId}")
	public ResponseEntity<String> deleteKpi(
			@PathVariable("kpiId") @Positive(message = "KPI Id must be Positive") Integer kpiId) {
		try {
			KpiMaster kpi = kpiService.getKpiServiceById(kpiId);
			if (kpi != null) {
				Boolean isDeleted = kpiService.deleteKpi(kpi);
				if (isDeleted) {
					return new ResponseEntity<>("KPI deleted successfully", HttpStatus.OK);
				}
			}
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed to delete KPI", HttpStatus.BAD_REQUEST);
	}

}
