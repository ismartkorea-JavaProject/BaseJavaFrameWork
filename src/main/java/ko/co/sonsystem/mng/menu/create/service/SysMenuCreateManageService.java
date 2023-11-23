package ko.co.sonsystem.mng.menu.create.service;

import java.util.List;

import egovframework.com.cmm.ComDefaultVO;


/**
 * 메뉴관리에 관한 서비스 인터페이스 클래스를 정의한다.
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
public interface SysMenuCreateManageService {

	/**
	 * ID 존재여부를 조회
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
	int selectUsrByPk(ComDefaultVO vo) throws Exception;

	/**
	 * ID에 대한 권한코드를 조회
	 * @param vo ComDefaultVO
	 * @return List
	 * @exception Exception
	 */
	MenuCreatVO selectAuthorByUsr(ComDefaultVO vo) throws Exception;


	/**
	 * 메뉴생성관리 목록을 조회
	 * @param vo ComDefaultVO
	 * @return List
	 * @exception Exception
	 */
	List<?> selectMenuCreatManagList(ComDefaultVO vo) throws Exception;

	/**
	 * 메뉴생성관리 총건수를 조회한다.
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
	int selectMenuCreatManagTotCnt(ComDefaultVO vo) throws Exception;

	/**
	 * 메뉴생성 내역을 조회
	 * @param  vo MenuCreatVO
	 * @return List
	 * @exception Exception
	 */
	List<?> selectMenuCreatList(MenuCreatVO vo) throws Exception;


	/**
	 * 화면에 조회된 메뉴정보로 메뉴생성내역 데이터베이스에서 입력
	 * @param checkedScrtyForInsert String
	 * @param checkedMenuNoForInsert String
	 * @exception Exception
	 */
	void insertMenuCreatList(String checkedScrtyForInsert, String checkedMenuNoForInsert) throws Exception;

}
