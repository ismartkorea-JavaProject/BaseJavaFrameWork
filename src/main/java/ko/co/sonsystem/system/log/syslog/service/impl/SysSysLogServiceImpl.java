package ko.co.sonsystem.system.log.syslog.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import ko.co.sonsystem.system.log.syslog.service.SysLog;
import ko.co.sonsystem.system.log.syslog.service.SysSysLogService;

/**
 * 로그관리(시스템)를 위한 서비스 구현 클래스
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
@Service("SysSysLogService")
public class SysSysLogServiceImpl extends EgovAbstractServiceImpl implements 
	SysSysLogService {

	@Resource(name="SysLogDAO")
	private SysLogDAO sysLogDAO;	
	
    /** ID Generation */    
	@Resource(name="egovSysLogIdGnrService")
	private EgovIdGnrService egovSysLogIdGnrService;

	/**
	 * 시스템 로그정보를 생성한다.
	 * 
	 * @param SysLog
	 */
	public void logInsertSysLog(SysLog sysLog) throws Exception {
		// TODO Auto-generated method stub
		String requstId = egovSysLogIdGnrService.getNextStringId();
		sysLog.setRequstId(requstId);
		
		sysLogDAO.logInsertSysLog(sysLog);    	
	}

	/**
	 * 시스템 로그정보를 요약한다.
	 * 
	 * @param 
	 */
	public void logInsertSysLogSummary()
			throws Exception {
		// TODO Auto-generated method stub

		sysLogDAO.logInsertSysLogSummary();    	
	}

	/**
	 * 시스템 로그정보를 조회한다.
	 * 
	 * @param sysLog
	 * @return sysLog
	 * @throws Exception 
	 */
	public SysLog selectSysLog(SysLog sysLog) throws Exception{
		
		return sysLogDAO.selectSysLog(sysLog);
	}	

	/**
	 * 시스템 로그정보 목록을 조회한다.
	 * 
	 * @param SysLog
	 */
	public Map<String, Object> selectSysLogInf(SysLog sysLog) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> _map = new HashMap<String, Object>();
		_map.put("resultList", sysLogDAO.selectSysLogInf(sysLog));
		_map.put("resultCnt", Integer.toString(sysLogDAO.selectSysLogInfCnt(sysLog)));
		 
		return _map;
	}

}
