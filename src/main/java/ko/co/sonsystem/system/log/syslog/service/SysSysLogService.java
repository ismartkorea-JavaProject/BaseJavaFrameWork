package ko.co.sonsystem.system.log.syslog.service;

import java.util.Map;

/**
 * 로그관리(시스템)를 위한 서비스 인터페이스
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
public interface SysSysLogService {

	/**
	 * 시스템 로그정보를 생성한다.
	 *
	 * @param SysLog
	 */
	public void logInsertSysLog(SysLog sysLog) throws Exception;

	/**
	 * 시스템 로그정보를 요약한다.
	 *
	 * @param
	 */
	public void logInsertSysLogSummary() throws Exception;

	/**
	 * 시스템로그를 조회한다.
	 *
	 * @param sysLog
	 * @return sysLog
	 * @throws Exception
	 */
	public SysLog selectSysLog(SysLog sysLog) throws Exception;

	/**
	 * 시스템 로그정보 목록을 조회한다.
	 *
	 * @param SysLog
	 */
	public Map<?, ?> selectSysLogInf(SysLog sysLog) throws Exception;

}
