package ko.co.sonsystem.mng.menu.create.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.ComDefaultVO;
import ko.co.sonsystem.mng.menu.create.service.MenuCreatVO;
import ko.co.sonsystem.mng.menu.create.service.SysMenuCreateManageService;

/**
 * 메뉴목록, 사이트맵 생성을 처리하는 비즈니스 구현 클래스를 정의한다.
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
@Service("sysMeunCreateManageService")
public class SysMenuCreateManageServiceImpl extends EgovAbstractServiceImpl implements SysMenuCreateManageService {

	@Resource(name = "sysMenuCreateManageDAO")
	private SysMenuCreateManageDAO menuCreateManageDAO;

	/**
	 * ID 존재여부를 조회
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
	@Override
	public int selectUsrByPk(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectUsrByPk(vo);
	}

	/**
	 * 메뉴생성 내역을 조회
	 * @param  vo MenuCreatVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<?> selectMenuCreatList(MenuCreatVO vo) throws Exception {
		return menuCreateManageDAO.selectMenuCreatList(vo);
	}

	/**
	 * 화면에 조회된 메뉴정보로 메뉴생성내역 데이터베이스에서 입력
	 * @param checkedAuthorForInsert  String
	 * @param checkedMenuNoForInsert String
	 * @exception Exception
	 */
	@Override
	public void insertMenuCreatList(String checkedAuthorForInsert, String checkedMenuNoForInsert) throws Exception {
		MenuCreatVO menuCreatVO = null;
		int AuthorCnt = 0;
		String[] insertMenuNo = checkedMenuNoForInsert.split(",");

		String insertAuthor = checkedAuthorForInsert;
		menuCreatVO = new MenuCreatVO();
		menuCreatVO.setAuthorCode(insertAuthor);
		AuthorCnt = menuCreateManageDAO.selectMenuCreatCnt(menuCreatVO);

		// 이전에 존재하는 권한코드에 대한 메뉴설정내역 삭제
		if (AuthorCnt > 0) {
			menuCreateManageDAO.deleteMenuCreat(menuCreatVO);
		}
		for (int i = 0; i < insertMenuNo.length; i++) {
			menuCreatVO.setAuthorCode(insertAuthor);
			menuCreatVO.setMenuNo(Integer.parseInt(insertMenuNo[i]));
			menuCreateManageDAO.insertMenuCreat(menuCreatVO);
		}
	}

	/**
	 * 메뉴생성관리 목록을 조회
	 * @param vo ComDefaultVO
	 * @return List
	 * @exception Exception
	 */
	@Override
	public List<?> selectMenuCreatManagList(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectMenuCreatManagList(vo);
	}

	/**
	 * ID에 대한 권한코드를 조회
	 * @param vo ComDefaultVO
	 * @return MenuCreatVO
	 * @exception Exception
	 */
	@Override
	public MenuCreatVO selectAuthorByUsr(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectAuthorByUsr(vo);
	}

	/**
	 * 메뉴생성관리 총건수를 조회한다.
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
	@Override
	public int selectMenuCreatManagTotCnt(ComDefaultVO vo) throws Exception {
		return menuCreateManageDAO.selectMenuCreatManagTotCnt(vo);
	}

}
