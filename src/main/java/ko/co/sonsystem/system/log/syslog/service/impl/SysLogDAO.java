package ko.co.sonsystem.system.log.syslog.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import ko.co.sonsystem.system.log.syslog.service.SysLog;

/**
 * 로그관리(시스템)를 위한 데이터 접근 클래스
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
@Repository("SysLogDAO")
public class SysLogDAO extends EgovAbstractMapper {

	/**
	 * 시스템 로그정보를 생성한다.
	 *
	 * @param SysLog
	 * @return
	 * @throws Exception
	 */
	public void logInsertSysLog(SysLog sysLog) throws Exception{
		insert("SysLogDAO.logInsertSysLog", sysLog);
	}

	/**
	 * 시스템 로그정보를 요약한다.
	 *
	 * @param
	 * @return
	 * @throws Exception
	 */
	public void logInsertSysLogSummary() throws Exception{
		insert("SysLogDAO.logInsertSysLogSummary", null);
		delete("SysLogDAO.logDeleteSysLogSummary", null);
	}

	/**
	 * 시스템 로그정보를 조회한다.
	 *
	 * @param sysLog
	 * @return sysLog
	 * @throws Exception
	 */
	public SysLog selectSysLog(SysLog sysLog) throws Exception{

		return (SysLog) selectOne("SysLogDAO.selectSysLog", sysLog);
	}

	/**
	 * 시스템 로그정보 목록을 조회한다.
	 *
	 * @param sysLog
	 * @return
	 * @throws Exception
	 */
	public List<?> selectSysLogInf(SysLog sysLog) throws Exception{
		return list("SysLogDAO.selectSysLogInf", sysLog);
	}

	/**
	 * 시스템 로그정보 목록의 숫자를 조회한다.
	 * @param sysLog
	 * @return
	 * @throws Exception
	 */
	public int selectSysLogInfCnt(SysLog sysLog) throws Exception{

		return (Integer)selectOne("SysLogDAO.selectSysLogInfCnt", sysLog);
	}

}
