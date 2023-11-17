package ko.co.sonsystem.system.log.loginlog.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import ko.co.sonsystem.system.log.loginlog.service.LoginLog;

/**
 * 시스템 로그 관리를 위한 데이터 접근 클래스
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
@Repository("sysLoginLogDAO")
public class SysLoginLogDAO extends EgovAbstractMapper {

	/**
	 * 접속로그를 기록한다.
	 *
	 * @param LoginLog
	 * @return
	 * @throws Exception
	 */
	public void logInsertLoginLog(LoginLog loginLog) throws Exception{
		insert("LoginLogDAO.logInsertLoginLog", loginLog);
	}

	/**
	 * 접속로그를 조회한다.
	 *
	 * @param loginLog
	 * @return loginLog
	 * @throws Exception
	 */
	public LoginLog selectLoginLog(LoginLog loginLog) throws Exception{

		return (LoginLog) selectOne("LoginLogDAO.selectLoginLog", loginLog);
	}

	/**
	 * 접속로그를 목록을 조회한다.
	 *
	 * @param loginLog
	 * @return
	 * @throws Exception
	 */
	public List<?> selectLoginLogInf(LoginLog loginLog) throws Exception{
		return list("LoginLogDAO.selectLoginLogInf", loginLog);
	}

	/**
	 * 접속로그 목록의 숫자를 조회한다.
	 * @param loginLog
	 * @return
	 * @throws Exception
	 */
	public int selectLoginLogInfCnt(LoginLog loginLog) throws Exception{

		return (Integer)selectOne("LoginLogDAO.selectLoginLogInfCnt", loginLog);
	}

}
