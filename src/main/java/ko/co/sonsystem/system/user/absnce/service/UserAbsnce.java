package ko.co.sonsystem.system.user.absnce.service;

import egovframework.com.cmm.ComDefaultVO;
/**
 * 사용자부재에 대한 model 클래스를 정의한다.
 * 사용자부재의 사용자ID, 사용자부재여부 항목을 관리한다.
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
public class UserAbsnce extends ComDefaultVO {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 사용자ID
	 */
	private String userId;
	/**
	 * 사용자명
	 */
	private String userNm;	
	/**
	 * 사용자부재여부
	 */
	private String userAbsnceAt;
	/**
	 * 최종등록자ID
	 */
	private String lastUpdusrId;
	/**
	 * 최종등록시점
	 */
	private String lastUpdusrPnttm;
	/**
	 * 등록여부
	 */
	private String regYn;	

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userNm
	 */
	public String getUserNm() {
		return userNm;
	}
	/**
	 * @param userNm the userNm to set
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	/**
	 * @return the userAbsnceAt
	 */
	public String getUserAbsnceAt() {
		return userAbsnceAt;
	}
	/**
	 * @param userAbsnceAt the userAbsnceAt to set
	 */
	public void setUserAbsnceAt(String userAbsnceAt) {
		this.userAbsnceAt = userAbsnceAt;
	}
	/**
	 * @return the lastUpdusrId
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}
	/**
	 * @param lastUpdusrId the lastUpdusrId to set
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}
	/**
	 * @return the lastUpdusrPnttm
	 */
	public String getLastUpdusrPnttm() {
		return lastUpdusrPnttm;
	}
	/**
	 * @param lastUpdusrPnttm the lastUpdusrPnttm to set
	 */
	public void setLastUpdusrPnttm(String lastUpdusrPnttm) {
		this.lastUpdusrPnttm = lastUpdusrPnttm;
	}
	/**
	 * @return the regYn
	 */
	public String getRegYn() {
		return regYn;
	}
	/**
	 * @param regYn the regYn to set
	 */
	public void setRegYn(String regYn) {
		this.regYn = regYn;
	}
}
