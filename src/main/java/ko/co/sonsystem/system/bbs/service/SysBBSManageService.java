package ko.co.sonsystem.system.bbs.service;

import java.util.Map;

/**
 * 게시물 관리를 위한 서비스 인터페이스  클래스
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
public interface SysBBSManageService {

	/**
	 * 게시물 한 건을 삭제 한다.
	 * 
	 * @param Board
	 * @exception Exception Exception
	 */
	public void deleteBoardArticle(Board Board)
	  throws Exception;

	/**
	 * 방명록 내용을 삭제 한다.
	 * 
	 * @param boardVO
	 * @exception Exception Exception
	 */
	public void deleteGuestList(BoardVO boardVO)
	  throws Exception;

	/**
	 * 방명록에 대한 패스워드를 조회 한다.
	 * @return
	 * 
	 * @param Board
	 * @exception Exception Exception
	 */
	public String getPasswordInf(Board Board)
	  throws Exception;

	/**
	 * 게시판에 게시물 또는 답변 게시물을 등록 한다.
	 * 
	 * @param Board
	 * @exception Exception Exception
	 */
	public void insertBoardArticle(Board Board)
	  throws Exception;

	/**
	 * 게시물 대하여 상세 내용을 조회 한다.
	 * @return
	 * 
	 * @param boardVO
	 * @exception Exception Exception
	 */
	public BoardVO selectBoardArticle(BoardVO boardVO)
	  throws Exception;

	/**
	 * 조건에 맞는 게시물 목록을 조회 한다.
	 * @return
	 * 
	 * @param boardVO
	 * @param attrbFlag
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectBoardArticles(BoardVO boardVO, String attrbFlag)
	  throws Exception;

	/**
	 * 방명록에 대한 목록을 조회 한다.
	 * @return
	 * 
	 * @param boardVO
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectGuestList(BoardVO boardVO)
	  throws Exception;

	/**
	 * 게시물 한 건의 내용을 수정 한다.
	 * 
	 * @param Board
	 * @exception Exception Exception
	 */
	public void updateBoardArticle(Board Board)
	  throws Exception;

}