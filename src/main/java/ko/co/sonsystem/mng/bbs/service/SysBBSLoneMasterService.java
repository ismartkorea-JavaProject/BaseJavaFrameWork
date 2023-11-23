package ko.co.sonsystem.mng.bbs.service;

import java.util.Map;

/**
 * 게시판 속성관리를 위한 서비스 인터페이스 클래스
 * @author s-onsystem
 * @since 2023.11.16
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2023.11.16  jeong          최초 생성
 *  
 *  </pre>
 */
public interface SysBBSLoneMasterService {

	/**
	 * 등록된 게시판 속성정보를 삭제한다.
	 * @param BoardMaster
	 * 
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public void deleteMaster(BoardMaster boardMaster)
	  throws Exception;

	/**
	 * 신규 게시판 속성정보를 생성한다.
	 * @param BoardMaster
	 * 
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public String insertMaster(BoardMaster boardMaster)
	  throws Exception;

	/**
	 * 게시판 속성정보 한 건을 상세조회한다.
	 * @param BoardMasterVO
	 * 
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public BoardMasterVO selectMaster(BoardMaster searchVO)
	  throws Exception;

	/**
	 * 게시판 속성 정보의 목록을 조회 한다.
	 * @param BoardMasterVO
	 * 
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectMasterList(BoardMasterVO searchVO)
	  throws Exception;

	/**
	 * 게시판 속성정보를 수정한다.
	 * @param BoardMaster
	 * 
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public void updateMaster(BoardMaster boardMaster)
	  throws Exception;

}