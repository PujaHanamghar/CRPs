//package com.sts.ServiceIMPL;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.sts.DAO.StateDAO;
//import com.sts.Master.StateMaster;
//import com.sts.Service.StateService;
//
//@Service
//public class StateServiceImpl implements StateService {
//
//	@Autowired
//	StateDAO stateDAO;
//
//	@Override
//	public Boolean addStateService(StateMaster stateMaster) {
//		try {
//			stateDAO.save(stateMaster);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	@Override
//	public Boolean updateStateService(StateMaster stateMaster) {
//		try {
//			if (stateDAO.existsById(stateMaster.getStateID())) {
//				stateDAO.save(stateMaster);
//				return true;
//			} else {
//				System.out.println("stateMaster not found for update.");
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	@Override
//	public Boolean deleteStateService(StateMaster stateMaster) {
//		try {
//			stateDAO.deleteById(stateMaster.getStateID());
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	@Override
//	public StateMaster getStateService(Integer stateId) {
//		try {
//			return stateDAO.findById(stateId).orElse(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@Override
//	public List<StateMaster> getAllStateService() {
//		try {
//			return (List<StateMaster>) stateDAO.findAll();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//}
