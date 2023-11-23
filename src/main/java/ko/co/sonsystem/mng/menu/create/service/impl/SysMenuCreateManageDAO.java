package ko.co.sonsystem.mng.menu.create.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import egovframework.com.cmm.ComDefaultVO;
import ko.co.sonsystem.mng.menu.create.service.MenuCreatVO;

/**
 * 메뉴생성, 사이트맵 생성에 대한 DAO 클래스를 정의한다. *
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

@Repository("sysMenuCreateManageDAO")
public class SysMenuCreateManageDAO extends EgovAbstractMapper{



	/**
	 * ID 존재여부를 조회
	 * @param vo MenuManageVO
	 * @return int
	 * @exception Exception
	 */
	public int selectUsrByPk(ComDefaultVO vo) throws Exception{
		return (Integer)selectOne("menuManageDAO.selectUsrByPk", vo);
	}

	/**
	 * ID에 대한 권한코드를 조회
	 * @param vo MenuCreatVO
	 * @return int
	 * @exception Exception
	 */
	public MenuCreatVO selectAuthorByUsr(ComDefaultVO vo) throws Exception{
		return (MenuCreatVO)selectOne("menuManageDAO.selectAuthorByUsr", vo);
	}

	/**
	 * 메뉴생성관리 내역을 조회
	 * @param vo ComDefaultVO
	 * @return List
	 * @exception Exception
	 */
	public List<?> selectMenuCreatManagList(ComDefaultVO vo) throws Exception{
		return list("menuManageDAO.selectMenuCreatManageList_D", vo);
	}

	/**
	 * 메뉴생성관리 총건수를 조회한다.
	 * @param vo ComDefaultVO
	 * @return int
	 * @exception Exception
	 */
    public int selectMenuCreatManagTotCnt(ComDefaultVO vo) {
        return (Integer)selectOne("menuManageDAO.selectMenuCreatManageTotCnt_S", vo);
    }

    /*********** 메뉴 생성 관리 ***************/
	/**
	 * 메뉴생성 내역을 조회
	 * @param vo MenuCreatVO
	 * @return List
	 * @exception Exception
	 */
	public List<?> selectMenuCreatList(MenuCreatVO vo) throws Exception{
		return list("menuManageDAO.selectMenuCreatList_D", vo);
	}

	/**
	 * 메뉴생성내역 등록
	 * @param vo MenuCreatVO
	 * @exception Exception
	 */
	public void insertMenuCreat(MenuCreatVO vo){
		insert("menuManageDAO.insertMenuCreat_S", vo);
	}


	/**
	 * 메뉴생성내역 존재여부 조회한다.
	 * @param vo MenuCreatVO
	 * @return int
	 * @exception Exception
	 */
    public int selectMenuCreatCnt(MenuCreatVO vo) {
        return (Integer)selectOne("menuManageDAO.selectMenuCreatCnt_S", vo);
    }


	/**
	 * 메뉴생성내역 수정
	 * @param vo MenuCreatVO
	 * @exception Exception
	 */
	public void updateMenuCreat(MenuCreatVO vo){
		update("menuManageDAO.updateMenuCreat_S", vo);
	}

	/**
	 * 메뉴생성내역 삭제
	 * @param vo MenuCreatVO
	 * @exception Exception
	 */
	public void deleteMenuCreat(MenuCreatVO vo){
		delete("menuManageDAO.deleteMenuCreat_S", vo);
	}


}
