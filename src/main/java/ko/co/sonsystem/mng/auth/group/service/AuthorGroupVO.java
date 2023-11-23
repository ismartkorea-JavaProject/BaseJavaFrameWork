package ko.co.sonsystem.mng.auth.group.service;

import java.util.List;

/**
 * 권한그룹에 대한 Vo 클래스를 정의한다.
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

public class AuthorGroupVO extends AuthorGroup {

	private static final long serialVersionUID = 1L;

	List <AuthorGroupVO> authorGroupList;

	/**
	 * authorGroupList attribute 를 리턴한다.
	 * @return List<AuthorGroupVO>
	 */
	public List<AuthorGroupVO> getAuthorGroupList() {
		return authorGroupList;
	}
	/**
	 * authorGroupList attribute 값을 설정한다.
	 * @param authorGroupList List<AuthorGroupVO> 
	 */
	public void setAuthorGroupList(List<AuthorGroupVO> authorGroupList) {
		this.authorGroupList = authorGroupList;
	}


}