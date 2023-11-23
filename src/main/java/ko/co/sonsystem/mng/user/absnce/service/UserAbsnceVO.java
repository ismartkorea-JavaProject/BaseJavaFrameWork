package ko.co.sonsystem.mng.user.absnce.service;

import java.util.List;
/**
 * 사용자부재에 대한 Vo 클래스를 정의한다.
 * 사용자부재의 목록 항목을 관리한다.
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
public class UserAbsnceVO extends UserAbsnce {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * 사용자부재 목록
	 */
	List<UserAbsnceVO> userAbsnceList;
	/**
	 * 삭제대상 목록
	 */
	String[] delYn;
	/**
	 * 부재여부 조회조건
	 */	
	String selAbsnceAt;
	
	/**
	 * @return the userAbsnceList
	 */
	public List<UserAbsnceVO> getUserAbsnceList() {
		return userAbsnceList;
	}
	/**
	 * @param userAbsnceList the userAbsnceList to set
	 */
	public void setUserAbsnceList(List<UserAbsnceVO> userAbsnceList) {
		this.userAbsnceList = userAbsnceList;
	}
	/**
	 * @return the delYn
	 */
	public String[] getDelYn() {
		return delYn;
	}
	/**
	 * @param delYn the delYn to set
	 */
	public void setDelYn(String[] delYn) {
		this.delYn = delYn;
	}
	/**
	 * @return the selAbsnceAt
	 */
	public String getSelAbsnceAt() {
		return selAbsnceAt;
	}
	/**
	 * @param selAbsnceAt the selAbsnceAt to set
	 */
	public void setSelAbsnceAt(String selAbsnceAt) {
		this.selAbsnceAt = selAbsnceAt;
	}
	

	
	
}
