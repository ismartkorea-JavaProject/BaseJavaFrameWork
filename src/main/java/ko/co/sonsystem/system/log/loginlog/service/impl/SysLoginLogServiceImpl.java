package ko.co.sonsystem.system.log.loginlog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import ko.co.sonsystem.system.log.loginlog.service.LoginLog;
import ko.co.sonsystem.system.log.loginlog.service.SysLoginLogService;

/**
 * 접속로그 관리를 위한 서비스 구현 클래스
 * @author s-onsystem
 * @since 2023.11.16
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.11.16  jeong          최초 생성
 *
 * </pre>
 */
@Service("SysLoginLogService")
public class SysLoginLogServiceImpl extends EgovAbstractServiceImpl implements
	SysLoginLogService {

	@Resource(name="sysLoginLogDAO")
	private SysLoginLogDAO loginLogDAO;	
	
    /** ID Generation */    
	@Resource(name="egovLoginLogIdGnrService")
	private EgovIdGnrService egovLoginLogIdGnrService;

	/**
	 * 접속로그를 기록한다.
	 * 
	 * @param LoginLog
	 */
	public void logInsertLoginLog(LoginLog loinLog) throws Exception {
		// TODO Auto-generated method stub
		String logId = egovLoginLogIdGnrService.getNextStringId();
		loinLog.setLogId(logId);
		
		loginLogDAO.logInsertLoginLog(loinLog);    	

	}

	/**
	 * 접속로그를 조회한다.
	 * 
	 * @param loginLog
	 * @return loginLog
	 * @throws Exception 
	 */
	public LoginLog selectLoginLog(LoginLog loginLog) throws Exception{
		
		return loginLogDAO.selectLoginLog(loginLog);
	}	

	/**
	 * 접속로그 목록을 조회한다.
	 * 
	 * @param LoginLog
	 */
	public Map<String, Object> selectLoginLogInf(LoginLog loinLog) throws Exception {
		// TODO Auto-generated method stub
		 
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("resultList", loginLogDAO.selectLoginLogInf(loinLog));
		_map.put("resultCnt", Integer.toString(loginLogDAO.selectLoginLogInfCnt(loinLog)));
		 
		return _map;
	}

}
